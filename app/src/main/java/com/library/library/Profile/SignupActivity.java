package com.library.library.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.library.library.Entity.User;
import com.library.library.MainActivity;
import com.library.library.R;
import com.library.library.database.AppDataBase;


public class SignupActivity extends AppCompatActivity {

    private AppDataBase database;
    private Button signUp;
    private EditText email;
    private EditText pwd;
    private EditText name;
    private EditText lastname;
    private EditText phone;
    private EditText birthdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signUp =findViewById(R.id.buttonSignup);
        email = findViewById(R.id.editTextEmail);
        pwd = findViewById(R.id.editTextPassword);
        name= findViewById(R.id.editTextName);
        lastname = findViewById(R.id.editTextLastName);
        phone = findViewById(R.id.editTextPhone);
        birthdate = findViewById(R.id.editTextDate);
        database = AppDataBase.getAppDatabase(getApplicationContext());
        Login();
        signUp.setOnClickListener(e ->{
            checkDataEntered();
        });
         }
        public void Login() {
        TextView login = findViewById(R.id.textView8);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));

            }
        });
    }

        boolean isEmail(EditText text) {
            CharSequence email = text.getText().toString();
            return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
        }

        boolean isEmpty(EditText text) {
            CharSequence str = text.getText().toString();
            return TextUtils.isEmpty(str);
        }

        void checkDataEntered() {

                if (isEmpty(name)) {
                    name.setError("Name is required!");
                }
                else if (isEmpty(lastname)) {
                    lastname.setError("Last name is required!");
                }
                else if (isEmpty(birthdate)) {
                    birthdate.setError("Birthdate is required!");
                }
                else if (isEmpty(phone)) {
                    phone.setError("Phone is required!");
                }
                else if (isEmpty(pwd)) {
                    pwd.setError("Password is required!");
                }
                else if (isEmpty(email)) {
                    email.setError("Email is required!");
                }
                else if (isEmail(email) == false) {
                    email.setError("Enter valid email!");
                }
                else if (database.userDao().findByEmail(email.getText().toString()) != null ) {
                    Toast.makeText(getApplicationContext(), "Email already exists", Toast.LENGTH_SHORT).show();
                    System.out.println(database.userDao().getAll().toString());
                }
                else if(database.userDao().findByEmail(email.getText().toString()) == null) {
                    database.userDao().insertOne(new User(email.getText().toString(), pwd.getText().toString(), name.getText().toString(), lastname.getText().toString(), birthdate.getText().toString(), phone.getText().toString()));
                    //database.userDao().delete();
                    System.out.println(database.userDao().getAll().toString());
                    Toast.makeText(getApplicationContext(), "Signed Up successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignupActivity.this, MainActivity.class));
                    }
        }


}