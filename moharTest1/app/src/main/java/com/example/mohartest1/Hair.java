package com.example.mohartest1;

public class Hair {
    String Name; //이름
    int ImageRes;//이미지 번호(리소스)
    int ButtonRes;
    String explain;
    public Hair(String name, int imageRes, String explain,int ButtonRes) {
        this.Name = name;
        this.ImageRes = imageRes;
        this.explain = explain;
        this.ButtonRes = ButtonRes;
    }

    public int getButtonRes() {
        return ButtonRes;
    }

    public void setButtonRes(int buttonRes) {
        ButtonRes = buttonRes;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
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
