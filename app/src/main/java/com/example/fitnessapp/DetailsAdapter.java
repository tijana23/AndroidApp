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

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.ViewHolder> {
    private List<String> Names;
    private List<String> Times;
    private List<String> Levels;
    private List<String> Instructions;
    private List<String> Targets;
    private int detailsLayout;
    private Context mContext;
    private DbHelper db;


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView time;
        public TextView level;
        public TextView target;
        public TextView instructions;
        public RelativeLayout card;
//        public ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.Name1);
            time = (TextView) itemView.findViewById(R.id.time);
            target = (TextView) itemView.findViewById(R.id.target);
            level = (TextView) itemView.findViewById(R.id.level);
            instructions = (TextView) itemView.findViewById(R.id.instruction);
            card = (RelativeLayout) itemView.findViewById(R.id.card1);
//            image = (ImageView) itemView.findViewById(R.id.picture1);
        }
    }

    public DetailsAdapter(List<String> Names, List<String> Times,List<String> Levels,List<String> Instructions,List<String> Targets, int detailsLayout, Context context) {
        this.Names = Names;
        this.Times = Times;
        this.Levels=Levels;
        this.Instructions=Instructions;
        this.Targets=Targets;
        this.detailsLayout = detailsLayout;
        this.mContext = context;
    }

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
        String Target = Targets.get(i);
        viewHolder.target.setText(Target);
        String Instruction = Instructions.get(i);
        viewHolder.instructions.setText(Instruction);

        viewHolder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, Details.class);
                intent.putExtra("name", viewHolder.name.getText().toString());
                context.startActivity(intent);
            }
        });


    }

    // Пресметка на големината на податочното множество (повикано од layout manager)
    @Override
    public int getItemCount() {
        return Names.size();
    }
}