package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import java.util.Arrays;
import java.util.List;

public class Workouts extends AppCompatActivity {

    RecyclerView mRecyclerView;
    WorkoutsAdapter mAdapter;
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workouts);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        db = new DbHelper(this);

        List<String> Names = Arrays.asList("Abs workouts","Glutes workouts","Legs workouts","Arms workouts","Chest workouts","Cardio workouts");


        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new WorkoutsAdapter(Names, R.layout.workout_cards, this);

        mRecyclerView.setAdapter(mAdapter);

    }
}