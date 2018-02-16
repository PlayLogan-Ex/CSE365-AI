package com.bookbucket.app.iotdemoui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UserProfile extends AppCompatActivity {

    TextView name, email, contactNo, researchArea, hobby, address;
    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        // To retrieve object in second Activity
        //User user = (User) getIntent().getSerializableExtra("User");

        name = (TextView) findViewById(R.id.name);
        email = (TextView) findViewById(R.id.email);
        contactNo = (TextView) findViewById(R.id.contactNo);
        researchArea = (TextView) findViewById(R.id.researchArea);
        address = (TextView) findViewById(R.id.address);
        hobby = (TextView) findViewById(R.id.hobby);

//        name.setText(user.firstName + " " + user.lastName);
//        email.setText(user.email);
//        contactNo.setText(user.contactNo);
//        researchArea.setText(user.researchArea);
//        address.setText(user.address);
//        hobby.setText(user.hobby);
    }


    public void update(View view) {
        Toast.makeText(getApplicationContext(), "Update Clicked!", Toast.LENGTH_LONG).show();
        Intent myIntent = new Intent(UserProfile.this, UpdateUserProfile.class);
        startActivity(myIntent);
        finish();
    }

    public void home(View view) {
        Toast.makeText(getApplicationContext(), "Home Clicked!", Toast.LENGTH_LONG).show();
        Intent myIntent = new Intent(UserProfile.this, MainActivity.class);
        startActivity(myIntent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_profile, menu);
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
