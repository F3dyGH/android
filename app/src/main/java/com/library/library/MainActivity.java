package com.library.library;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.library.library.Browse.BrowseActivity;
import com.library.library.Profile.ProfileActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.collection:
                        break;
                    case R.id.profile:
                        Intent a = new Intent(MainActivity.this, ProfileActivity.class);
                        startActivity(a);
                        break;
                    case R.id.browse:
                        Intent b = new Intent(MainActivity.this, BrowseActivity.class);
                        startActivity(b);
                        break;
                }
                return false;
            }
        });
    }
}