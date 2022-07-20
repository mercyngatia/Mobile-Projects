package com.example.bottomnavview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bottom nav
        BottomNavigationView btnNav = findViewById(R.id.bottomNavigationview);
        btnNav.setOnNavigationItemSelectedListener(navListener);

        //Setting HomeFragment as main fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_layout,new HomeFragment()).commit();
    }

    //Listener Nav Bar
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.item1:
                            selectedFragment = new HomeFragment();
                            break;

                        case R.id.item2:
                            selectedFragment = new AchievementFragment();

                        case R.id.item3:
                            selectedFragment = new SettingsFragment();
                    }

                    //Begin Transaction
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_layout,selectedFragment).commit();

                    return true;
                }
            };
}