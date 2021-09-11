package com.example.fitnessapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WorkoutsAdapter extends RecyclerView.Adapter<WorkoutsAdapter.ViewHolder> {
    private List<String> Names;
    private int workoutsLayout;
    private Context mContext;
    private DbHelper db;


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public RelativeLayout card;
        public ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.Name);
            card = (RelativeLayout) itemView.findViewById(R.id.card);
            image = (ImageView) itemView.findViewById(R.id.picture);
        }
    }

    public WorkoutsAdapter(List<String> Names, int workoutsLayout, Context context) {
        this.Names = Names;
        this.workoutsLayout = workoutsLayout;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(workoutsLayout, viewGroup, false);
        return new ViewHolder(v);
    }

    // Замена на содржината во view (повикано од layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        String Name = Names.get(i);
        viewHolder.name.setText(Name);

        viewHolder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, Details.class);
                intent.putExtra("name", viewHolder.name.getText().toString());
                context.startActivity(intent);
            }
        });
        if(Name.equals("Abs workouts")){
            viewHolder.image.setImageResource(R.drawable.abs);
        }
        if(Name.equals("Legs workouts")){
            viewHolder.image.setImageResource(R.drawable.legs);
        }
        if(Name.equals("Chest workouts")){
            viewHolder.image.setImageResource(R.drawable.chest);
        }
        if(Name.equals("Glutes workouts")){
            viewHolder.image.setImageResource(R.drawable.glutes);
        }
        if(Name.equals("Arms workouts")){
            viewHolder.image.setImageResource(R.drawable.armss);
        }
        if(Name.equals("Cardio workouts")){
            viewHolder.image.setImageResource(R.drawable.cardio);
        }

    }

    // Пресметка на големината на податочното множество (повикано од layout manager)
    @Override
    public int getItemCount() {
        return Names.size();
    }
}

