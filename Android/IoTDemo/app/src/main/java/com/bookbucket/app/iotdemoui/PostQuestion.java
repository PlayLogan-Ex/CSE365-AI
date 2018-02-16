package com.bookbucket.app.iotdemoui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class PostQuestion extends AppCompatActivity {

    EditText questionText, tag, type;
//    String submitURL = "http://192.168.0.104/IoT/PHP/postQuestion.php";
    String submitURL = "http://bcszone.com/iot/postQuestion.php";
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_question);

        // init (xml res with java object)
        questionText = (EditText) findViewById(R.id.questionText);
        tag = (EditText) findViewById(R.id.tag);
        type = (EditText) findViewById(R.id.type);

        requestQueue = Volley.newRequestQueue(getApplicationContext());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_post_question, menu);
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

    public void postQuestion(View view) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                submitURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parameters  = new HashMap<String, String>();

                parameters.put("questionTextKey", questionText.getText().toString());
                parameters.put("tagKey", tag.getText().toString());
                parameters.put("typeKey", type.getText().toString());

                return parameters;
            }
        };
        requestQueue.add(stringRequest);

        Toast.makeText(getApplicationContext(), "Question posted successfully", Toast.LENGTH_LONG).show();
        Intent myIntent = new Intent(PostQuestion.this, MainActivity.class);
        startActivity(myIntent);
        finish();
    }
}
