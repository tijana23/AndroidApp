package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Start_nowActivity extends AppCompatActivity {
    EditText username, password, repassword;
    Button signup, signin;
    DbHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_now);

        DB = new DbHelper(this);

        username=(EditText) findViewById(R.id.inputUsername);
        password=(EditText) findViewById(R.id.inputPassword);
        repassword=(EditText) findViewById(R.id.inputConfirmPassword);
        signup = (Button) findViewById(R.id.btnRegister);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(Start_nowActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user, pass);
                            if(insert==true){
                                Toast.makeText(Start_nowActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                DB.popolni();
                                Intent intent = new Intent(getApplicationContext(),Workouts.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(Start_nowActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(Start_nowActivity.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(Start_nowActivity.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                } }
        });

    }
}