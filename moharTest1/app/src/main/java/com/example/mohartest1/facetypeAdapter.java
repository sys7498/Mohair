package com.example.mohartest1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;



public class facetypeAdapter extends RecyclerView.Adapter<facetypeAdapter.ViewHolder> {


    public int selected_number_facetype = 0;
    int check = -1;
    ArrayList<facetypeItem> items = new ArrayList<facetypeItem>();
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.profile_box, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        facetypeItem item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView facetypeImgView;
        TextView faceNameTextView;

        public ViewHolder(View itemView){
            super(itemView);
            facetypeImgView = itemView.findViewById(R.id.img_box);
            faceNameTextView = itemView.findViewById(R.id.name_box);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        if (check == -1) {
                            facetypeImgView.setImageDrawable(items.get(pos).getSelected_facetype());
                            check = pos;
                            selected_number_facetype = pos;
                        } else {
                            if (check == pos) {
                                facetypeImgView.setImageDrawable(items.get(pos).getFacetype());
                                check = -1;
                                selected_number_facetype = 0;
                            }else{
                                Toast.makeText(itemView.getContext(), "하나만 선택 가능합니다", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                }
            });


        }

        public void setItem(facetypeItem item){
            facetypeImgView.setImageDrawable(item.getFacetype());
            faceNameTextView.setText(item.getFacetype_name());
        }
    }

    public void addItem(facetypeItem item){
        items.add(item);
    }
    public void setItems(ArrayList<facetypeItem> items){
        this.items = items;
    }
    public facetypeItem getItem(int position){
        return items.get(position);
    }
    public void setItem(int position, facetypeItem item){
        items.set(position, item);
    }
}
