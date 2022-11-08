package com.library.library.Profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.library.library.Browse.BrowseActivity;
import com.library.library.MainActivity;
import com.library.library.R;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Login();
        Signup();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.profile:
                        break;
                    case R.id.browse:
                        Intent a = new Intent(ProfileActivity.this, BrowseActivity.class);
                        startActivity(a);
                        break;
                    case R.id.collection:
                        Intent b = new Intent(ProfileActivity.this, MainActivity.class);
                        startActivity(b);
                        break;
                }
                return false;
            }
        });
    }

    public void Signup() {
        Button signup = findViewById(R.id.btn_signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, SignupActivity.class));
            }
        });
    }

    public void Login() {
        Button login = findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, LoginActivity.class));
            }
        });
    }
}