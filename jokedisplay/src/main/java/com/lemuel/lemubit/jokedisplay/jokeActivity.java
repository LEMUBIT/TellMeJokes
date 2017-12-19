package com.lemuel.lemubit.jokedisplay;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class jokeActivity extends AppCompatActivity {
    TextView jokeTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
        //get Joke from bundle
        String joke = getIntent().getExtras().getString("joke");
        jokeTxt = (TextView) findViewById(R.id.jokeTxt);
        jokeTxt.setText(joke);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.exit) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
