package com.library.library.Browse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.library.library.MainActivity;
import com.library.library.Profile.ProfileActivity;
import com.library.library.R;

public class BrowseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.browse:
                        break;
                    case R.id.profile:
                        Intent a = new Intent(BrowseActivity.this, ProfileActivity.class);
                        startActivity(a);
                        break;
                    case R.id.collection:
                        Intent b = new Intent(BrowseActivity.this, MainActivity.class);
                        startActivity(b);
                        break;
                }
                return false;
            }
        });
    }
}