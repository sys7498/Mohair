package com.example.mohartest1;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mohartest1.DrawableToInt;

import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Recomfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Recomfragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private int Ima_one, Ima_two,Ima_th;
    private String len;
    private  DrawableToInt Draw = new DrawableToInt();
    private HairPriority[] hairPriority = new HairPriority[15];
    DatabaseHelper RecomHelper;
    SQLiteDatabase dbRecom;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Recomfragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Recomfragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Recomfragment newInstance(String param1, String param2) {
        Recomfragment fragment = new Recomfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_recomfragment,container,false);
        RecyclerView recyclerView6 = rootView.findViewById(R.id.recyclerview_priority);
        LinearLayoutManager layoutManager5 = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        recyclerView6.setLayoutManager(layoutManager5);
        HairAdapter hairAdapter = new HairAdapter();
        RecomHelper = Databaseshare.getInstance(getContext());
        dbRecom = RecomHelper.getWritableDatabase();
        Cursor cursor = dbRecom.rawQuery("select Id, name, hairlen, mozil, hair, face, state from mtable",null);
        cursor.moveToNext();
        /***
        Bundle extra = this.getArguments();
        if(extra!=null){
            extra=getArguments();
            Ima_one = extra.getInt("hairstylenumber");
            Ima_two = extra.getInt("facetypenumber");
            Ima_th = extra.getInt("hairtypenumber");
            len = extra.getString("hairlength");
        }
         ***/
        ImageButton imageButton3 = rootView.findViewById(R.id.imageButtonC);
        int copylen = Integer.parseInt(cursor.getString(2));
        ImageView imageViewProfile = rootView.findViewById(R.id.storeProfileimage);
        ImageView imageHair = rootView.findViewById(R.id.storeHimage);
        TextView textCon = rootView.findViewById(R.id.storeLenImage);
        // ???????????? ???????????? ??????
        for(int i=0;i<hairPriority.length;i++){ //????????????. ??????, ??????,??????, ??????
            hairPriority[i] = new HairPriority(0,Draw.HairStyle[i][0],null,Draw.HairStyleName[i], Draw.HairStyleExplain[i]);
        }
        HairLenFind(copylen); //??????????????? ?????? ???????????? ?????? ???????????? ??????
        FaceFind(Ima_two); //???????????? ?????? ???????????? ?????? ???????????? ??????
        Arrays.sort(hairPriority); //???????????? ??????
        for(int i=0;i<hairPriority.length;i++){
            if(hairPriority[i].getNumber()==0)
                hairPriority[i].setCondition("EXCELLENT");
            else if(hairPriority[i].getNumber()==1)
                hairPriority[i].setCondition("GOOD");
            else if(hairPriority[i].getNumber()==2)
                hairPriority[i].setCondition("SOSO");
            else if(hairPriority[i].getNumber()==3)
                hairPriority[i].setCondition("BAD");
            else if(hairPriority[i].getNumber()==4)
                hairPriority[i].setCondition("WORST");
        }
        Cursor icursor = dbRecom.rawQuery("select _id, imageNumber from itable",null);
        for(int i=0;i<hairPriority.length;i++) {
            icursor.moveToNext();
            hairAdapter.addItem(new Hair(hairPriority[i].getHairName(),hairPriority[i].getImageNumber(),hairPriority[i].getExplain(),icursor.getInt(1)));
        }

        imageViewProfile.setImageResource(Draw.FaceTypeWithHair[cursor.getInt(5)][cursor.getInt(4)]);
        recyclerView6.setAdapter(hairAdapter);
        hairAdapter.setOnItemClicklistener(new OnHairItemClickListener() {
            @Override
            public void onItemClick(HairAdapter.ViewHolder holder, View view, int position) {
                Cursor icursor = dbRecom.rawQuery("select _id, imageNumber from itable",null);
                Cursor pcursor = dbRecom.rawQuery("select _id, p from ptable",null);
                for(int i=0;i<15;i++){
                    icursor.moveToNext();
                    pcursor.moveToNext();
                    if(position==icursor.getInt(0)-1){ //????????? ???????????? ?????????
                        if(icursor.getInt(1)!=R.drawable.heart1){ // 700145 << ?????? ????????? ????????? ????????? ?????? ???????????????
                            dbRecom.execSQL("UPDATE itable " + "SET" + " imageNumber="+R.drawable.heart1+""
                                    + " WHERE _id="+icursor.getInt(0)+""); //?????? _id??? ?????? postion??? ?????? ????????? ????????? ????????????
                            dbRecom.execSQL("UPDATE ptable " + "SET" + " p=0" //???????????? ??????
                                    + " WHERE _id="+pcursor.getInt(0)+""); //?????? _id??? ?????? postion??? ?????? ????????? ????????? ????????????
                            holder.imageButton2.setBackgroundResource(R.drawable.heart1);//?????? ??????
                        }else if(icursor.getInt(1)==R.drawable.heart1){ //?????? ???????????? ?????????
                            dbRecom.execSQL("UPDATE itable " + "SET" + " imageNumber="+R.drawable.heart2+""
                                    + " WHERE _id="+icursor.getInt(0)+""); //?????? _id??? ?????? postion??? ?????? ????????? ????????? ????????????
                            dbRecom.execSQL("UPDATE ptable " + "SET" + " p="+hairPriority[position].getImageNumber()+""  //???????????? ?????????
                                    + " WHERE _id="+pcursor.getInt(0)+""); //?????? _id??? ?????? postion??? ?????? ????????? ????????? ????????????
                            holder.imageButton2.setBackgroundResource(R.drawable.heart2);//?????? ??????
                            Log.i("Dsd",Integer.toString(R.drawable.heart2));
                        }
                    }
                }
                /*** imageHair.setBackgroundResource(hairPriority[position].getImageNumber());
                textCon.setText(hairPriority[position].getCondition());
                ***/
            }
            //?????????
            @Override
            public void onItemClick1(HairAdapter.ViewHolder holder, View view, int position) {
                textCon.setText(hairPriority[position].getCondition());//???????????????
                imageHair.setBackgroundResource(hairPriority[position].getImageNumber());//??????????????????
            }
            //?????????
            @Override
            public void onItemClick2(HairAdapter.ViewHolder holder, View view, int position) {
                Intent intent = new Intent(getContext(), CameraActivity.class);
                intent.putExtra("selectHair",hairPriority[position].getImageNumber());
                startActivity(intent);


            }
        });
        return rootView;
    }

    public void HairLenFind(int copylen){
        if(0<=copylen && copylen<=5){ //????????? ??????????????? 0~5???

            for(int i=0;i<hairPriority.length;i++) { // b??? ????????? ?????? ????????? 1???
                if (3 <= i && i <= 5)
                    hairPriority[i].setNumber(1);
                else if (6 <= i && i <= 14)
                    hairPriority[i].setNumber(2);
            }

        }else if(5<copylen && copylen<=10){ //????????? ??????????????? 5~10???

            for(int i=0;i<hairPriority.length;i++){
                if((0<=i && i<=2) || (6<=i && i<=9))
                    hairPriority[i].setNumber(1);
                else if(10<=i && i<=14)
                    hairPriority[i].setNumber(2);
            }
        }else if(10<copylen && copylen<=15){

            for(int i=0;i<hairPriority.length;i++){
                if((3<=i && i<=5) || (10<=i && i<=12))
                    hairPriority[i].setNumber(1);
                else if((0<=i && i<=2) || (13<=i && i<=14))
                    hairPriority[i].setNumber(2);
            }
        }else if(15<copylen && copylen<=20) {
            for (int i = 0; i < hairPriority.length; i++) {
                if ((6 <= i && i <= 9) || (13 <= i && i <= 14))
                    hairPriority[i].setNumber(1);
                else if ((0 <= i && i <= 2) || (3 <= i && i <= 5))
                    hairPriority[i].setNumber(2);
            }
        }else{
            for (int i = 0; i < hairPriority.length; i++) {
                if (10 <= i && i <= 12)
                    hairPriority[i].setNumber(1);
                else if (0 <= i && i <= 9)
                    hairPriority[i].setNumber(2);
            }
        }
    }
    public void FaceFind(int faceNum){
        if(faceNum==0){ //?????????
            for(int i=0;i<hairPriority.length;i++){
                if(i==0 || i==1 || i==3 || i==5)
                    hairPriority[i].setNumber(hairPriority[i].getNumber()+1);
                else if(i==2||i==4||i==6||i==8||i==9||(12<=i && i<=14))
                    hairPriority[i].setNumber(hairPriority[i].getNumber()+2);
            }

        } else if(faceNum==1){ //?????????
            for(int i=0;i<hairPriority.length;i++){
                if(0<=i && i<=2)
                    hairPriority[i].setNumber(hairPriority[i].getNumber()+1);
                else if(6<=i && i<=14)
                    hairPriority[i].setNumber(hairPriority[i].getNumber()+2);
            }
        }else if(faceNum==3){ //??????????????????
            for(int i=0;i<hairPriority.length;i++){
                if(i==7 || i==10 || i==12 || i==14)
                    hairPriority[i].setNumber(hairPriority[i].getNumber()+1);
                else if((0<=i && i<=5) || i==13)
                    hairPriority[i].setNumber(hairPriority[i].getNumber()+2);
            }
        }else if(faceNum==4){
            for(int i=0;i<hairPriority.length;i++) {
                if ((7<=i && i<=9)|| i == 12)
                    hairPriority[i].setNumber(hairPriority[i].getNumber() + 1);
                else if ((0 <= i && i <= 5) || (13<=i && i<=14))
                    hairPriority[i].setNumber(hairPriority[i].getNumber() + 2);
            }
        }
    }
}