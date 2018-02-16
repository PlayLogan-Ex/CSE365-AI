package com.signoffour.apps.controlcommentview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.signoffour.apps.controlcommentview.models.Answer;

public class ViewAllComment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_comment);

//        String answer = getIntent().getExtras().getString("test");
//        Answer answer = (Answer) getIntent().getSerializableExtra("AllReplies");
        Answer answer = (Answer) getIntent().getParcelableExtra("AllReplies");
        TextView jsonValue = (TextView) findViewById(R.id.jsonValue);
//        jsonValue.setText(answer.getAnswerText());
        jsonValue.setText(answer.getAnswerText());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_all_comment, menu);
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
