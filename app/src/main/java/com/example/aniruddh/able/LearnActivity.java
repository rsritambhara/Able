package com.example.aniruddh.able;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LearnActivity extends AppCompatActivity {

    public void number(View view)
    {
        Intent intent = new Intent(LearnActivity.this, NumberActivity.class);
        startActivity(intent);
    }

    public void alphabet(View view)
    {
        Intent intent = new Intent(LearnActivity.this, AlphabetActivity.class);
        startActivity(intent);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
    }
}
