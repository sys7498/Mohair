package com.example.mohartest1;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HairAdapter extends RecyclerView.Adapter<HairAdapter.ViewHolder> implements OnHairItemClickListener {
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

    @Override
    public void onItemClick1(ViewHolder holder, View view, int position) {
        if(listener!=null)
            listener.onItemClick1(holder,view,position);
    }

    @Override
    public void onItemClick2(ViewHolder holder, View view, int position) {
        if(listener!=null)
            listener.onItemClick2(holder,view,position);
    }


    static class  ViewHolder extends RecyclerView.ViewHolder{
        TextView Textview;
        ImageButton Imagebutton;
        ImageButton imageButton2;
        ImageButton imageButton3;
        TextView explain;
        int i=0;
        public ViewHolder(View itemView,final OnHairItemClickListener listener){
            super(itemView);
            Textview = itemView.findViewById(R.id.recommend_hairstyle_name);
            Imagebutton = itemView.findViewById(R.id.recommend_hairstyle_img); //이미지
            imageButton2 = itemView.findViewById(R.id.imageButton2);
            imageButton3 = itemView.findViewById(R.id.imageButtonC);//카메라
            explain = itemView.findViewById(R.id.recommend_hairstyle_explain);
            imageButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (listener!=null){
                        listener.onItemClick(HairAdapter.ViewHolder.this,view,pos);
                    }
                }
            });
            Imagebutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (listener!=null){
                        listener.onItemClick1(HairAdapter.ViewHolder.this,view,pos);
                    }
                }
            });
            imageButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (listener!=null){
                        listener.onItemClick2(HairAdapter.ViewHolder.this,view,pos);
                    }
                }
            });
        }
        public void setItem(Hair hair){
            Textview.setText(hair.getName());
            Imagebutton.setBackgroundResource(hair.getImageRes());
            explain.setText(hair.getExplain());
            imageButton2.setBackgroundResource(hair.getButtonRes());
            imageButton3.setBackgroundResource(R.drawable.camera);
        }
    }
}
