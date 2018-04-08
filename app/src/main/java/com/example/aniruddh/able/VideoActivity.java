package com.example.aniruddh.able;

import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.github.gcacace.signaturepad.views.SignaturePad;
import com.marcinmoskala.videoplayview.VideoPlayView;

import id.agusibrahim.yuuplayer.YuuPlayer;

public class VideoActivity extends AppCompatActivity {


    int type,L;
    YuuPlayer videoView;
    String url="http://heal-depressiondetection.herokuapp.com/poll/download?isdigit=";
    String url_letter="https://github.com/SudhanshShastri/Able/blob/master/letters/";
    String url_digit="https://raw.githubusercontent.com/SudhanshShastri/Able/master/digits/Digit";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        videoView=(YuuPlayer) findViewById(R.id.videoView);
        Bundle b=getIntent().getExtras();
        type=b.getInt("type");
        L=b.getInt("L");

        String mainUrl="";
        if(type==0){

            switch (L) {
                case 1:
                    mainUrl="https://www.youtube.com/watch?v=hidT9alJVyw&index=14&list=UUYR-5WrVppC7eIICNLfw8EA";
                    break;

                case 2:

                    break;
                case 3:

                    break;
            }
        }else{
            int value=b.getInt("L");
            url_digit+=value+".mp4";
            mainUrl=url_digit;
        }
        Uri uri = Uri.parse(mainUrl);
        videoView.setVideo("hidT9alJVyw");
        videoView.requestFocus();
        videoView.playVideo();

        // videoView.setVideoUrl(mainUrl);
        //videoView.setAutoplay(true);
    }
}
