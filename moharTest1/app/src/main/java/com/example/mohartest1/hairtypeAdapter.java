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

public class hairtypeAdapter extends RecyclerView.Adapter<hairtypeAdapter.ViewHolder>{

    public int selected_number_hairtype = 0;
    int check = -1;
    ArrayList<hairtypeItem> items = new ArrayList<hairtypeItem>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.profile_box, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        hairtypeItem item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView hairTypeImgView;
        TextView hairtypeTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            hairTypeImgView = itemView.findViewById(R.id.img_box);
            hairtypeTextView = itemView.findViewById(R.id.name_box);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        if (check == -1) {
                            hairTypeImgView.setImageDrawable(items.get(pos).getSelected_hairtype());
                            check = pos;
                            selected_number_hairtype = pos;
                        } else {
                            if (check == pos) {
                                hairTypeImgView.setImageDrawable(items.get(pos).getHairtype());
                                check = -1;
                                selected_number_hairtype = 0;
                            }else{
                                Toast.makeText(itemView.getContext(), "하나만 선택 가능합니다", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            });
        }

        public void setItem(hairtypeItem item) {
            hairTypeImgView.setImageDrawable(item.getHairtype());
            hairtypeTextView.setText(item.getHairtype_name());
        }
    }

    public void addItem(hairtypeItem item) {
        items.add(item);
    }

    public void setItems(ArrayList<hairtypeItem> items) {
        this.items = items;
    }

    public hairtypeItem getItem(int position) {
        return items.get(position);
    }

    public void setItem(int position, hairtypeItem item) {
        items.set(position, item);
    }
}
