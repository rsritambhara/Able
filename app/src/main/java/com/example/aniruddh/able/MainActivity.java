package com.example.aniruddh.able;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   


    public void test(View view)
    {
        Intent intent = new Intent(MainActivity.this, TestActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void learn(View view)
    {
        Intent intent = new Intent(MainActivity.this, LearnActivity.class);
        startActivity(intent);
    }
}
