package com.example.mohartest1;

public class Hair {
    String Name; //이름
    int ImageRes;//이미지 번호(리소스)
    public Hair(String name, int imageRes) {
        this.Name = name;
        this.ImageRes = imageRes;
    }

    public String getName() {
        return Name;
    }
    public int getImageRes(){
        return ImageRes;
    }

    public void setName(String name) {
        this.Name = name;
    }
    public void setImageRes(int imageRes){
        this.ImageRes =imageRes;
    }
}
