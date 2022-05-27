package com.example.mohartest1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class hairproductAdapter extends RecyclerView.Adapter<hairproductAdapter.ViewHolder>{

    ArrayList<product_json> items = new ArrayList<product_json>();
    @NonNull
    @Override
    public hairproductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.product_box, viewGroup, false);
        return new hairproductAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull hairproductAdapter.ViewHolder holder, int position) {
        product_json item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView hairProductImgView;
        TextView brandTextView;
        TextView productNameTextView;
        TextView priceTextView;

        public ViewHolder(View itemView){
            super(itemView);
            hairProductImgView = itemView.findViewById(R.id.hairproduct);
            brandTextView = itemView.findViewById(R.id.brand);
            productNameTextView = itemView.findViewById(R.id.product_name);
            priceTextView = itemView.findViewById(R.id.price);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {

                    }

                }
            });


        }

        public void setItem(product_json item){
            //hairProductImgView.setImageDrawable(item.getHairProduct());
            Glide.with(this.hairProductImgView.getContext()).load(item.img_url).into(hairProductImgView);
            brandTextView.setText(item.brand);
            productNameTextView.setText(item.name);
            priceTextView.setText(item.price);
        }
    }

    public void addItem(product_json item){
        items.add(item);
    }
    public void setItems(ArrayList<product_json> items){
        this.items = items;
    }
    public product_json getItem(int position){
        return items.get(position);
    }
    public void setItem(int position, product_json item){
        items.set(position, item);
    }
}
