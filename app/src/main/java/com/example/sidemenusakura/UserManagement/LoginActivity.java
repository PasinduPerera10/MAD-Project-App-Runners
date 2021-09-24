package com.example.sidemenusakura.UserManagement;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sidemenusakura.R;

public class LoginActivity extends AppCompatActivity {
    EditText editTextEmail, editTextPassword;
    Button buttonLogin, buttonRegister;
    TextView textViewRegister;
    com.example.sidemenusakura.UserManagement.DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new com.example.sidemenusakura.UserManagement.DatabaseHelper(this);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonRegister = findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, com.example.sidemenusakura.UserManagement.RegisterActivity.class));
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();


                Boolean res = db.checkUser(email, password);
                User user = new User();
                Log.d("IDdetails", String.valueOf(user.getId()));


                if (res == true) {
                    Intent HomePage = new Intent(LoginActivity.this, com.example.sidemenusakura.UserManagement.UserProfileActivity.class);
                    Bundle b = new Bundle();
                    b.putString("textViewEmail", editTextEmail.getText().toString());
                    b.putString("textViewPassword", editTextPassword.getText().toString());

                    String y = db.selectOneUserSendUserName(email, password);
                    String a = db.selectOneUserSendName(email, password);
                    int x = db.selectOneUserSendId(email,password);
                    int cd = db.selectOneUserSendContactnumber(email,password);
                    Log.d("TAG" , "ID =  " + x);

                    b.putString("textViewUsername",y);
                    b.putString("textViewName",a);
                    b.putString("textViewId", String.valueOf(x));
                    b.putString("textViewContactnumber", String.valueOf(cd));

                    HomePage.putExtras(b);
                    startActivity(HomePage);
                } else {
                    Toast.makeText(LoginActivity.this, "Login Error", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
