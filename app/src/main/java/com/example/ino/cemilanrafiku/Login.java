package com.example.ino.cemilanrafiku;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        final EditText etName = (EditText) findViewById(R.id.etName);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        Button btnRegister = (Button) findViewById(R.id.btnRegister);
        SharedPreferences customsharedpreferences = getSharedPreferences("AYAMKU", MODE_PRIVATE);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = etName.getText().toString();
                String password = etPassword.getText().toString();
                SharedPreferences preferences = getSharedPreferences("AYAMKU", MODE_PRIVATE);

                if(user.trim().length() > 0 && password.trim().length()>0 ){
                    String uname=null;
                    String upass=null;

                    if(preferences.contains("nama")){
                        uname=preferences.getString("nama","");
                    }
                    if(preferences.contains("pass")){
                        upass = preferences.getString("pass","");
                    }
                    if(user.equals(uname) && password.equals(upass)){
                        Intent i = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(i);
                    }else{
                        Toast.makeText(getApplicationContext(),"Maaf Password atau Username Salah",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Masukan Nama atau Password",Toast.LENGTH_LONG).show();

                }


            }
        });


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerScreen = new Intent(Login.this, Register.class);
                startActivity(registerScreen);
            }
        });
    }



}
