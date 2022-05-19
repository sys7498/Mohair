package com.example.mohartest1;

import android.graphics.drawable.Drawable;

public class hairtypeItem {
    Drawable hairtype;
    Drawable selected_hairtype;
    String hairtype_name;

    public String getHairtype_name() {
        return hairtype_name;
    }

    public void setHairtype_name(String hairtype_name) {
        this.hairtype_name = hairtype_name;
    }

    public hairtypeItem(Drawable hairtype, Drawable selected_hairtype, String hairtype_name) {
        this.hairtype = hairtype;
        this.selected_hairtype = selected_hairtype;
        this.hairtype_name = hairtype_name;
    }

    public void setHairtype(Drawable set_hairtype){
        hairtype = set_hairtype;
    }

    public Drawable getHairtype(){
        return this.hairtype;
    }

    public Drawable getSelected_hairtype() {
        return selected_hairtype;
    }

    public void setSelected_hairtype(Drawable selected_hairtype) {
        this.selected_hairtype = selected_hairtype;
    }

}
