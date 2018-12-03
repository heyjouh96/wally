package com.example.jonathan.wally.Schedule;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridLayout;
import android.widget.TextView;

import com.example.jonathan.wally.R;
import com.example.jonathan.wally.Responses.HorarioProfessor;
import com.example.jonathan.wally.Responses.ScheduleProfessorResponse;
import com.example.jonathan.wally.Responses.WallyHorario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ScheduleProfessor extends AppCompatActivity {

    HorarioProfessor horario;

    ScheduleProfessorResponse wally;
    TextView txtNomeWally;
    GridLayout gridSegunda, gridTerca, gridQuarta, gridQuinta, gridSexta, gridSabado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_professor);

        Intent it = getIntent();
        int id = it.getIntExtra("id", 0);

        txtNomeWally = findViewById(R.id.txtNomeWally);
        gridSegunda = findViewById(R.id.gridSegunda);
        gridTerca = findViewById(R.id.gridTerca);
        gridQuarta = findViewById(R.id.gridQuarta);
        gridQuinta = findViewById(R.id.gridQuinta);
        gridSexta = findViewById(R.id.gridSexta);
        gridSabado = findViewById(R.id.gridSabado);

        try {
            getWallyScheduleResponse(id);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void getWallyScheduleResponse(int id) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://fatecrl.edu.br/wally/getHorario/"+id)
                //.url("http://localhost/rest/index.php/wallyapi/wallySchedule/")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String myResponse = response.body().string();

                ScheduleProfessor.this.runOnUiThread(new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void run() {
                        try {
                            JSONObject json = new JSONObject(myResponse);
                            horario = new HorarioProfessor(json.getJSONObject("horarios"));

                            fillSchedule(horario);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    // RECEBE O JSON "HORARIO" E INSERE COMO TEXTVIEW NO LAYOUT "SCHEDULE_PROFESSOR"
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void fillSchedule(HorarioProfessor horario) throws JSONException {
        int coluna = 0;
        JSONObject horarios = horario.getHorarios().getJSONObject("dias");

        // segunda
        for(int i = 0; i <= horarios.getJSONArray("Segunda").length() -1; i++){
            if(coluna == 4) {
                coluna = 0;
            }
            TextView ds_horario = new TextView(ScheduleProfessor.this);
            ds_horario.setText(
                    horarios.getJSONArray("Segunda")
                            .getJSONObject(i)
                            .getString("hora").substring(0, 5));

            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.setMargins(0, 5, 5, 0);
            ds_horario.setBackgroundColor(getResources().getColor(R.color.fatecRed));
            ds_horario.setTextColor(getResources().getColor(R.color.white));
            ds_horario.setPadding(10, 10, 10, 10);
            ds_horario.setTextSize(20);
            gridSegunda.addView(ds_horario);
            ds_horario.setLayoutParams(params);
            coluna++;
        }
        coluna = 0;
        // terça
        for(int i = 0; i <= horarios.getJSONArray("Terca").length()-1; i++){
            if(coluna == 4) {
                coluna = 0;
            }
            TextView ds_horario = new TextView(ScheduleProfessor.this);
            ds_horario.setText(
                    horarios.getJSONArray("Terca")
                            .getJSONObject(i)
                            .getString("hora").substring(0, 5));

            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.setMargins(0, 5, 5, 0);
            ds_horario.setBackgroundColor(getResources().getColor(R.color.fatecRed));
            ds_horario.setTextColor(getResources().getColor(R.color.white));
            ds_horario.setPadding(10, 10, 10, 10);
            ds_horario.setTextSize(20);
            gridTerca.addView(ds_horario);
            ds_horario.setLayoutParams(params);
            coluna++;
        }
        coluna = 0;
        // quarta
        for(int i = 0; i <= horarios.getJSONArray("Quarta").length()-1; i++){
            if(coluna == 4) {
                coluna = 0;
            }
            TextView ds_horario = new TextView(ScheduleProfessor.this);
            ds_horario.setText(
                    horarios.getJSONArray("Quarta")
                            .getJSONObject(i)
                            .getString("hora").substring(0, 5));

            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.setMargins(0, 5, 5, 0);
            ds_horario.setBackgroundColor(getResources().getColor(R.color.fatecRed));
            ds_horario.setTextColor(getResources().getColor(R.color.white));
            ds_horario.setPadding(10, 10, 10, 10);
            ds_horario.setTextSize(20);
            gridQuarta.addView(ds_horario);
            ds_horario.setLayoutParams(params);
            coluna++;
        }
        coluna = 0;
        // quinta
        for(int i = 0; i <= horarios.getJSONArray("Quinta").length()-1; i++){
            if(coluna == 4) {
                coluna = 0;
            }
            TextView ds_horario = new TextView(ScheduleProfessor.this);
            ds_horario.setText(
                    horarios.getJSONArray("Quinta")
                            .getJSONObject(i)
                            .getString("hora").substring(0, 5));

            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.setMargins(0, 5, 5, 0);
            ds_horario.setBackgroundColor(getResources().getColor(R.color.fatecRed));
            ds_horario.setTextColor(getResources().getColor(R.color.white));
            ds_horario.setPadding(10, 10, 10, 10);
            ds_horario.setTextSize(20);
            gridQuinta.addView(ds_horario);
            ds_horario.setLayoutParams(params);
            coluna++;
        }
        coluna = 0;
        // sexta
        for(int i = 0; i <= horarios.getJSONArray("Sexta").length()-1; i++){
            if(coluna == 4) {
                coluna = 0;
            }
            TextView ds_horario = new TextView(ScheduleProfessor.this);
            ds_horario.setText(
                    horarios.getJSONArray("Sexta")
                            .getJSONObject(i)
                            .getString("hora").substring(0, 5));

            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.setMargins(0, 5, 5, 0);
            ds_horario.setBackgroundColor(getResources().getColor(R.color.fatecRed));
            ds_horario.setTextColor(getResources().getColor(R.color.white));
            ds_horario.setPadding(10, 10, 10, 10);
            ds_horario.setTextSize(20);
            gridSexta.addView(ds_horario);
            ds_horario.setLayoutParams(params);
            coluna++;
        }
        coluna = 0;
        // sabado
        for(int i = 0; i <= horarios.getJSONArray("Sabado").length()-1; i++){
            if(coluna == 4) {
                coluna = 0;
            }
            TextView ds_horario = new TextView(ScheduleProfessor.this);
            ds_horario.setText(
                    horarios.getJSONArray("Sabado")
                            .getJSONObject(i)
                            .getString("hora").substring(0, 5));

            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.setMargins(0, 5, 5, 0);
            ds_horario.setBackgroundColor(getResources().getColor(R.color.fatecRed));
            ds_horario.setTextColor(getResources().getColor(R.color.white));
            ds_horario.setPadding(10, 10, 10, 10);
            ds_horario.setTextSize(20);
            gridSabado.addView(ds_horario);
            ds_horario.setLayoutParams(params);
            coluna++;
        }
    }

}
