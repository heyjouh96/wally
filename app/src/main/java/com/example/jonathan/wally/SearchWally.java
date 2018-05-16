package com.example.jonathan.wally;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class SearchWally extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_wally);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.search_recycler);

        ArrayList<String> wally = new ArrayList<>();
        wally.add("Chiara");
        wally.add("Garcia");
        wally.add("Dora");
        wally.add("Mauricio");
        wally.add("Ruy");
        wally.add("Rosimeire");
        wally.add("Sobrino");
        wally.add("Ciro");
        wally.add("Taipina");

        recyclerView.setAdapter(new SearchAdapter(wally, this));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void wallySchedule(View v){
        Intent it = new Intent(this, ScheduleWally.class);
        startActivity(it);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
