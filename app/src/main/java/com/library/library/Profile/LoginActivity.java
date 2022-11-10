package com.library.library.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.library.library.Entity.User;
import com.library.library.MainActivity;
import com.library.library.R;
import com.library.library.database.AppDataBase;

public class LoginActivity extends AppCompatActivity {

    private AppDataBase database;
    private EditText email;
    private EditText pass;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.editTextEmailAddress);
        pass = findViewById(R.id.editTextTextPassword);
        login = findViewById(R.id.buttonLogin);
        database = AppDataBase.getAppDatabase(getApplicationContext());
        Signup();
        login.setOnClickListener(e -> {
            Login();
        });
    }

    public void Signup() {
        TextView signup = findViewById(R.id.textView6);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
            }
        });
    }

      public void Login() {
        User u = database.userDao().findByEmailPwd(email.getText().toString(), pass.getText().toString());
      /*  if((u == null) || (!u.getPwd().equals(pwd))) {
            Toast.makeText(this,"Sorry! Either your password or your email is incorrect.", Toast.LENGTH_LONG);
        }else if (u.getEmail().equals(email) && u.getPwd().equals(pwd)){
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            // u.setLoggedIn(true);
            SharedPreferences sharedPref = ctx.getSharedPreferences("last_loggedin_user_id", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();*/
            /*editor.putInt("id", u.getId());
            editor.apply();
            Log.d(TAG, "doInBackground: " + userDao.getAll());*/
       /* String e = email.getText().toString();
        String p = pass.getText().toString();
        User u = database.userDao().findByEmail(e);*/

//        if(u!=null && u.getPwd().equals(p)) {
//            startActivity(new Intent(LoginActivity.this, MainActivity.class));
//        } else {
//            Toast.makeText(this, "Wrong Credentials", Toast.LENGTH_SHORT);
//        }

         /* if(database.userDao().findByEmailPwd(email.getText().toString(), pass.getText().toString())!=null) {
              //database.userDao().delete();
              System.out.println(database.userDao().getAll().toString());
              Toast.makeText(getApplicationContext(), "Signed Up successfully", Toast.LENGTH_SHORT).show();
              startActivity(new Intent(LoginActivity.this, MainActivity.class));
          }
          else {
              Toast.makeText(getApplicationContext(), "User doesnt exist", Toast.LENGTH_SHORT).show();
              System.out.println(database.userDao().getAll().toString());
          }*/
          if(u!=null) {
              System.out.println(database.userDao().getAll().toString());
              u.setConnected(true);
              Toast.makeText(getApplicationContext(), "Logged In successfully", Toast.LENGTH_SHORT).show();
              startActivity(new Intent(LoginActivity.this, MainActivity.class));
          }
          else {
              Toast.makeText(getApplicationContext(), "Wrong password or User doesn't exist", Toast.LENGTH_SHORT).show();
              System.out.println(database.userDao().getAll().toString());
          }
   }


}