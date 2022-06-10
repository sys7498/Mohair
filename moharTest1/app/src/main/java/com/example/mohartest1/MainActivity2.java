package com.example.mohartest1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity2 extends AppCompatActivity {


    String name;
    String hair_type;
    String hair_length;
    int profile_check = 1;

    DatabaseHelper InitialHelper;
    SQLiteDatabase dbInitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        InitialHelper = Databaseshare.getInstance(this);
        dbInitial= InitialHelper.getWritableDatabase();

        TextInputEditText nameET = findViewById(R.id.profile_name);
        TextInputEditText hair_lengthET = findViewById(R.id.profile_hair_length);

        RecyclerView hairtypeRecycler = findViewById(R.id.recycler_hairtype);
        hairtypeRecycler.setLayoutManager(new LinearLayoutManager(hairtypeRecycler.getContext(), RecyclerView.HORIZONTAL, false));
        hairtypeAdapter hairtypeAdapter = new hairtypeAdapter();
        hairtypeRecycler.setAdapter(hairtypeAdapter);
        for(int i = 0; i < 3; i++){
            hairtypeAdapter.addItem(new hairtypeItem(getDrawable(DrawableToInt.HairType[i][0]), getDrawable(DrawableToInt.HairType[i][1]), DrawableToInt.HairTypeName[i]));
        }

        RecyclerView facetypeAdapter = findViewById(R.id.recycler_facetype);
        facetypeAdapter.setLayoutManager(new LinearLayoutManager(facetypeAdapter.getContext(), RecyclerView.HORIZONTAL, false));
        facetypeAdapter faceAdapter = new facetypeAdapter();
        facetypeAdapter.setAdapter(faceAdapter);
        for(int i = 0; i < 5; i++){
            faceAdapter.addItem(new facetypeItem(getDrawable(DrawableToInt.FaceType[i][0]), getDrawable(DrawableToInt.FaceType[i][1]), DrawableToInt.FaceTypeName[i]));
        }

        RecyclerView hairstyleAdapter = findViewById(R.id.recycler_hairstyle);
        hairstyleAdapter.setLayoutManager(new LinearLayoutManager(hairstyleAdapter.getContext(), RecyclerView.HORIZONTAL, false));
        hairstyleAdapter hairAdapter = new hairstyleAdapter();
        hairstyleAdapter.setAdapter(hairAdapter);
        for(int i = 0; i < 15; i++){
            hairAdapter.addItem(new hairstyleItem(getDrawable(DrawableToInt.HairStyle[i][0]), getDrawable(DrawableToInt.HairStyle[i][1]), DrawableToInt.HairStyleName[i]));
        }

        Button toHomeButton = findViewById(R.id.toHomeButton);
        toHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = nameET.getText().toString();
                hair_length = hair_lengthET.getText().toString();
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                /***
                intent.putExtra("facetypenumber", faceAdapter.selected_number_facetype);
                intent.putExtra("hairstylenumber", hairAdapter.selected_number_hairstyle);
                intent.putExtra("hairtypenumber", hairtypeAdapter.selected_number_hairtype);
                intent.putExtra("name", name);
                intent.putExtra("hairlength", hair_length);
                intent.putExtra("profile_check", profile_check);
                 ***/
                dbInitial.execSQL("UPDATE mtable " + "SET" + " name='"+ name +"'" +","+" hairlen='"+ hair_length +"'"+","
                        +"mozil="+hairtypeAdapter.selected_number_hairtype+""+","
                        +"hair="+hairAdapter.selected_number_hairstyle+""+","
                        +"face="+faceAdapter.selected_number_facetype+""+","
                        +"state=1"+
                        " WHERE Id=1");

                startActivity(intent);
            }
        });

    }





}