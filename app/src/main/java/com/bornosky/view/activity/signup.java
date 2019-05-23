package com.bornosky.view.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.bornosky.MainActivity;
import com.bornosky.R;

public class signup extends AppCompatActivity {

    TextView signinhere;

    Typeface fonts1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        signinhere = (TextView)findViewById(R.id.signinhere);

        signinhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(signup.this, signin.class);
                startActivity(it);


            }
        });



        fonts1 =  Typeface.createFromAsset(signup.this.getAssets(),
                "fonts/Lato-Regular.ttf");




        TextView t1 =(TextView)findViewById(R.id.signinhere);
        t1.setTypeface(fonts1);




    }

    public void clickSignup(View view) {
        startActivity(new Intent(signup.this, MainActivity.class));
    }
}
