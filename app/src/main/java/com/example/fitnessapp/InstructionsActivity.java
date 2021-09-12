package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class InstructionsActivity extends AppCompatActivity {
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("");

        Intent intent = getIntent();
        String exercise = intent.getStringExtra("name");

        db = new DbHelper(this);
        String name=db.WorkoutName(exercise);

        TextView nameWorkout = (TextView) findViewById(R.id.Name2);
        nameWorkout.setText(exercise);
        TextView instructions = (TextView) findViewById(R.id.instruction);
        instructions.setText(db.getInstruction(exercise));
        TextView time = (TextView) findViewById(R.id.time2);
        time.setText(db.getTime(exercise));
        ImageView img = (ImageView) findViewById(R.id.picture2);
        Resources resources = getResources();
        final int resourceId = resources.getIdentifier(db.getImage(exercise), "drawable", getPackageName());
        img.setImageResource(resourceId);






    }
}