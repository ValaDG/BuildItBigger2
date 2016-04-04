package com.degiorgi.valerio.androidjokelib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Intent intent = getIntent();
        TextView jokeView = (TextView) findViewById(R.id.joke_view);

        if(intent != null) {
            jokeView.setText(intent.getStringExtra("joke"));
        }
    }
}
