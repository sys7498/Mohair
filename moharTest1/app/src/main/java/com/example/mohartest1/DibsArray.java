package com.example.mohartest1;

public class DibsArray { //Dibs(찜)을 저장하기 위한 클래스
    public static Dibs[] dibs =  new Dibs[15];// 총 15개 배열 만듬
    public static void reset(){ //초기화 시켜주는 구문
        for(int i=0;i<15;i++){ //이미지 번호 0 , 상태(하트)로 초기화
            dibs[i]=new Dibs(0, R.drawable.angled_1);//버튼
        }
    }

}
