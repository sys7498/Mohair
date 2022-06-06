package com.example.mohartest1;

public class HairPriority implements Comparable<HairPriority> {
    int number; //숫자
    int imageNumber; //이미지 숫자
    String condition; //상태 good ,soso, bad
    String HairName;
    String explain;

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public HairPriority(int number, int imageNumber, String condition, String hairName, String explain) {
        this.number = number;
        this.imageNumber = imageNumber;
        this.condition = condition;
        this.HairName = hairName;
        this.explain = explain;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getImageNumber() {
        return imageNumber;
    }

    public void setImageNumber(int imageNumber) {
        this.imageNumber = imageNumber;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getHairName() {
        return HairName;
    }

    public void setHairName(String hairName) {
        HairName = hairName;
    }

    @Override
    public int compareTo(HairPriority hairPriority) {
        if( this.number < hairPriority.number)
            return -1;
        else if( this.number == hairPriority.number)
            return 0;
        else
            return 1;
    }
}
