package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    Button reg;
    Button log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        reg=(Button)findViewById(R.id.StartButton);
        log=(Button)findViewById(R.id.LoginButton);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }
    public void start(){
        Intent i = new Intent(HomeActivity.this, Start_nowActivity.class);
        startActivity(i);
    }
    public void login(){
        Intent i = new Intent(HomeActivity.this, LoginActivity.class);
        startActivity(i);
    }


}