package com.bookbucket.app.iotdemoui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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

public class RegistrationForm extends AppCompatActivity {

    EditText firstName, lastName, email, password, address, profession, contactNo;
    Button submitRegistration;

//    String submitURL = "http://192.168.0.104/IoT/PHP/insertUser.php";
    String submitURL = "http://bcszone.com/iot/insertUser.php";

    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);

        // init xml res with java object
        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        address = (EditText) findViewById(R.id.address);
        profession = (EditText) findViewById(R.id.profession);
        contactNo = (EditText) findViewById(R.id.contactNo);



        submitRegistration = (Button) findViewById(R.id.submitRegistration);

        requestQueue = Volley.newRequestQueue(getApplicationContext());

        // handle submit button click
        submitRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

                        parameters.put("firstNameKey", firstName.getText().toString());
                        parameters.put("lastNameKey", lastName.getText().toString());
                        parameters.put("emailKey", email.getText().toString());
                        parameters.put("passwordKey", password.getText().toString());
                        parameters.put("addressKey", address.getText().toString());
                        parameters.put("professionKey", profession.getText().toString());
                        parameters.put("contactNoKey", contactNo.getText().toString());

                        return parameters;
                    }
                };
                requestQueue.add(stringRequest);


                Toast.makeText(getApplicationContext(), "Data Saved Successfully!", Toast.LENGTH_LONG).show();
                // Start LoginActivity.class
                Intent myIntent = new Intent(RegistrationForm.this, LoginActivity.class);
                myIntent.putExtra("headlineMessage","Congratulations !!");
                startActivity(myIntent);
                finish();
            }
        });
    }
}
