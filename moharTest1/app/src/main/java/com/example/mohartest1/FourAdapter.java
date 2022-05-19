package com.example.mohartest1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FourAdapter extends RecyclerView.Adapter<FourAdapter.ViewHolder> {
    ArrayList<FourName> Itemss = new ArrayList<FourName>();
    @NonNull
    @Override
    public FourAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.activity_hairlank,parent,false);
        return new FourAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FourAdapter.ViewHolder holder, int position) {
        FourName item = Itemss.get(position);
        holder.setItem(item);

    }

    @Override
    public int getItemCount() {
        return Itemss.size();
    }
    public void addItem(FourName fh){
        Itemss.add(fh);
    }
    public void setItems(ArrayList<FourName> items){
        this.Itemss=items;
    }
    public FourName getItem(int position){
        return Itemss.get(position);
    }
    public void setItem(int position, FourName item){
        Itemss.set(position,item);
    }
    static class  ViewHolder extends RecyclerView.ViewHolder{
        TextView Textview1;
        TextView Textview2;
        ImageView Imageview;
        public ViewHolder(View itemView){
            super((itemView));
            Textview1 = itemView.findViewById(R.id.fnum_lank);
            Textview2 = itemView.findViewById(R.id.fhome_name);
            Imageview = itemView.findViewById(R.id.homelank);

        }
        public void setItem(FourName faceShape){
            Textview1.setText(faceShape.getCnt());
            Imageview.setBackgroundResource(faceShape.getImg());
            Textview2.setText(faceShape.getName());
        }
    }
}
