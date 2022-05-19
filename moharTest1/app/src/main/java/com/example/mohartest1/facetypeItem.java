package com.example.mohartest1;

import android.graphics.drawable.Drawable;

public class facetypeItem {

    Drawable facetype;
    Drawable selected_facetype;

    public String getFacetype_name() {
        return facetype_name;
    }

    public void setFacetype_name(String facetype_name) {
        this.facetype_name = facetype_name;
    }

    String facetype_name;

    public facetypeItem(Drawable facetype, Drawable selected_facetype, String facetype_name) {
        this.facetype = facetype;
        this.selected_facetype = selected_facetype;
        this.facetype_name = facetype_name;
    }

    public void setFacetype(Drawable set_facetype){
        facetype = set_facetype;
    }

    public Drawable getFacetype(){
        return this.facetype;
    }

    public Drawable getSelected_facetype() {
        return selected_facetype;
    }

    public void setSelected_facetype(Drawable selected_facetype) {
        this.selected_facetype = selected_facetype;
    }

}
