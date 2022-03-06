package com.example.result;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<Model> mList;
    Context context;

    public MyAdapter(Context context , ArrayList<Model> mList){
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item, parent , false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Model model = mList.get(position);
        holder.name.setText(model.getName());
        holder.phy.setText(model.getPhy());
        holder.chem.setText(model.getChem());
        holder.mathematics.setText(model.getMathematics());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name, phy, chem, mathematics;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.dStudentName);
            phy = itemView.findViewById(R.id.dPhysics);
            chem = itemView.findViewById(R.id.dChemistry);
            mathematics = itemView.findViewById(R.id.dMath);
        }
    }
}
