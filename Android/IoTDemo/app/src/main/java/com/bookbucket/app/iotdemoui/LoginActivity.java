package com.bookbucket.app.iotdemoui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;

public class LoginActivity extends AppCompatActivity {

    EditText emailTV, passwordTV;

    TextView headline;
    Button submit;

    String retrieveURL = "http://192.168.0.100/IoTDemoUI_v1.1.0/retrieveSpecificUser.php";
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        String headlineMessage = getIntent().getExtras().getString("headlineMessage");

        // init xml to java object
  //      emailTV = (EditText) findViewById(R.id.email);
    //    passwordTV = (EditText) findViewById(R.id.password);
        headline = (TextView) findViewById(R.id.headline);
//        submit = (Button) findViewById(R.id.submit);

        // set values
        headline.setText(headlineMessage);

        // init RequestQueue
//        requestQueue = Volley.newRequestQueue(getApplicationContext());

//        submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Update Clicked!", Toast.LENGTH_LONG).show();
//                final User[] user = new User[1];
//
//                // data retrieve part from xampp server
//                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, retrieveURL,
//                        new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        System.out.println("-------- " + response.toString() + " --------");
//
//                        try {
//                            JSONArray jsonArray = response.getJSONArray("UserKey");
//                            JSONObject jsonObject = jsonArray.getJSONObject(0);
//
//                            String firstName = jsonObject.getString("firstName");
//                            String lastName = jsonObject.getString("lastName");
//                            String email = jsonObject.getString("email");
//                            String password = jsonObject.getString("password");
//                            String address = jsonObject.getString("address");
//                            String profession = jsonObject.getString("profession");
//                            String contactNo = jsonObject.getString("contactNo");
//                            String researchArea = "";
//                            String hobby = "";
//
//                            user[0] = new User(firstName, lastName, email, password, address, profession, contactNo, researchArea, hobby);
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                    }
//                });
//
//                // start UserProfile.Activity
//                Intent myIntent = new Intent(LoginActivity.this, UserProfile.class);
//                //To pass:
//                myIntent.putExtra("User", user[0]);
//                startActivity(myIntent);
//                finish();
//            }
//        });

    }

    public void submit(View view) {
        Intent myIntent = new Intent(LoginActivity.this, UserProfile.class);
        //To pass:

//        myIntent.putExtra("User", user[0]);
        startActivity(myIntent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
