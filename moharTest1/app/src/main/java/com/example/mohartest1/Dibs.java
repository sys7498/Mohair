package com.example.mohartest1;
public class Dibs {
    private int ImageNumber;//이미지 보여주는 거
    private int ImageButtonState;//이미지 클릭 상태 저장
    public Dibs(int imageNumber,int ImageButtonState){
        this.ImageNumber = imageNumber;
        this.ImageButtonState = ImageButtonState;
    }

    public int getImageButtonState() {
        return ImageButtonState;
    }

    public void setImageButtonState(int imageButtonState) {
        ImageButtonState = imageButtonState;
    }

    public int getImageNumber() {
        return ImageNumber;
    }

    public void setImageNumber(int imageNumber) {
        ImageNumber = imageNumber;
    }
}
