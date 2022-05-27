package com.example.mohartest1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HairAdapter extends RecyclerView.Adapter<HairAdapter.ViewHolder> {
    ArrayList<Hair> Items = new ArrayList<Hair>();
    OnHairItemClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.activity_hairitem,parent,false);
        return new ViewHolder(itemView,this.listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Hair item = Items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() { //개수반환
        return Items.size();
    }
    public void addItem(Hair hair){
        Items.add(hair);
    }
    public void setItems(ArrayList<Hair> items){
        this.Items =items;
    }
    public Hair getItem(int position){
        return Items.get(position);
    }
    public void setItem(int position, Hair item){
        Items.set(position,item);
    }
    public void setOnItemClicklistener(OnHairItemClickListener listener){
        this.listener =listener;
    }


    public void onItemClick(ViewHolder holder, View view, int position) {
        if(listener!=null)
            listener.onItemClick(holder,view,position);
    }


    static class  ViewHolder extends RecyclerView.ViewHolder{
        TextView Textview;
        ImageButton Imagebutton;
        int i=0;
        public ViewHolder(View itemView,final OnHairItemClickListener listener){
            super(itemView);
            Textview = itemView.findViewById(R.id.textview_two);
            Imagebutton = itemView.findViewById(R.id.imageview_two);
            Imagebutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (listener!=null){
                        listener.onItemClick(HairAdapter.ViewHolder.this,view,pos);
                    }
                }
            });

        }
        public void setItem(Hair hair){
            Textview.setText(hair.getName());
            Imagebutton.setBackgroundResource(hair.getImageRes());
        }
    }
}
