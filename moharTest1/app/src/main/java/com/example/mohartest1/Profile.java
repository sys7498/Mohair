package com.example.mohartest1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    DatabaseHelper ProHelper;
    SQLiteDatabase dbPro;
    TextView name;
    TextView hair;
    TextView face;
    TextView hairlen;
    TextView hairQ;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile_main);
        ProHelper = Databaseshare.getInstance(this);
        dbPro = ProHelper.getWritableDatabase();
        Cursor cursor = dbPro.rawQuery("select Id, name, hairlen, mozil, hair, face, state from mtable",null);
        cursor.moveToNext();
        imageView =findViewById(R.id.profile_img);
        imageView.setImageResource(DrawableToInt.FaceTypeWithHair[cursor.getInt(5)][cursor.getInt(4)]);
        name=findViewById(R.id.profile_name);
        hair=findViewById(R.id.profile_revice_hair_style);
        face=findViewById(R.id.profile_revice_face_type);
        hairlen=findViewById(R.id.profile_revice_hair_length);
        hairQ=findViewById(R.id.profile_revice_hair_quality);
        name.setText(cursor.getString(1));
        hair.setText(DrawableToInt.HairStyleName[cursor.getInt(4)]);
        face.setText(DrawableToInt.FaceTypeName[cursor.getInt(5)]);
        hairlen.setText(cursor.getString(2));
        hairQ=findViewById(R.id.profile_revice_hair_quality);
        hairQ.setText(DrawableToInt.HairTypeName[cursor.getInt(3)]);
        Button pbutton = findViewById(R.id.Pbutton);
        pbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}