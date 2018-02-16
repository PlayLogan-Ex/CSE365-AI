package com.bookbucket.app.iotdemoui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bookbucket.app.iotdemoui.models.ComplexData;

import java.util.ArrayList;

public class QAActivity extends AppCompatActivity {

    ListView listView, childListView;
    TextView questionTitle;

    public static String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qa);

        ComplexData cd = (ComplexData) getIntent().getSerializableExtra("obj1");
        String description = getIntent().getStringExtra("description");

        answer = cd.answer1;
        Toast.makeText(getApplication(), "Give your answer", Toast.LENGTH_LONG).show();

        questionTitle = (TextView) findViewById(R.id.questionTitle);
        questionTitle.setText(cd.questionTitle);

        // init parent listview: xml to java
        //listView = (ListView) findViewById(R.id.listView);
        //listView.setAdapter(new CustomAdapter(this));

        // init child listview: xml to java
        childListView = (ListView) findViewById(R.id.childListView);
        childListView.setAdapter(new ChildAdapter(this));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SingleRow obj = CustomAdapter.list.get(position);
                Toast.makeText(QAActivity.this, obj.userName, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void profilePic(View view) {
        Toast.makeText(getApplicationContext(), "Profile Picture Clicked!", Toast.LENGTH_SHORT).show();
    }

    public void iconThumbUp(View view) {
        Toast.makeText(getApplicationContext(), "Liked!", Toast.LENGTH_SHORT).show();
    }

    public void iconThumbDown(View view) {
        Toast.makeText(getApplicationContext(), "Disliked!", Toast.LENGTH_SHORT).show();
    }

    public void iconComment(View view) {
        Toast.makeText(getApplicationContext(), "Comment will be added soon", Toast.LENGTH_SHORT).show();
    }

    public void iconMore(View view) {
        Toast.makeText(getApplicationContext(), "Report not works!", Toast.LENGTH_SHORT).show();
    }

    public void moreReply(View view) {
        Toast.makeText(getApplicationContext(), "More view under construction!", Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_qa, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

class SingleRow {
    int profilePic, thumbUP, thumbDown, more;
    String questionAnswer, userName, time, like, dislike;

    SingleRow(int profilePic, String questionAnswer, String useName, String time) {
        this.profilePic = profilePic;
        this.questionAnswer = questionAnswer;
        this.userName = useName;
        this.time = time;
    }
}

class CustomAdapter extends BaseAdapter {

    // define object array
    public static ArrayList<SingleRow> list;
    Context context;

    CustomAdapter(Context c) {
        context = c;

        // empty list
        list = new ArrayList<SingleRow>();

        // init resources
        int[] profilePic = {R.drawable.amit_sir, R.drawable.sakib, R.drawable.anika, R.drawable.nawrine};
        Resources res = c.getResources();
        String[] questionAnswer = res.getStringArray(R.array.question_answer);
        String[] userName = res.getStringArray(R.array.username);
        String[] time = res.getStringArray(R.array.time);

        // init list
        for (int i = 0; i < 4; i++) {
//            list.add(new SingleRow(profilePic[i], questionAnswer[i], userName[i], time[i]));
            list.add(new SingleRow(profilePic[i], QAActivity.answer, userName[i], time[i]));
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        // ListView optimization 150%
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item, parent, false);
        }

        // convert xml to java object
        ImageView profilePic = (ImageView) view.findViewById(R.id.profilePic);
        TextView questionAnswer = (TextView) view.findViewById(R.id.questionAnswer);
        TextView userName = (TextView) view.findViewById(R.id.userName);
        TextView time = (TextView) view.findViewById(R.id.time);

        SingleRow obj = list.get(position);

        // dynamically change value
        profilePic.setImageResource(obj.profilePic);
        questionAnswer.setText(obj.questionAnswer);
        userName.setText(obj.userName);
        time.setText(obj.time);

        return view;
    }
}

class ChildAdapter extends BaseAdapter {

    // define object array
    public static ArrayList<SingleRow> list;
    Context context;

    ChildAdapter (Context c) {
        context = c;

        // empty list
        list = new ArrayList<SingleRow>();

        // init resources
        int[] profilePic = {R.drawable.amit_sir, R.drawable.sakib, R.drawable.anika, R.drawable.nawrine};
        Resources res = c.getResources();
        String[] questionAnswer = res.getStringArray(R.array.question_answer);
        String[] userName = res.getStringArray(R.array.username);
        String[] time = res.getStringArray(R.array.time);

        // init list
        for (int i = 0; i < 4; i++) {
//            list.add(new SingleRow(profilePic[i], questionAnswer[i], userName[i], time[i]));
            list.add(new SingleRow(profilePic[i], QAActivity.answer, userName[i], time[i]));
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        // ListView optimization 150%
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.child_list_item, parent, false);
        }

        // convert xml to java object
        ImageView profilePic = (ImageView) view.findViewById(R.id.profilePic);
        TextView questionAnswer = (TextView) view.findViewById(R.id.questionAnswer);
        TextView userName = (TextView) view.findViewById(R.id.userName);
        TextView time = (TextView) view.findViewById(R.id.time);

        SingleRow obj = list.get(position);

        // dynamically change value
        profilePic.setImageResource(obj.profilePic);
        questionAnswer.setText(obj.questionAnswer);
        userName.setText(obj.userName);
        time.setText(obj.time);

        return view;
    }
}
