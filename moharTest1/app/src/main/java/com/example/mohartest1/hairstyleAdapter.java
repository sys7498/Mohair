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

public class hairstyleAdapter extends RecyclerView.Adapter<hairstyleAdapter.ViewHolder> {

    public int selected_number_hairstyle = 0;
    int check = -1;
    ArrayList<hairstyleItem> items = new ArrayList<hairstyleItem>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.profile_box, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        hairstyleItem item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView hairstyleImgView;
        TextView hairStyleNameView;

        public ViewHolder(View itemView){
            super(itemView);
            hairstyleImgView = itemView.findViewById(R.id.img_box);
            hairStyleNameView = itemView.findViewById(R.id.name_box);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();

                    if (pos != RecyclerView.NO_POSITION){
                        if(check == -1){
                            //Glide.with(view.getContext()).load(items.get(pos).getSelected_hairstyle()).into(hairstyleImgView);
                            hairstyleImgView.setImageDrawable(items.get(pos).getSelected_hairstyle());
                            check = pos;
                            selected_number_hairstyle = pos;
                        }
                        else{
                            if(check==pos){
                                //Glide.with(view.getContext()).load(items.get(pos).getHairstyle()).into(hairstyleImgView);
                                hairstyleImgView.setImageDrawable(items.get(pos).getHairstyle());
                                check=-1;
                                selected_number_hairstyle = 0;
                            }else{
                                Toast.makeText(itemView.getContext(), "하나만 선택 가능합니다", Toast.LENGTH_SHORT).show();
                            }
                        }

                    }

                }
            });
        }

        public void setItem(hairstyleItem item){
            hairstyleImgView.setImageDrawable(item.getHairstyle());
            hairStyleNameView.setText(item.getHairstyle_name());
        }
    }

    public void addItem(hairstyleItem item){
        items.add(item);
    }
    public void setItems(ArrayList<hairstyleItem> items){
        this.items = items;
    }
    public hairstyleItem getItem(int position){
        return items.get(position);
    }
    public void setItem(int position, hairstyleItem item){
        items.set(position, item);
    }
}