package com.example.mohartest1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
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
    profile_main ProfileFrag1 = new profile_main();
    Databasetest Databasetest = new Databasetest();
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent = getIntent();
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
        ProfileFrag1.setArguments(bundle);

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
                        getSupportFragmentManager().beginTransaction().replace(R.id.homeContainer, HomeFrag).commit();
                        return true;
                    case R.id.tab3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.homeContainer, HomeFrag).commit();
                        return true;
                    case R.id.tab4:
                        getSupportFragmentManager().beginTransaction().replace(R.id.homeContainer, Databasetest).commit();
                        return true;
                    case R.id.tab5:
                            getSupportFragmentManager().beginTransaction().replace(R.id.homeContainer, ProfileFrag1).commit();
                        return true;
                }
                return false;
            }
        });



        //getSupportFragmentManager().beginTransaction().replace(R.id.homeContainer, HomeFrag).commitAllowingStateLoss();
    }
}