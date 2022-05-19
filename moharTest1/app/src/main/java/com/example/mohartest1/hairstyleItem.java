package com.example.mohartest1;

import android.graphics.drawable.Drawable;

public class hairstyleItem {

    Drawable hairstyle;
    Drawable selected_hairstyle;
    String hairstyle_name;

    public String getHairstyle_name() {
        return hairstyle_name;
    }

    public void setHairstyle_name(String hairstyle_name) {
        this.hairstyle_name = hairstyle_name;
    }


    public hairstyleItem(Drawable hairstyle, Drawable selected_hairstyle, String hairstyle_name) {
        this.hairstyle = hairstyle;
        this.selected_hairstyle = selected_hairstyle;
        this.hairstyle_name = hairstyle_name;
    }

    public Drawable getHairstyle() {
        return hairstyle;
    }

    public void setHairstyle(Drawable hairstyle) {
        this.hairstyle = hairstyle;
    }
    public Drawable getSelected_hairstyle() {
        return selected_hairstyle;
    }

    public void setSelected_hairstyle(Drawable selected_hairstyle) {
        this.selected_hairstyle = selected_hairstyle;
    }





}
