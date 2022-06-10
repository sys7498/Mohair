package com.example.mohartest1;

import android.content.Context;
//하나의 데이터베이스만 쓰기 위해서
public class Databaseshare {
    private static DatabaseHelper databaseHelper=null;
    public static DatabaseHelper getInstance(Context context) {
        if (databaseHelper == null) { //만약에 데베가 없으면
            databaseHelper= new DatabaseHelper(context);//데베만들어주고
        }
        //이미 데베가 존재하면 기존에 만든 데베 넘기기.
        return databaseHelper;
    }
}
