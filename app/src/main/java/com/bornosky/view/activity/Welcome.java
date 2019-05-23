package com.bornosky.view.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bornosky.R;

public class Welcome extends AppCompatActivity {

    private static final int SEND_SMS =1001 ;
    TextView signin;
    TextView signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);


        signin = (TextView)findViewById(R.id.signin);
        signup = (TextView)findViewById(R.id.Signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(Welcome.this, signup.class);
                startActivity(it);

            }
        });



        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(Welcome.this,signin.class);
                startActivity(it);


            }
        });


        if (Build.VERSION.SDK_INT >= 23) {
            int checkCallPhonePermission = ContextCompat.checkSelfPermission(Welcome.this, Manifest.permission.SEND_SMS);
            if(checkCallPhonePermission != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(Welcome.this,new String[]{Manifest.permission.SEND_SMS},SEND_SMS);
                return;
            }
        }

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        int checkCallPhonePermission = ContextCompat.checkSelfPermission(Welcome.this,Manifest.permission.SEND_SMS);
        if(checkCallPhonePermission == PackageManager.PERMISSION_GRANTED){
        }
    }
}
