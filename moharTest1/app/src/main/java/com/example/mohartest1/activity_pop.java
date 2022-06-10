package com.example.mohartest1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

public class activity_pop extends AppCompatActivity {
    DatabaseHelper dbMainHelper;
    SQLiteDatabase dbMain;
    String Name = "mtable";
    public static String tableName1= "ptable";
    public static String tableName2= "itable";
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);
        dbMainHelper = Databaseshare.getInstance(this); //helper만들어주고
        dbMain = dbMainHelper.getWritableDatabase();//참조  즉dbMain에 Helpler에 정의한 데베와 테이블 참조함
        //postion table 만들기
        //dbMain.execSQL("UPDATE mtable SET state=0 WHERE Id=1"); //업데이트를 하는데 mtable에 있는 state를 0으로 업데이트 근데 행이 1번쨰인거
        Cursor cursor = dbMain.rawQuery("select Id, name, hairlen, mozil, hair, face, state from mtable",null);
        cursor.moveToNext();
        Cursor icursor = dbMain.rawQuery("select _id,imageNumber from itable",null);
        icursor.moveToNext();
        int v = R.drawable.heart1; //초기 헤어선택 이미지

        /*dbMain.execSQL("UPDATE mtable " + "SET" + " state=0"+" WHERE Id=1");
        for(int i=0;i<15;i++){
         dbMain.execSQL("UPDATE itable " + "SET" + " imageNumber="+ v +""+" WHERE _id="+(i+1)+"");
         dbMain.execSQL("UPDATE ptable " + "SET" + " p=0"+" WHERE _id="+(i+1)+"");
        }*/

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.6));
        if(cursor.getInt(6)==1) { //상태가 1이면 바로 홈으로 넘기기
            Intent i = new Intent(activity_pop.this, MainActivity3.class);
            startActivity(i);
        }

        Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cursor.getInt(6)==0){
                    Intent i = new Intent(activity_pop.this, MainActivity2.class);
                    startActivity(i);
                }
            }
        });

    }
}