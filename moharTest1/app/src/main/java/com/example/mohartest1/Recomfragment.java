package com.example.mohartest1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        Bundle extra = this.getArguments();
        if(extra!=null){
            extra=getArguments();
            Ima_one = extra.getInt("hairstylenumber");
            Ima_two = extra.getInt("facetypenumber");
            Ima_th = extra.getInt("hairtypenumber");
            len = extra.getString("hairlength");
        }
        int copylen = Integer.parseInt(len);
        ImageView imageViewProfile = rootView.findViewById(R.id.storeProfileimage);
        ImageView imageHair = rootView.findViewById(R.id.storeHimage);
        TextView textCon = rootView.findViewById(R.id.storeLenImage);
        // 우선순위 알고리즘 계산
        for(int i=0;i<hairPriority.length;i++){ //넣어주기. 점수, 머리,상태, 이름
            hairPriority[i] = new HairPriority(0,Draw.HairStyle[i][0],null,Draw.HairStyleName[i], Draw.HairStyleExplain[i]);
        }
        HairLenFind(copylen); //머리길이에 따른 어울리는 헤어 우선순위 결정
        FaceFind(Ima_two); //얼굴형에 따른 어울리는 헤어 우선순위 결정
        Arrays.sort(hairPriority); //오름차순 정렬
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
        for(int i=0;i<hairPriority.length;i++) {
            hairAdapter.addItem(new Hair(hairPriority[i].getHairName(),hairPriority[i].getImageNumber(),hairPriority[i].getExplain()));
        }

        imageViewProfile.setImageResource(Draw.FaceTypeWithHair[Ima_two][Ima_one]);
        recyclerView6.setAdapter(hairAdapter);
        hairAdapter.setOnItemClicklistener(new OnHairItemClickListener() {
            @Override
            public void onItemClick(HairAdapter.ViewHolder holder, View view, int position) {
                imageHair.setBackgroundResource(hairPriority[position].getImageNumber());
                textCon.setText(hairPriority[position].getCondition());
            }
        });
        return rootView;
    }

    public void HairLenFind(int copylen){
        if(0<=copylen && copylen<=5){ //자신의 머리길이가 0~5면

            for(int i=0;i<hairPriority.length;i++) { // b인 포마드 올백 리젠트 1점
                if (3 <= i && i <= 5)
                    hairPriority[i].setNumber(1);
                else if (6 <= i && i <= 14)
                    hairPriority[i].setNumber(2);
            }

        }else if(5<copylen && copylen<=10){ //자신의 머리길이가 5~10면

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
        if(faceNum==0){ //각진형
            for(int i=0;i<hairPriority.length;i++){
                if(i==0 || i==1 || i==3 || i==5)
                    hairPriority[i].setNumber(hairPriority[i].getNumber()+1);
                else if(i==2||i==4||i==6||i==8||i==9||(12<=i && i<=14))
                    hairPriority[i].setNumber(hairPriority[i].getNumber()+2);
            }

        } else if(faceNum==1){ //둥근형
            for(int i=0;i<hairPriority.length;i++){
                if(0<=i && i<=2)
                    hairPriority[i].setNumber(hairPriority[i].getNumber()+1);
                else if(6<=i && i<=14)
                    hairPriority[i].setNumber(hairPriority[i].getNumber()+2);
            }
        }else if(faceNum==3){ //긴얼굴형이면
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