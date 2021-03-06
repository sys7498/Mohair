package com.example.mohartest1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.w3c.dom.Text;

public class MainActivity3 extends AppCompatActivity {

    int selected_number_facetype = 0;
    int selected_number_hairstyle = 0;
    int selected_number_hairtype = 0;
    int profile_check = 0;
    String Name;
    String HairLength;
    HomeFragment HomeFrag = new HomeFragment();
    Recomfragment HairstyleRecommend = new Recomfragment();
    ProductRecommend ProductRecommend = new ProductRecommend();
    kakaomap kakaomap = new kakaomap();
    DatabaseHelper HomeHelper;
    SQLiteDatabase dbHome;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        HomeHelper = Databaseshare.getInstance(this);
        dbHome = HomeHelper.getWritableDatabase();
        Cursor cursor = dbHome.rawQuery("select Id, name, hairlen, mozil, hair, face, state from mtable",null);
        cursor.moveToNext();

        /***Intent intent = getIntent();
        selected_number_facetype = intent.getIntExtra("facetypenumber", 0);
        selected_number_hairstyle = intent.getIntExtra("hairstylenumber", 0);
        selected_number_hairtype = intent.getIntExtra("hairtypenumber", 0);
        Name = intent.getStringExtra("name");
        HairLength = intent.getStringExtra("hairlength");

        Bundle bundle = new Bundle();
        bundle.putInt("hairstylenumber", selected_number_hairstyle);
        bundle.putInt("facetypenumber", selected_number_facetype);
        bundle.putInt("hairtypenumber",selected_number_hairtype);
        bundle.putInt("profilecheck", profile_check);
        bundle.putString("name", Name);
        bundle.putString("hairlength", HairLength);
        HomeFrag.setArguments(bundle);
        HairstyleRecommend.setArguments(bundle); ***/


        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.homeContainer, HomeFrag);
        ft.commitAllowingStateLoss(); // ft.commit()


        BottomNavigationView BottomNavigation = findViewById(R.id.bottomNavigationView);
        BottomNavigation.setOnItemSelectedListener(
                new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.tab1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.homeContainer, HomeFrag).commit();
                        return true;
                    case R.id.tab2:
                       /***Intent intent = new Intent(MainActivity3.this, CameraActivity.class);
                        startActivity(intent);
                        ***/
                        getSupportFragmentManager().beginTransaction().replace(R.id.homeContainer,HairstyleRecommend).commit();
                        return true;

                    case R.id.tab3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.homeContainer, ProductRecommend).commit();
                        return true;
                    case R.id.tab4:
                        getSupportFragmentManager().beginTransaction().replace(R.id.homeContainer, kakaomap).commit();
                        return true;
                    case R.id.tab5:
                        Intent intent = new Intent(MainActivity3.this,Profile.class);
                        startActivity(intent);
                        return true;
                }
                return false;
            }
        });



        //getSupportFragmentManager().beginTransaction().replace(R.id.homeContainer, HomeFrag).commitAllowingStateLoss();
    }
}