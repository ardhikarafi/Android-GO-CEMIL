package com.example.ino.cemilanrafiku;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

public class TotalPembayaran extends AppCompatActivity {

    EditText txttotal,txtpembayaran,txtkembalian;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.total_acitivity);

        txttotal = (EditText)findViewById(R.id.etTotal);
        txtpembayaran = (EditText)findViewById(R.id.etPembayaran);
        txtkembalian = (EditText)findViewById(R.id.etkembalian);

        txttotal.setText(getIntent().getStringExtra("mytext"));

        txtpembayaran.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(txtpembayaran.getText().length() != 0){
                    double total = Double.parseDouble(txttotal.getText().toString());
                    double pembayaran = Double.parseDouble(txtpembayaran.getText().toString());
                    double hasil = pembayaran- total;

                    txtkembalian.setText(String.valueOf(hasil));
                }else{
                    Toast.makeText(getApplicationContext(),"Angka Tidak Boleh Kosong",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
