package com.example.jonathan.wally;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ScheduleWally extends Activity {

    TextView txtNomeWally;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_wally);

        Intent it = getIntent();
        int id = it.getIntExtra("id", 0);

        txtNomeWally = findViewById(R.id.txtNomeWally);
        txtNomeWally.setText(""+id+" Jorge Chiara");
    }
}
