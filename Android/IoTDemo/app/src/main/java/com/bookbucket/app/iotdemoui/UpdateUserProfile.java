package com.bookbucket.app.iotdemoui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class UpdateUserProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user_profile);
    }

    public void update(View view) {
        Toast.makeText(getApplicationContext(), "Update Clicked!", Toast.LENGTH_LONG).show();
        Intent myIntent = new Intent(UpdateUserProfile.this, UserProfile.class);
        startActivity(myIntent);
        finish();
    }

    public void cancel(View view) {
        Toast.makeText(getApplicationContext(), "Cancel Clicked!", Toast.LENGTH_LONG).show();
        Intent myIntent = new Intent(UpdateUserProfile.this, UserProfile.class);
        startActivity(myIntent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_update_user_profile, menu);
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
