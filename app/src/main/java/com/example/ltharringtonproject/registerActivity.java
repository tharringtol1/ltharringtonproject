package com.example.ltharringtonproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class registerActivity extends AppCompatActivity {

    EditText newemail;
    EditText fname;
    EditText lname;
    EditText dob;
    EditText newpassword;
    Button signup;
    Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        newemail = (EditText) findViewById(R.id.newemail);
        fname = (EditText) findViewById(R.id.firstname);
        lname = (EditText) findViewById(R.id.lastname);
        dob = (EditText) findViewById(R.id.dob);
        newpassword = (EditText) findViewById(R.id.newpassword);
        signup = (Button) findViewById(R.id.signupbtn);
        loginbtn = (Button) findViewById(R.id.loginbtn);



        // validate edit text is correct when signup button is clicked
        signup.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          checkDataEntered();
                                          validate(newemail.getText().toString(), newpassword.getText().toString(), dob.getText().toString(), fname.getText().toString(),
                                                  lname.getText().toString());


                                      }
        // checks email to make sure it matches email standard
                                      boolean isEmail(EditText text) {
                                          CharSequence email = text.getText().toString();
                                          return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
                                      }
        // checks if any edit text fields are empty
                                      boolean isEmpty(EditText text) {
                                          CharSequence str = text.getText().toString();
                                          return TextUtils.isEmpty(str);

                                      }
        //checks to makes sure fields are not empty
                                      void checkDataEntered() {
                                          if (isEmpty(newpassword)) {
                                              newpassword.setError("Enter password");
                                          }
                                          if (isEmpty(fname)) {
                                              fname.setError("Enter first name");
                                          }
                                          if (isEmpty(lname)) {
                                              lname.setError("Enter last name");
                                          }
                                          if (isEmpty(dob)) {
                                              dob.setError("Enter date of birth");
                                          }
                                          if (isEmail(newemail) == false) {
                                              newemail.setError("enter correct email");
                                          }
                                      }
        // edit text fields are preset to be able to enter app
                                      private void validate(String newemail, String newpassword, String dob, String
                                              fname, String lname) {
                                          if ((newemail.equals("lala@gmail.com")) && (newpassword.equals("vanilla")) && (fname.equals("Paul")) && (lname.equals("Jones")) &&
                                                  (dob.equals("02/17/1987"))) {

                                              Intent homeIntent = new Intent(registerActivity.this, homeActivity.class);
                                              startActivity(homeIntent);
                                          }


                                      }

                                  });

        // button to go to login page
                loginbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent loginIntent = new Intent(registerActivity.this, MainActivity.class);
                        startActivity(loginIntent);
                    }
            });
        }
    }

