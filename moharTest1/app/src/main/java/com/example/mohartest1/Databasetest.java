package com.example.mohartest1;

import static java.sql.DriverManager.println;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Databasetest#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Databasetest extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    String tableName;
    SQLiteDatabase database;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button makedb;
    Button maketab;
    EditText putdb;
    EditText puttab;
    TextView datas;

    public Databasetest() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Databasetest.
     */
    // TODO: Rename and change types and number of parameters
    public static Databasetest newInstance(String param1, String param2) {
        Databasetest fragment = new Databasetest();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_databasetest, container, false);
        makedb = view.findViewById(R.id.makedb);
        maketab = view.findViewById(R.id.maketab);
        putdb = view.findViewById(R.id.putdb);
        puttab = view.findViewById(R.id.puttab);
        datas = view.findViewById(R.id.data);

        makedb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String databaseName = putdb.getText().toString();
                createDatabase(databaseName);
            }
        });

        maketab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableName = puttab.getText().toString();
                createTable(tableName);
            }
        });


        return view;
    }

    private void createDatabase(String name){
        println("createDatabase 호출됨");
        database = SQLiteDatabase.openOrCreateDatabase(name,null);
        println("데이터베이스 생성함:" + name);
    }

    private void createTable(String name){
        println("createTable 호출됨");

        if(database == null){
            println("데이터베이스를 먼저 생성하세요.");
            return;
        }

        database.execSQL("create table if not exists "
                + name
                + "("
                + " _id integer PRIMARY KEY autoincrement, "
                + " name text "
                + " age integer, "
                + "mobile text)");

        println("테이블 생성함: " + name);
    }

    private void insertRecord(){
        println("insertRecord 호풀됨.");
        if(database == null){
            println("데이터베이스를 먼저 생성하세요.");
            return;
        }

        if(tableName == null){
            println("테이블을 먼저 생성하세요.");
            return;
        }

        database.execSQL("insert into "
                + tableName
                + "(name, age, mobile) "
                + " values "
                + "('john' , 20, '010-10000-1000' )");
        println("레코드추가함.");
    }

    public void println(String data){
        datas.append(data + "\n");
    }




}