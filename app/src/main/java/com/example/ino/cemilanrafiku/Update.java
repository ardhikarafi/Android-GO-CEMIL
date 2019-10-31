package com.example.ino.cemilanrafiku;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {

    EditText txtNama, txtpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_activity);

        SharedPreferences customsharedpreferences = getSharedPreferences("AYAMKU", MODE_PRIVATE);
        txtNama = (EditText) findViewById(R.id.txtnama);
        txtNama.setText(customsharedpreferences.getString("nama", null));
        txtpass = (EditText) findViewById(R.id.txtpass);
        txtpass.setText(customsharedpreferences.getString("pass", null));
    }

    private void savePreferences() {
        SharedPreferences customsharedpreferences = getSharedPreferences("AYAMKU", MODE_PRIVATE);
        SharedPreferences.Editor editor = customsharedpreferences.edit();
        editor.putString("namaku", txtNama.getText().toString());
        editor.putString("pass", txtpass.getText().toString());
        editor.apply();

    }

    public void update(View view) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Apakah anda yakin dengan data yang anda masukan?");
        alertDialogBuilder.setPositiveButton("yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        savePreferences();
                        Toast.makeText(Update.this,"DATA BERHASIL DI UPDATE",Toast.LENGTH_LONG).show();
                    }
                });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Update.this, "Silahkan ulangi", Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
