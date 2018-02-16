package com.signoffour.apps.controlcommentview;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.signoffour.apps.controlcommentview.models.Answer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // CONNECTION_TIMEOUT and READ_TIMEOUT are in milliseconds
    public static final int CONNECTION_TIMEOUT = 10000;
    public static final int READ_TIMEOUT = 15000;

    private ListView answerList;
    TextView question;
    private final String URL_TO_HIT = "http://192.168.0.101/IoT/PHP/controllers/RetrieveAnswerComment.php";
    private ListView lvMovies;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = new ProgressDialog(this);
        dialog.setIndeterminate(true);
        dialog.setCancelable(false);
        dialog.setMessage("Loading. Please wait...");

        answerList = (ListView) findViewById(R.id.answerList);

        // To start fetching the data when app start, uncomment below line to start the async task.
        new JSONTask("1").execute(URL_TO_HIT);
    }

//    public void viewAllReplies(View view) {
//
//        String value = null;
//
//        Toast.makeText(getApplicationContext(), "View All Clicked... " + value, Toast.LENGTH_SHORT).show();
//    }


    public class JSONTask extends AsyncTask<String, String, List<Answer>> {

        HttpURLConnection conn;
        URL url = null;
        String searchQuery;

        public JSONTask(String searchQuery){
            this.searchQuery=searchQuery;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.show();
        }

        @Override
        protected List<Answer> doInBackground(String... params) {
            HttpURLConnection connection = null;

            try {

                url = new URL(URL_TO_HIT);

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } try {

                // Setup HttpURLConnection class to send and receive data from php and mysql
                conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(READ_TIMEOUT);
                conn.setConnectTimeout(CONNECTION_TIMEOUT);
                conn.setRequestMethod("POST");

                // setDoInput and setDoOutput to true as we send and receive data
                conn.setDoInput(true);
                conn.setDoOutput(true);

                // add parameter to our above url
                Uri.Builder builder = new Uri.Builder().appendQueryParameter("questionIDKey", searchQuery);
                String query = builder.build().getEncodedQuery();

                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                writer.write(query);
                writer.flush();
                writer.close();
                os.close();
                conn.connect();

            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            try {

                int response_code = conn.getResponseCode();

                // Check if successful connection made
                if (response_code == HttpURLConnection.HTTP_OK) {

                    // Read data sent from server
                    InputStream input = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }

                    String finalJson = result.toString();

                    JSONObject parentObject = new JSONObject(finalJson);
                    JSONArray parentArray = parentObject.getJSONArray("answers");

                    List<Answer> answerList = new ArrayList<>();

                    for (int i = 0; i < parentArray.length(); i++) {
                        JSONObject finalObject = parentArray.getJSONObject(i);

                        Answer answer = new Answer();
                        answer.setAnswerID((int) finalObject.getInt("answerID"));
                        answer.setAnswererName(finalObject.getString("answerHolder"));
                        answer.setAnswerText(finalObject.getString("answerText"));

                        List<Answer.Comment> commentList = new ArrayList<>();
                        for (int j = 0; j < finalObject.getJSONArray("comments").length(); j++) {
                            Answer.Comment comment = new Answer.Comment();
                            comment.setCommentText(finalObject.getJSONArray("comments").getJSONObject(j).getString("commentText"));
                            commentList.add(comment);
                        }
                        answer.setCommentList(commentList);
                        // adding the final object in the list
                        answerList.add(answer);
                    }
                    return answerList;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(final List<Answer> result) {
            super.onPostExecute(result);
            dialog.dismiss();
            if (result != null) {
                AnswerAdapter adapter = new AnswerAdapter(getApplicationContext(), R.layout.list_item_ac, result);
                answerList.setAdapter(adapter);
                answerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {  // list item click opens a new detailed activity
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Answer answer = result.get(position); // getting the model
                        Toast.makeText(getApplicationContext(), "clicked: " +answer.getAnswererName(), Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(MainActivity.this, ViewAllComment.class);

//                        String testValue = "Testing value...";
//                        intent.putExtra("test", testValue);
                        intent.putExtra("AllReplies",answer);
//                        startActivity(intent);
                        startActivityForResult(intent, 1);

//                        intent.putExtra("answer", new Gson().toJson(answer)); // converting model json into string type and sending it via intent
                    }
                });
            } else {
                Toast.makeText(getApplicationContext(), "Not able to fetch data from server, please check url.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public class AnswerAdapter extends ArrayAdapter {

        private List<Answer> answerList;
        private int resource;
        private LayoutInflater inflater;

        public AnswerAdapter(Context context, int resource, List<Answer> objects) {
            super(context, resource, objects);
            answerList = objects;
            this.resource = resource;
            inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;

            if (convertView == null) {
                holder = new ViewHolder();
                convertView = inflater.inflate(resource, null);

                // init part
                // layout
                holder.llComment1Area = convertView.findViewById(R.id.llComment1Area);

                // answer
                holder.ivThumbUpAnswer = convertView.findViewById(R.id.ivThumbUpAnswer);
                holder.ivThumbDownAnswer = convertView.findViewById(R.id.ivThumbDownAnswer);

                holder.tvAnswererName = convertView.findViewById(R.id.tvAnswererName);
                holder.tvAnswerTime = convertView.findViewById(R.id.tvAnswerText);
                holder.tvAnswerText = convertView.findViewById(R.id.tvAnswerText);
                holder.tvTotalThumbUpOfAnswer = convertView.findViewById(R.id.tvTotalThumbUpOfAnswer);
                holder.tvTotalThumbDownOfAnswer = convertView.findViewById(R.id.tvTotalThumbDownOfAnswer);
                holder.tvTotalCommentOfAnswer = convertView.findViewById(R.id.tvTotalCommentOfAnswer);
                // comment 1
                holder.ivThumbUpComment1 = convertView.findViewById(R.id.ivThumbUpComment1);
                holder.ivThumbDownComment1 = convertView.findViewById(R.id.ivThumbDownComment1);

                holder.tvCommenter1Name = convertView.findViewById(R.id.tvCommenter1Name);
                holder.tvCommenter1Time = convertView.findViewById(R.id.tvCommenter1Time);
                holder.tvCommenter1Text = convertView.findViewById(R.id.tvCommenter1Text);
                holder.tvTotalThumbUpOfComment1 = convertView.findViewById(R.id.tvTotalThumbUpOfComment1);
                holder.tvTotalThumbDownOfComment1 = convertView.findViewById(R.id.tvTotalThumbDownOfComment1);
                // comment 2
                holder.ivThumbUpComment2 = convertView.findViewById(R.id.ivThumbUpComment2);
                holder.ivThumbDownComment2 = convertView.findViewById(R.id.ivThumbDownComment2);

                holder.ivCommenter2 = convertView.findViewById(R.id.ivCommenter2);
                holder.tvCommenter2Name = convertView.findViewById(R.id.tvCommenter2Name);
                holder.tvCommenter2Time = convertView.findViewById(R.id.tvCommenter2Time);
                holder.tvCommenter2Text = convertView.findViewById(R.id.tvCommenter2Text);
                holder.tvTotalThumbUpOfComment2 = convertView.findViewById(R.id.tvTotalThumbUpOfComment2);
                holder.tvTotalThumbDownOfComment2 = convertView.findViewById(R.id.tvTotalThumbDownOfComment2);
                // for hiding layout
                holder.llCommentArea = convertView.findViewById(R.id.llCommentArea);
                holder.llComment1Area = convertView.findViewById(R.id.llComment1Area);
                holder.llComment2Area = convertView.findViewById(R.id.llComment2Area);

                holder.viewAllComment = convertView.findViewById(R.id.viewAllComment);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            StringBuffer tvCommenter1Name = new StringBuffer();
            StringBuffer tvCommenter1Time = new StringBuffer();
            StringBuffer tvCommenter1Text = new StringBuffer();
            StringBuffer tvTotalThumbUpOfComment1 = new StringBuffer();
            StringBuffer tvTotalThumbDownOfComment1 = new StringBuffer();

            StringBuffer tvCommenter2Name = new StringBuffer();
            StringBuffer tvCommenter2Time = new StringBuffer();
            StringBuffer tvCommenter2Text = new StringBuffer();
            StringBuffer tvTotalThumbUpOfComment2 = new StringBuffer();
            StringBuffer tvTotalThumbDownOfComment2 = new StringBuffer();

            int counter = 0;
            for (Answer.Comment comment : answerList.get(position).getCommentList()) {
                if (counter == 0) {
                    tvCommenter1Name.append(comment.getCommenterName());
                    tvCommenter1Time.append(comment.getCommentTime());
                    tvCommenter1Text.append(comment.getCommentText());
                    tvTotalThumbUpOfComment1.append(comment.getTotalThumbUp());
                    tvTotalThumbDownOfComment1.append(comment.getTotalThumbDown());
                } else if (counter == 1) {
                    tvCommenter2Name.append(comment.getCommenterName());
                    tvCommenter2Time.append(comment.getCommentTime());
                    tvCommenter2Text.append(comment.getCommentText());
                    tvTotalThumbUpOfComment2.append(comment.getTotalThumbUp());
                    tvTotalThumbDownOfComment2.append(comment.getTotalThumbDown());
                }
                counter++;
            }

            int numOfComment = answerList.get(position).getCommentList().size();
            if (numOfComment == 0) {
                // dynamic value changing: answer
                holder.tvAnswererName.setText(answerList.get(position).getAnswererName());
                holder.tvAnswerTime.setText(answerList.get(position).getAnswerTime());
                holder.tvAnswerText.setText(answerList.get(position).getAnswerText());

                holder.llCommentArea.setVisibility(View.GONE);
            } else if (numOfComment == 1){
                // dynamic value changing: answer
                holder.tvAnswererName.setText(answerList.get(position).getAnswererName());
                holder.tvAnswerTime.setText(answerList.get(position).getAnswerTime());
                holder.tvAnswerText.setText(answerList.get(position).getAnswerText());

                // dynamic value changing: comment 1
                holder.tvCommenter1Name.setText(tvCommenter1Name);
                holder.tvCommenter1Time.setText(tvCommenter1Time);
                holder.tvCommenter1Text.setText(tvCommenter1Text);
                holder.tvTotalThumbUpOfComment1.setText(tvTotalThumbUpOfComment1);
                holder.tvTotalThumbDownOfComment1.setText(tvTotalThumbDownOfComment1);

                // hide comment 2 and view all
                holder.llComment2Area.setVisibility(View.GONE);
                holder.viewAllComment.setVisibility(View.GONE);
            } else if (numOfComment == 2){
                // dynamic value changing: answer
                holder.tvAnswererName.setText(answerList.get(position).getAnswererName());
                holder.tvAnswerTime.setText(answerList.get(position).getAnswerTime());
                holder.tvAnswerText.setText(answerList.get(position).getAnswerText());

                // dynamic value changing: comment 1
                holder.tvCommenter1Name.setText(tvCommenter1Name);
                holder.tvCommenter1Time.setText(tvCommenter1Time);
                holder.tvCommenter1Text.setText(tvCommenter1Text);
                holder.tvTotalThumbUpOfComment1.setText(tvTotalThumbUpOfComment1);
                holder.tvTotalThumbDownOfComment1.setText(tvTotalThumbDownOfComment1);
                // dynamic value changing: comment 2
                holder.tvCommenter2Name.setText(tvCommenter2Name);
                holder.tvCommenter2Time.setText(tvCommenter2Time);
                holder.tvCommenter2Text.setText(tvCommenter2Text);
                holder.tvTotalThumbUpOfComment2.setText(tvTotalThumbUpOfComment2);
                holder.tvTotalThumbDownOfComment2.setText(tvTotalThumbDownOfComment2);

                // hide comment 2 and view all
                holder.viewAllComment.setVisibility(View.GONE);
            } else if (numOfComment > 2){
                // dynamic value changing: answer
                holder.tvAnswererName.setText(answerList.get(position).getAnswererName());
                holder.tvAnswerTime.setText(answerList.get(position).getAnswerTime());
                holder.tvAnswerText.setText(answerList.get(position).getAnswerText());
                // dynamic value changing: comment 1
                holder.tvCommenter1Name.setText(tvCommenter1Name);
                holder.tvCommenter1Time.setText(tvCommenter1Time);
                holder.tvCommenter1Text.setText(tvCommenter1Text);
                holder.tvTotalThumbUpOfComment1.setText(tvTotalThumbUpOfComment1);
                holder.tvTotalThumbDownOfComment1.setText(tvTotalThumbDownOfComment1);
                // dynamic value changing: comment 2
                holder.tvCommenter2Name.setText(tvCommenter2Name);
                holder.tvCommenter2Time.setText(tvCommenter2Time);
                holder.tvCommenter2Text.setText(tvCommenter2Text);
                holder.tvTotalThumbUpOfComment2.setText(tvTotalThumbUpOfComment2);
                holder.tvTotalThumbDownOfComment2.setText(tvTotalThumbDownOfComment2);

                holder.viewAllComment.setText("VIEW ALL " + numOfComment + " REPLIES");
            }

            holder.tvTotalThumbDownOfComment2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String commentText = answerList.get(position).getCommentList().get(1).getCommentText();
                    Toast.makeText(getApplicationContext(), "Comment, thumb : " + commentText, Toast.LENGTH_LONG).show();
                }
            });

            holder.tvTotalThumbDownOfComment2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String commentText = answerList.get(position).getCommentList().get(1).getCommentText();
                    Toast.makeText(getApplicationContext(), "Comment, thumb : " + commentText, Toast.LENGTH_LONG).show();
                }
            });

            holder.ivThumbUpAnswer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String answerText = answerList.get(position).getAnswerText();
                    Toast.makeText(getApplicationContext(), "answer, thumb up: " + answerText, Toast.LENGTH_LONG).show();
                }
            });

            holder.ivThumbDownAnswer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String answerText = answerList.get(position).getAnswerText();
                    Toast.makeText(getApplicationContext(), "Answer, thumb down: " + answerText, Toast.LENGTH_LONG).show();
                }
            });

            holder.ivThumbUpComment1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String commentText = answerList.get(position).getCommentList().get(0).getCommentText();
                    Toast.makeText(getApplicationContext(), "Comment1, thumb up: " + commentText, Toast.LENGTH_LONG).show();
                }
            });

            holder.ivThumbDownComment1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String commentText = answerList.get(position).getCommentList().get(0).getCommentText();
                    Toast.makeText(getApplicationContext(), "Comment1, thumb down: " + commentText, Toast.LENGTH_LONG).show();
                }
            });

            holder.ivThumbUpComment2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String commentText = answerList.get(position).getCommentList().get(1).getCommentText();
                    Toast.makeText(getApplicationContext(), "Comment2, thumb up: " + commentText, Toast.LENGTH_LONG).show();
                }
            });

            holder.ivThumbDownComment2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String commentText = answerList.get(position).getCommentList().get(1).getCommentText();
                    Toast.makeText(getApplicationContext(), "Comment2, thumb down: " + commentText, Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(), "Comment2, thumb down: " + commentText, Toast.LENGTH_LONG).show();
                }
            });

            // So much interesting part for controlling click event area
            // click on comment1 area & comment2 area then observe result
            // After observing you know, how to multi part from list item.
            holder.llComment1Area.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), "llComment1 Area Clicked!", Toast.LENGTH_LONG).show();
                }
            });

            return convertView;
        }

        class ViewHolder {

            // linear layout for hiding comment area
            private LinearLayout llCommentArea, llComment1Area, llComment2Area;
            // answer field
            private ImageView ivAnswerer, ivThumbUpAnswer, ivThumbDownAnswer, ivCommentAnswer;
            private TextView tvAnswererName, tvAnswerTime, tvAnswerText, tvTotalThumbUpOfAnswer, tvTotalThumbDownOfAnswer, tvTotalCommentOfAnswer;
            // comment 1 field
            private ImageView ivCommenter1, ivThumbUpComment1, ivThumbDownComment1;
            private TextView tvCommenter1Name, tvCommenter1Time, tvCommenter1Text, tvTotalThumbUpOfComment1, tvTotalThumbDownOfComment1;
            // comment 2 field
            private ImageView ivCommenter2, ivThumbUpComment2, ivThumbDownComment2;
            private TextView tvCommenter2Name, tvCommenter2Time, tvCommenter2Text, tvTotalThumbUpOfComment2, tvTotalThumbDownOfComment2;
            // view all replies
            private TextView viewAllComment;
        }
    }
}