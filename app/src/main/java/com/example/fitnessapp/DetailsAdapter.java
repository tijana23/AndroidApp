package com.example.fitnessapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.ViewHolder> {
    final List<String> Names;
    final List<String> Times;
    final List<String> Levels;
    final List<String> Images;
    final List<String> Targets;
    final int detailsLayout;
    final Context mContext;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView time;
        public TextView level;
        public TextView target;
        public ImageView image;
        public LinearLayout card;



        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.Name1);
            time = (TextView) itemView.findViewById(R.id.time);
            level = (TextView) itemView.findViewById(R.id.level);
            target = (TextView) itemView.findViewById(R.id.target);
            image = (ImageView) itemView.findViewById(R.id.picture1);
            card = (LinearLayout) itemView.findViewById(R.id.card1);

        }
    }

    public DetailsAdapter(List<String> Names, List<String> Times,List<String> Levels,List<String> Images,List<String> Targets, int detailsLayout, Context mContext) {
        this.Names = Names;
        this.Times = Times;
        this.Levels=Levels;
        this.Images=Images;
        this.Targets=Targets;
        this.detailsLayout = detailsLayout;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(detailsLayout, viewGroup, false);
        return new ViewHolder(v);
    }

    // Замена на содржината во view (повикано од layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        String Name = Names.get(i);
        viewHolder.name.setText(Name);
        String Time = Times.get(i);
        viewHolder.time.setText(Time);
        String Level = Levels.get(i);
        viewHolder.level.setText(Level);
        Resources resources = viewHolder.name.getContext().getResources();
        final int resourceId = resources.getIdentifier(Images.get(i), "drawable", viewHolder.name.getContext().getPackageName());
        viewHolder.image.setImageResource(resourceId);
        String Target = Targets.get(i);
        viewHolder.target.setText(Target);



        viewHolder.card.setOnClickListener(v -> {
            Intent intent = new Intent(mContext, InstructionsActivity.class);
            intent.putExtra("name", viewHolder.name.getText().toString());
            mContext.startActivity(intent);
        });


    }

    // Пресметка на големината на податочното множество (повикано од layout manager)
    @Override
    public int getItemCount() {
        return Names.size();
    }
}