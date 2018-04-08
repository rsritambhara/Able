package com.example.aniruddh.able;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AlphabetActivity extends AppCompatActivity {



    public void clicka(View view)
    {
        String alphabet="";
        Intent intent = new Intent(AlphabetActivity.this, VideoActivity.class);
        switch(view.getId()){
            case R.id.alphabet_A:
                intent.putExtra("L",1);
                intent.putExtra("type",0);
                break;
            case R.id.alphabet_B:
                intent.putExtra("L",2);
                intent.putExtra("type",0);
                break;
            case R.id.alphabet_C:
                intent.putExtra("L",3);
                intent.putExtra("type",0);
                break;
            case R.id.alphabet_D:
                intent.putExtra("L","D");
                intent.putExtra("type",0);
                break;
            case R.id.alphabet_E:
                intent.putExtra("L","E");
                intent.putExtra("type",0);
                break;
            case R.id.alphabet_F:
                intent.putExtra("L","F");
                intent.putExtra("type",0);
                break;
            case R.id.alphabet_G:
                intent.putExtra("L","G");
                intent.putExtra("type",0);
                break;
            case R.id.alphabet_H:
                intent.putExtra("L","H");
                intent.putExtra("type",0);
                break;
            case R.id.alphabet_I:
                intent.putExtra("L","I");
                intent.putExtra("type",0);
                break;
            case R.id.alphabet_J:
                intent.putExtra("L","J");
                intent.putExtra("type",0);
                break;
            case R.id.alphabet_K:
                intent.putExtra("L","K");
                intent.putExtra("type",0);
                break;
            case R.id.alphabet_L:
                intent.putExtra("L","L");
                intent.putExtra("type",0);
                break;
            case R.id.alphabet_M:
                intent.putExtra("L","M");
                intent.putExtra("type",0);
                break;
            case R.id.alphabet_N:
                intent.putExtra("L","N");
                intent.putExtra("type",0);
                break;
            case R.id.alphabet_O:
                intent.putExtra("L","O");
                intent.putExtra("type",0);
                break;
            case R.id.alphabet_P:
                intent.putExtra("L","P");
                intent.putExtra("type",0);
                break;
            case R.id.alphabet_Q:
                intent.putExtra("L","Q");
                intent.putExtra("type",0);
                break;
            case R.id.alphabet_R:
                intent.putExtra("L","R");
                intent.putExtra("type",0);
                break;
            case R.id.alphabet_S:
                intent.putExtra("L","S");
                intent.putExtra("type",0);
                break;
            case R.id.alphabet_T:
                intent.putExtra("L","T");
                intent.putExtra("type",0);
                break;
            case R.id.alphabet_U:
                intent.putExtra("L","U");
                intent.putExtra("type",0);
                break;
            case R.id.alphabet_V:
                intent.putExtra("L","V");
                intent.putExtra("type",0);
                break;
            case R.id.alphabet_W:
                intent.putExtra("L","W");
                intent.putExtra("type",0);
                break;
            case R.id.alphabet_X:
                intent.putExtra("L","X");
                intent.putExtra("type",0);
                break;
            case R.id.alphabet_Y:
                intent.putExtra("L","Y");
                intent.putExtra("type",0);
                break;
            case R.id.alphabet_Z:
                intent.putExtra("L","Z");
                intent.putExtra("type",0);
                break;
        }

        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);
    }
}
