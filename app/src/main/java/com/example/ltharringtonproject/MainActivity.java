package com.example.ltharringtonproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button login;
    Button register;
    EditText email;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button) findViewById(R.id.btn1);
        register = (Button) findViewById(R.id.btn2);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);


    //Button to go to signup page
        register.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent registerIntent = new Intent(MainActivity.this, registerActivity.class);
                                            startActivity(registerIntent);
                                        }
                                    });

    // Button to login if a member
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkDataEntered();
                validate(email.getText().toString(), password.getText().toString());

            }

           // checks email to make sure it matches email standard
        boolean isEmail (EditText text){
            CharSequence email = text.getText().toString();
            return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
        }

        // checks if any edit text fields are empty
        boolean isEmpty (EditText text){
            CharSequence str = text.getText().toString();
            return TextUtils.isEmpty(str);

        }

        //checks to makes sure fields are not empty
        void checkDataEntered () {
            if (isEmpty(password)) {
                password.setError("enter correct password");
            }
            if (isEmail(email) == false) {
                email.setError("enter correct email");
            }
        }

            // edit text fields are preset to be able to enter app
        private void validate (String email, String password){
            if ((email.equals("lala@gmail.com")) && (password.equals("vanilla"))) {
                Intent homeIntent = new Intent(MainActivity.this, homeActivity.class);
                startActivity(homeIntent);

            }

        }
    });
    }
}

