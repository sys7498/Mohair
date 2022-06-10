package com.example.mohartest1;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private AnimationDrawable animationDrawable;
    private ImageView imageView;
    private ArrayList<ThirdNames> Arraylist = new ArrayList<ThirdNames>(); //정보들을 저장
    private String[] Words = new String[2];//팝업으로 보여주기
    private String len;
    private int hairstylenumber = 0, facetypenumber = 0, hairtypenumber = 0;
    private DrawableToInt Draw = new DrawableToInt();
    private ViewFlipper v_fllipper;
    int images[]={
            R.drawable.p1,
            R.drawable.p2,
            R.drawable.p3,
            R.drawable.p4,
    };
    DatabaseHelper HomeHelper;
    SQLiteDatabase dbHome;
    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup RootView = (ViewGroup) inflater.inflate(R.layout.fragment_home,container,false);
        ThirdAdapter thirdAdapter = new ThirdAdapter();
        FourAdapter fourAdapter = new FourAdapter();
        RecyclerView recyclerView3 = RootView.findViewById(R.id.recyclerview_th);
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager layoutManager4 = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);

        recyclerView3.setLayoutManager(layoutManager3);
        ImageView homeImage = RootView.findViewById(R.id.homeimage1);
        ImageView ImageViewmz = RootView.findViewById(R.id.homeimage2);
        TextView TextViewlen = RootView.findViewById(R.id.homeimage3);
        TextView TextViewWelcome = RootView.findViewById(R.id.welcome);
        HomeHelper = Databaseshare.getInstance(getContext());
        dbHome = HomeHelper.getWritableDatabase();
        Cursor cursor = dbHome.rawQuery("select Id, name, hairlen, mozil, hair, face, state from mtable",null);
        cursor.moveToNext();
        Cursor pcursor = dbHome.rawQuery("select _id, p from ptable",null);
        Cursor icursor = dbHome.rawQuery("select _id, imageNumber from itable",null);
        TextViewWelcome.setText("'" + cursor.getString(1) + "' 님\n모헤어에 오신 것을\n환영합니다\n" );
       /*** Bundle extra = this.getArguments();
        if(extra!=null){
            extra=getArguments();
            hairstylenumber = extra.getInt("hairstylenumber");
            facetypenumber = extra.getInt("facetypenumber");
            hairtypenumber = extra.getInt("hairtypenumber");
            len = extra.getString("hairlength");

        } ***/
        homeImage.setImageResource(Draw.FaceTypeWithHair[cursor.getInt(5)][cursor.getInt(4)]);
        TextViewlen.setText(""+ cursor.getString(2));
        ImageViewmz.setImageResource(Draw.HairType[cursor.getInt(3)][0]);
        /***
        thirdAdapter.addItem(new ThirdNames(Draw.HairStyle[0][0]));
        thirdAdapter.addItem(new ThirdNames(Draw.HairStyle[1][0]));
        thirdAdapter.addItem(new ThirdNames(Draw.HairStyle[2][0]));
         ***/
        //수정
        for(int i=0;i<15;i++){
            pcursor.moveToNext();
            if(pcursor.getInt(1)!=0) //머리카락 정보가 있으면 찜 목록에 나오게 함 p값이 0이아니면
                thirdAdapter.addItem(new ThirdNames(pcursor.getInt(1)));//p는 눌렀을떄 그 머리 모양을 가져오는 거
        }
        for(int i=0;i<5;i++){
            fourAdapter.addItem(new FourName(Integer.toString(i+1),Draw.HairStyle[i][0],Draw.HairStyleName[i]));
        }
        recyclerView3.setAdapter(thirdAdapter);
        v_fllipper = RootView.findViewById(R.id.image_slide);

        for(int image : images) {
            fllipperImages(image);
        }
        return RootView;
    }
    public void fllipperImages(int image) {
        ImageView imageView = new ImageView(getActivity());
        imageView.setBackgroundResource(image);

        v_fllipper.addView(imageView);      // 이미지 추가
        v_fllipper.setFlipInterval(3000);       // 자동 이미지 슬라이드 딜레이시간(1000 당 1초)
        v_fllipper.setAutoStart(true);          // 자동 시작 유무 설정

        // animation
        v_fllipper.setInAnimation(getActivity(),android.R.anim.slide_in_left);
        v_fllipper.setOutAnimation(getContext(),android.R.anim.slide_out_right);
    }
}