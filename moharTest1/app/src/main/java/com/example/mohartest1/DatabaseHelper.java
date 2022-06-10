package com.example.mohartest1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static String NAME = "Mohair.db"; //데베이름을 Mohair.db로 설정
    public static int VERSION =1;
    public static String tableName= "mtable";
    public static String tableName1= "ptable";
    public static String tableName2= "itable";
    public DatabaseHelper(Context context){
        super(context,NAME,null,VERSION);
    }
    public void onCreate(SQLiteDatabase db){
        String sql = " create table if not exists " + tableName + "("
                    + " Id integer, "
                    + " name text, " //이름
                    + " hairlen text, " //머리길이
                    + " mozil integer,  " //모질
                    + " hair integer, " //머리
                    + " face integer, "  //얼굴형
                    + " state integer)"; //상태
        db.execSQL(sql);
        String initialRecord=" insert into " + tableName + "(Id, name, hairlen, mozil, hair, face, state) "
                                +" values "
                                + "(1,'a', 'a',0, 0, 0, 0)";
        db.execSQL(initialRecord);
        //postion table 만들기
        String psql = " create table if not exists " + tableName1 + "("
                + " _id integer primary key autoincrement, "//id
                + " p integer)"; //position (머리 스타일)
        db.execSQL(psql);

        //이미지 table 만들기
        String isql = " create table if not exists " + tableName2 + "("
                + " _id integer primary key autoincrement, "//id
                + " imageNumber integer)"; //state
        db.execSQL(isql);
        //초기화 시키기
        for(int i=0;i<15;i++){
            db.execSQL("insert into "+ "ptable"+ "(p)"
                    +" values"
                    + "(0)");

            db.execSQL("insert into "+ "itable"+ "(imageNumber)"
                    +" values"
                    + "(0)");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if(i1>1)
            sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS mtable");
    }

}
