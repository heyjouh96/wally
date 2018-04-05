package com.example.jonathan.wally;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SearchWally extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_wally);
    }

    public void wallySchedule(View v){
        Intent it = new Intent(this, ScheduleWally.class);
        startActivity(it);
    }
}
