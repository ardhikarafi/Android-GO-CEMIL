package com.example.ino.cemilanrafiku;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailGemblong extends AppCompatActivity {
    TextView cemilan;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desc_gemblong);
        getSupportActionBar().setTitle("Gemblong");
        cemilan = (TextView)findViewById(R.id.cemilan);
        Intent detail = getIntent();
        String namacemilan = detail.getStringExtra("title");
        cemilan.setText(namacemilan);
    }
}
