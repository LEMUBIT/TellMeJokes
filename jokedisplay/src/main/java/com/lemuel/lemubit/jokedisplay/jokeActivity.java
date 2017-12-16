package com.lemuel.lemubit.jokedisplay;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class jokeActivity extends AppCompatActivity {
    TextView jokeTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
        String joke = getIntent().getExtras().getString("joke");
        jokeTxt = (TextView) findViewById(R.id.jokeTxt);
        jokeTxt.setText(joke);
    }
}
