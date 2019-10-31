package com.example.ino.cemilanrafiku;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        final EditText userName = (EditText) findViewById(R.id.etNewName);
        final EditText password = (EditText) findViewById(R.id.etNewPassword);
        final EditText NamaLengkap = (EditText) findViewById(R.id.etNewFullname);
        Button btnRegister = (Button) findViewById(R.id.btnNewRegister);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = getSharedPreferences("AYAMKU",MODE_PRIVATE);
                String newUser  = userName.getText().toString();
                String newPassword = password.getText().toString();
                String newFullName = NamaLengkap.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();

                //stores 3 new instances of sharedprefs. Both the user and password's keys are the same as the input.
                //Must be done this way because sharedprefs is stupid and inefficient. You cannot store Arrays easily
                //so I use strings instead.
                editor.putString("nama",newUser);
                editor.apply();
                editor.putString("pass", newPassword);
                editor.apply();
                editor.putString("namalengkap",newFullName);
                editor.putString(newUser + newPassword + "data", newUser + "\n" + newFullName);
                editor.apply();

                Toast.makeText(getApplicationContext(),"ANDA BERHASIL MELAKUKAN REGISTRASI",Toast.LENGTH_SHORT).show();
            }
        });

    }

}
