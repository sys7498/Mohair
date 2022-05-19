package com.example.mohartest1;

public class FourName {
    int Img;
    String cnt;
    String Name;

    public FourName(String cnt, int img, String name) {
        this.Img = img;
        this.cnt = cnt;
        this.Name = name;
    }

    public int getImg() {
        return Img;
    }

    public void setImg(int img) {
        Img = img;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCnt() {
        return cnt;
    }

    public void setCnt(String cnt) {
        this.cnt = cnt;
    }
}
