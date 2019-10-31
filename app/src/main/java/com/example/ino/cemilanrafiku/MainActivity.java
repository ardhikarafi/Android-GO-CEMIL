package com.example.ino.cemilanrafiku;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        CemilanAdapter.ItemClickListener {
    private RecyclerView recyclerView;
    private CemilanAdapter cemilanAdapter;
    private ArrayList<Cemilan> cemilans;
    private TextView totalPrice;
    private double price = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/


        addData();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        cemilanAdapter = new CemilanAdapter(cemilans, this, this);
        GridLayoutManager manager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(cemilanAdapter);
        cemilanAdapter.setClickListener(this);
        totalPrice = (TextView) findViewById(R.id.totalPrice);
        totalPrice.setText(String.valueOf(price));

        totalPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = totalPrice.getText().toString();
                Intent myintent = new Intent(v.getContext(), TotalPembayaran.class);
                myintent.putExtra("mytext", text);
                startActivity(myintent);
            }
        });
    }


    @Override
    public void onClick(View view, int position) {
        final Cemilan cemilan = cemilans.get(position);
        price = price + cemilan.getPrice();
        totalPrice.setText(String.valueOf(price));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle app bar item clicks here. The app bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_maps:
                Intent maps = new Intent();
                maps.setAction(Intent.ACTION_VIEW);
                // Using the coordinates for Google headquarters.
                String data = getString(R.string.google_mtv_coord_zoom12);
                maps.setData(Uri.parse(data));
                if (maps.resolveActivity(getPackageManager()) != null) {
                    startActivity(maps);
                }
                return true;
            case R.id.action_call:
                Intent call = new Intent(Intent.ACTION_DIAL);
                call.setData(Uri.parse("tel:08122504729"));
                startActivity(call);
                return true;
            case R.id.action_update:
                Intent intent = new Intent(this, Update.class);
                startActivity(intent);
                return true;
            case R.id.action_sms:
                Intent sms = new Intent(Intent.ACTION_VIEW);
                sms.setData(Uri.parse("sms:08122504729"));
                startActivity(sms);
                return true;
            case R.id.action_detail:
                Intent pindah = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(pindah);
            default:
                // Do nothing
        }
        return super.onOptionsItemSelected(item);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void addData() {
        int[] covers = new int[]{
                R.drawable.capret,
                R.drawable.ganyong,
                R.drawable.gemblong,
                R.drawable.getuk,
                R.drawable.glundung,
                R.drawable.ongol,
                R.drawable.album7,
                R.drawable.album8,
                R.drawable.album9,
                R.drawable.album10};

        cemilans = new ArrayList<>();
        cemilans.add(new Cemilan(covers[0], "Capret", 10000.0));
        cemilans.add(new Cemilan(covers[1], "Ganyong", 20000.0));
        cemilans.add(new Cemilan(covers[2], "Gemblong", 30000.0));
        cemilans.add(new Cemilan(covers[3], "Getuk", 40000.0));
        cemilans.add(new Cemilan(covers[4], "Glundung", 50000.0));
        cemilans.add(new Cemilan(covers[5], "Ongol", 60000.0));
    }


}
