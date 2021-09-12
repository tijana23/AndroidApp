package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class Details extends AppCompatActivity {
    RecyclerView mRecyclerView;
    DetailsAdapter mAdapter;
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String Group = intent.getStringExtra("name");


        db = new DbHelper(this);
        List<String> Names = Arrays.asList();
        String names=db.WorkoutName(Group);
        Names=Arrays.asList(names.split(","));

        List<String> Times = Arrays.asList();
        String times=db.Time(Group);
        Times=Arrays.asList(times.split(","));

        List<String> Levels = Arrays.asList();
        String levels=db.Level(Group);
        Levels=Arrays.asList(levels.split(","));

        List<String> Targets = Arrays.asList();
        String targets=db.Target(Group);
        Targets=Arrays.asList(targets.split(","));

        List<String> Images = Arrays.asList();
        String images=db.Image(Group);
        Images=Arrays.asList(images.split(","));



        mRecyclerView = (RecyclerView) findViewById(R.id.list1);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new DetailsAdapter(Names,Times,Levels,Targets,Images,R.layout.details_cards,this);

        mRecyclerView.setAdapter(mAdapter);
    }
}