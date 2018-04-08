package com.example.aniruddh.able;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NumberActivity extends AppCompatActivity {

    public void clicka(View view) {
        String alphabet = "";
        Intent intent = new Intent(NumberActivity.this, VideoActivity.class);
        switch (view.getId()) {
            case R.id.imageView:
                intent.putExtra("L", 1);
                intent.putExtra("type", 1);
                break;
            case R.id.imageView2:
                intent.putExtra("L", 2);
                intent.putExtra("type", 1);
                break;
            case R.id.imageView3:
                intent.putExtra("L", 3);
                intent.putExtra("type", 1);
                break;
            case R.id.imageView4:
                intent.putExtra("L", 4);
                intent.putExtra("type", 1);
                break;
            case R.id.imageView5:
                intent.putExtra("L", 5);
                intent.putExtra("type", 1);
                break;
            case R.id.imageView6:
                intent.putExtra("L", 6);
                intent.putExtra("type", 1);
                break;
            case R.id.imageView7:
                intent.putExtra("L", 7);
                intent.putExtra("type", 1);
                break;
            case R.id.imageView8:
                intent.putExtra("L", 8);
                intent.putExtra("type", 1);
                break;
            case R.id.imageView9:
                intent.putExtra("L", 9);
                intent.putExtra("type", 1);
                break;
        }

        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);
    }
}
