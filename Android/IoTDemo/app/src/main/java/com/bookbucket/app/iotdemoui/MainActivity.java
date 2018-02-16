package com.bookbucket.app.iotdemoui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void viewQuestions(View view) {
        Toast.makeText(getApplicationContext(), "View Questions  Clicked!", Toast.LENGTH_SHORT).show();

        // Start QAActivity.class
        Intent myIntent = new Intent(MainActivity.this, Search.class);
        startActivity(myIntent);
    }

    public void askQuestion(View view) {
        Toast.makeText(getApplicationContext(), "Ask Question  Clicked!", Toast.LENGTH_SHORT).show();
        // Start PostQuestion.class
        Intent myIntent = new Intent(MainActivity.this, PostQuestion.class);
        startActivity(myIntent);
    }

    public void join(View view) {
        Toast.makeText(getApplicationContext(), "Join  Clicked!", Toast.LENGTH_SHORT).show();
        // Start RegistrationForm.class
        Intent myIntent = new Intent(MainActivity.this, RegistrationForm.class);
        startActivity(myIntent);
    }

    public void singIn(View view) {
        Toast.makeText(getApplicationContext(), "Sing In  Clicked!", Toast.LENGTH_LONG).show();
        Intent myIntent = new Intent(MainActivity.this, LoginActivity.class);
        myIntent.putExtra("headlineMessage","Interactive Online Tutor");
        startActivity(myIntent);
    }
}