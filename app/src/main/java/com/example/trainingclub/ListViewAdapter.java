package com.example.trainingclub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.itemHolder>{


    private Context context;
    private  ArrayList<RegisterModel> registerModels;

    public  ListViewAdapter(Context context, ArrayList<RegisterModel> registerModels) {
        this.context= context;
        this.registerModels=registerModels;

    }


    @NonNull
    @Override
    public itemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.ranking_cell, parent, false);
        return new itemHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull itemHolder holder, int position){


        RegisterModel model=registerModels.get(position);
        String dis=String.format("%06d",model.getUsertime());
        String dis1=dis.substring(0,2);
        String dis2=dis.substring(2,4);
        String dis3=dis.substring(4,6);
        holder.tvid.setText(model.getUserid());
        holder.rankingtime.setText(dis1+":"+dis2+":"+dis3+" (초)");
        holder.ranking.setText(model.getUser()+"위");



    }

    @Override
    public int getItemCount(){
        return registerModels.size();
    }

    static class itemHolder  extends RecyclerView.ViewHolder{
       TextView tvid, ranking, rankingtime;
       public itemHolder(View v){
            super(v);
            tvid=(TextView) v.findViewById(R.id.tvid);
            rankingtime=(TextView) v.findViewById(R.id.rankingtime);
            ranking=(TextView) v.findViewById(R.id.ranking);

       }

    }

}
