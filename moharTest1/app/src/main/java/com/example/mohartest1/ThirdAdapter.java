package com.example.mohartest1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ThirdAdapter extends RecyclerView.Adapter<ThirdAdapter.ViewHolder> implements OnThirdItemClickListener {
    ArrayList<ThirdNames> items = new ArrayList<ThirdNames>();
    OnThirdItemClickListener listener;
    @NonNull
    @Override
    public ThirdAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.activity_homsrecy,parent,false);
        return new ThirdAdapter.ViewHolder(itemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull ThirdAdapter.ViewHolder holder, int position) {
        ThirdNames item = items.get(position);
        holder.setItem(item);

    }

    @Override
    public int getItemCount() { //개수반환
        return items.size();
    }
    public void addItem(ThirdNames haf){
        items.add(haf);
    }
    public void setItems(ArrayList<ThirdNames> items){
        this.items=items;
    }
    public ThirdNames getItem(int position){
        return items.get(position);
    }
    public void setItem(int position, ThirdNames item){
        items.set(position,item);
    }
    public void setOnItemClicklistener(OnThirdItemClickListener listener){
        this.listener =listener;
    }
    @Override
    public void onItemClick(ThirdAdapter.ViewHolder holder, View view, int position) {
        if(listener!=null)
            listener.onItemClick(holder,view,position);
    }

    static class  ViewHolder extends RecyclerView.ViewHolder{
        ImageView Imageview;
        public ViewHolder(View itemView,final OnThirdItemClickListener listener){
            super(itemView);
            Imageview = itemView.findViewById(R.id.wlahair);
            Imageview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (listener!=null){
                        listener.onItemClick(ThirdAdapter.ViewHolder.this,view,pos);
                    }
                }
            });
        }
        public void setItem(ThirdNames haf){
            Imageview.setBackgroundResource(haf.getName());

        }
    }
}
