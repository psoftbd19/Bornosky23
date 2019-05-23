package com.bornosky.view.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bornosky.MainActivity;
import com.bornosky.R;
import com.bornosky.customfonts.MyEditText;

public class signin extends AppCompatActivity {

    TextView create;

    Typeface fonts1;
    MyEditText tvEmail, tvPassword;
    String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        create = (TextView) findViewById(R.id.create);
        tvEmail = (MyEditText) findViewById(R.id.email);
        tvPassword = (MyEditText) findViewById(R.id.password);


        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(signin.this, signup.class);
                startActivity(it);

            }
        });


        fonts1 = Typeface.createFromAsset(signin.this.getAssets(),
                "fonts/Lato-Regular.ttf");


        TextView t4 = (TextView) findViewById(R.id.create);
        t4.setTypeface(fonts1);


    }

    public void clickSignin(View view) {
        email = tvEmail.getText().toString();
        password = tvPassword.getText().toString();
        if (!TextUtils.isEmpty(email) & !TextUtils.isEmpty(password)) {
            if (email.equalsIgnoreCase("noyon") & password.equalsIgnoreCase("123456")) {
                startActivity(new Intent(signin.this, MainActivity.class));
            } else {

                Toast.makeText(this, "Please, insert valid credential!", Toast.LENGTH_SHORT).show();
            }
            if (email.equalsIgnoreCase("mustafiz") & password.equalsIgnoreCase("123456")) {
                startActivity(new Intent(signin.this, MainActivity.class));
            } else {

                Toast.makeText(this, "Please, insert valid credential!", Toast.LENGTH_SHORT).show();
            }
            if (email.equalsIgnoreCase("nahid") & password.equalsIgnoreCase("123456")) {
                startActivity(new Intent(signin.this, MainActivity.class));
            } else {

                Toast.makeText(this, "Please, insert valid credential!", Toast.LENGTH_SHORT).show();
            }
            if (email.equalsIgnoreCase("sagir") & password.equalsIgnoreCase("123456")) {
                startActivity(new Intent(signin.this, MainActivity.class));
            } else {

                Toast.makeText(this, "Please, insert valid credential!", Toast.LENGTH_SHORT).show();
            }
        } else {

            Toast.makeText(this, "Please, insert data!", Toast.LENGTH_SHORT).show();
        }


    }
}
