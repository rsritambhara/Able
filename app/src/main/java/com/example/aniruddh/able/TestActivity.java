package com.example.aniruddh.able;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.github.gcacace.signaturepad.views.SignaturePad;
import com.mapzen.speakerbox.Speakerbox;
//import com.jacksonandroidnetworking.JacksonParserFactory;

import java.util.Random;

import static com.example.aniruddh.able.R.id.clearButton;
import static com.example.aniruddh.able.R.id.saveButton;
import static com.example.aniruddh.able.R.id.signaturePad;

public class TestActivity extends AppCompatActivity {
    SignaturePad signaturePad;
    Button saveButton, clearButton;
    Bitmap handwritten_image;
    int [] pixels;
    boolean isdigit;
    String value;
    String [] letters={"A","B","C","D","E","F","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    String [] digits={"0","1","2","3","4","5","6","7","8","9"};
    Speakerbox speakerbox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Random r=new Random(SystemClock.currentThreadTimeMillis());
        int selection=r.nextInt(3);
        if(selection<2){
            isdigit=true;
        }else{
            isdigit=false;
        }
        if(isdigit){
            value=digits[r.nextInt(digits.length)];
        }else{
            value=letters[r.nextInt(letters.length)];
        }
        speakerbox=new Speakerbox(getApplication());
        speakerbox.play("Please write "+value);
        signaturePad = (SignaturePad)findViewById(R.id.signaturePad);
        signaturePad.setMinWidth(15);
        signaturePad.setBackgroundColor(Color.WHITE);
        saveButton = (Button)findViewById(R.id.saveButton);
        clearButton = (Button)findViewById(R.id.clearButton);
        pixels=new int[784];
        //disable both buttons at start
        saveButton.setEnabled(false);
        clearButton.setEnabled(false);
        AndroidNetworking.initialize(getApplicationContext());
        //change screen orientation to landscape mode
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        signaturePad.setOnSignedListener(new SignaturePad.OnSignedListener() {
            @Override
            public void onStartSigning() {

            }

            @Override
            public void onSigned() {
                saveButton.setEnabled(true);
                clearButton.setEnabled(true);
                handwritten_image=signaturePad.getSignatureBitmap();
                handwritten_image=Bitmap.createScaledBitmap(handwritten_image,28,28,true);
                System.out.println("Writing to handwritten image");

            }

            @Override
            public void onClear() {
                saveButton.setEnabled(false);
                clearButton.setEnabled(false);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //write code for saving the signature here
                processPixels(handwritten_image);
                //Toast.makeText(TestActivity.this, "Signature Saved", Toast.LENGTH_SHORT).show();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signaturePad.clear();
            }
        });

    }
    public void onPlayClick(View view){
        speakerbox.play("I repeat, please write "+value);
    }
    public void onNextClick(View view){
        Intent i=new Intent(this,TestActivity.class);
        startActivity(i);
        finish();
    }
    public static Bitmap getResizedBitmap(Bitmap image, int newHeight, int newWidth) {
        int width = image.getWidth();
        int height = image.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // create a matrix for the manipulation
        Matrix matrix = new Matrix();
        // resize the bit map
        matrix.postScale(scaleWidth, scaleHeight);
        // recreate the new Bitmap
        Bitmap resizedBitmap = Bitmap.createBitmap(image, 0, 0, width, height,
                matrix, false);
        return resizedBitmap;
    }
    void processPixels(Bitmap image){
        System.out.println("Inside processPixels");
        int k=0;
        for(int i=0; i<28; i++){
            for(int j=0; j<28; j++){
                //System.out.println("Processing pixels ("+j+","+i+")");
                int argb=image.getPixel(j,i);
                int r = (argb)&0xFF;
                int g = (argb>>8)&0xFF;
                int b = (argb>>16)&0xFF;
                int a = (argb>>24)&0xFF;
                float greyscale=(r+g+b)/765.0f;
                greyscale=greyscale*255;
                int gs=255-(int) greyscale;
                if(greyscale!=255){
                    //System.out.println("rgb values are:"+r+" "+g+" "+b);
                    //System.out.println("Greyscale is:"+greyscale);
                }
                pixels[k++]=gs;
            }
        }
        String s="";
        for(int pixel:pixels){
            s+=pixel+",";
        }
        System.out.println(s);
        if(isdigit){
            AndroidNetworking.post("https://heal-depressiondetection.herokuapp.com/polls/digit_recog")
                    .addBodyParameter("image", s)
                    .addBodyParameter("lastname", "Shekhar")
                    .setTag("test")
                    .setPriority(Priority.MEDIUM)
                    .build()
                    .getAsString(new StringRequestListener() {
                        @Override
                        public void onResponse(String response) {
                            System.out.println("REsponse from server:+"+response);
                            if(value.equals(response)){
                                Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_LONG).show();
                                speakerbox.play("Correct");
                            }else{
                                Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_LONG).show();
                                speakerbox.play("InCorrect");
                            }
                        }

                        @Override
                        public void onError(ANError anError) {
                            System.out.println(anError.getErrorBody());
                        }
                    });
        }else{
            AndroidNetworking.post("https://heal-depressiondetection.herokuapp.com/polls/alpha_recog")
                    .addBodyParameter("image", s)
                    .addBodyParameter("lastname", "Shekhar")
                    .setTag("test")
                    .setPriority(Priority.MEDIUM)
                    .build()
                    .getAsString(new StringRequestListener() {
                        @Override
                        public void onResponse(String response) {
                            System.out.println("REsponse from server:+"+response);
                            if(value.equals(letters[Integer.parseInt(response)])){
                                Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_LONG).show();
                                speakerbox.play("Correct");
                            }else{
                                Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_LONG).show();
                                speakerbox.play("InCorrect");
                            }
                        }

                        @Override
                        public void onError(ANError anError) {
                            System.out.println(anError.getErrorBody());
                        }
                    });
        }

    }
}
