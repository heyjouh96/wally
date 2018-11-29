package com.example.jonathan.wally.Schedule;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
    TextView a1, a2, a3, a4, a5, a6;
    TextView b1, b2, b3, b4, b5, b6;
    TextView c1, c2, c3, c4, c5, c6;
    TextView d1, d2, d3, d4, d5, d6;
    TextView e1, e2, e3, e4, e5, e6;
    TextView f1, f2, f3, f4, f5, f6;
    TextView g1, g2, g3, g4, g5, g6;
    TextView h1, h2, h3, h4, h5, h6;
    TextView i1, i2, i3, i4, i5, i6;
    TextView j1, j2, j3, j4, j5, j6;
    TextView k1, k2, k3, k4, k5, k6;
    TextView l1, l2, l3, l4, l5, l6;
    TextView m1, m2, m3, m4, m5, m6;
    TextView n1, n2, n3, n4, n5, n6;
    TextView o1, o2, o3, o4, o5, o6;
    TextView p1, p2, p3, p4, p5, p6;
    TextView q1, q2, q3, q4, q5, q6;
    TextView r1, r2, r3, r4, r5, r6;
    TextView s1, s2, s3, s4, s5, s6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_professor);

        Intent it = getIntent();
        int id = it.getIntExtra("id", 0);

        txtNomeWally = findViewById(R.id.txtNomeWally);
        // a
        a1 = findViewById(R.id.a1);
        a2 = findViewById(R.id.a2);
        a3 = findViewById(R.id.a3);
        a4 = findViewById(R.id.a4);
        a5 = findViewById(R.id.a5);
        a6 = findViewById(R.id.a6);
        // b
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        // c
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        c5 = findViewById(R.id.c5);
        c6 = findViewById(R.id.c6);
        // d
        d1 = findViewById(R.id.d1);
        d2 = findViewById(R.id.d2);
        d3 = findViewById(R.id.d3);
        d4 = findViewById(R.id.d4);
        d5 = findViewById(R.id.d5);
        d6 = findViewById(R.id.d6);
        // e
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);
        e4 = findViewById(R.id.e4);
        e5 = findViewById(R.id.e5);
        e6 = findViewById(R.id.e6);
        // f
        f1 = findViewById(R.id.f1);
        f2 = findViewById(R.id.f2);
        f3 = findViewById(R.id.f3);
        f4 = findViewById(R.id.f4);
        f5 = findViewById(R.id.f5);
        f6 = findViewById(R.id.f6);
        // g
        g1 = findViewById(R.id.g1);
        g2 = findViewById(R.id.g2);
        g3 = findViewById(R.id.g3);
        g4 = findViewById(R.id.g4);
        g5 = findViewById(R.id.g5);
        g6 = findViewById(R.id.g6);
        // h
        h1 = findViewById(R.id.h1);
        h2 = findViewById(R.id.h2);
        h3 = findViewById(R.id.h3);
        h4 = findViewById(R.id.h4);
        h5 = findViewById(R.id.h5);
        h6 = findViewById(R.id.h6);
        // i
        i1 = findViewById(R.id.i1);
        i2 = findViewById(R.id.i2);
        i3 = findViewById(R.id.i3);
        i4 = findViewById(R.id.i4);
        i5 = findViewById(R.id.i5);
        i6 = findViewById(R.id.i6);
        // j
        j1 = findViewById(R.id.j1);
        j2 = findViewById(R.id.j2);
        j3 = findViewById(R.id.j3);
        j4 = findViewById(R.id.j4);
        j5 = findViewById(R.id.j5);
        j6 = findViewById(R.id.j6);
        // k
        k1 = findViewById(R.id.k1);
        k2 = findViewById(R.id.k2);
        k3 = findViewById(R.id.k3);
        k4 = findViewById(R.id.k4);
        k5 = findViewById(R.id.k5);
        k6 = findViewById(R.id.k6);
        // l
        l1 = findViewById(R.id.l1);
        l2 = findViewById(R.id.l2);
        l3 = findViewById(R.id.l3);
        l4 = findViewById(R.id.l4);
        l5 = findViewById(R.id.l5);
        l6 = findViewById(R.id.l6);
        // m
        m1 = findViewById(R.id.m1);
        m2 = findViewById(R.id.m2);
        m3 = findViewById(R.id.m3);
        m4 = findViewById(R.id.m4);
        m5 = findViewById(R.id.m5);
        m6 = findViewById(R.id.m6);
        // n
        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        n3 = findViewById(R.id.n3);
        n4 = findViewById(R.id.n4);
        n5 = findViewById(R.id.n5);
        n6 = findViewById(R.id.n6);
        // o
        o1 = findViewById(R.id.o1);
        o2 = findViewById(R.id.o2);
        o3 = findViewById(R.id.o3);
        o4 = findViewById(R.id.o4);
        o5 = findViewById(R.id.o5);
        o6 = findViewById(R.id.o6);
        // p
        p1 = findViewById(R.id.p1);
        p2 = findViewById(R.id.p2);
        p3 = findViewById(R.id.p3);
        p4 = findViewById(R.id.p4);
        p5 = findViewById(R.id.p5);
        p6 = findViewById(R.id.p6);
        // q
        q1 = findViewById(R.id.q1);
        q2 = findViewById(R.id.q2);
        q3 = findViewById(R.id.q3);
        q4 = findViewById(R.id.q4);
        q5 = findViewById(R.id.q5);
        q6 = findViewById(R.id.q6);
        // r
        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        r3 = findViewById(R.id.r3);
        r4 = findViewById(R.id.r4);
        r5 = findViewById(R.id.r5);
        r6 = findViewById(R.id.r6);
        // s
        s1 = findViewById(R.id.s1);
        s2 = findViewById(R.id.s2);
        s3 = findViewById(R.id.s3);
        s4 = findViewById(R.id.s4);
        s5 = findViewById(R.id.s5);
        s6 = findViewById(R.id.s6);

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
                    @Override
                    public void run() {
                        try {
                            JSONObject json = new JSONObject(myResponse);
                            horario = new HorarioProfessor(json.getJSONObject("horarios"));


                            /*ArrayList<WallyHorario> horariosArr = new ArrayList<>();

                            for (int i = 0; i < horarios.length(); i++) {
                                horario = new WallyHorario(horarios.getJSONObject(i).getString("TB_Hora_id_hora"),
                                        horarios.getJSONObject(i).getString("TB_Semana_id_semana"),
                                        horarios.getJSONObject(i).getString("ds_sigla_curso"));

                                horariosArr.add(horario);
                            }*/

                            /*wally = new ScheduleProfessorResponse(json.getJSONObject("professor").getString("nm_pessoa")
                                    , horariosArr);*/
                            txtNomeWally.setText(
                                    horario.getHorarios()
                                            .getJSONObject("dias")
                                            .getJSONArray("Quarta")
                                            .getJSONObject(0)
                                            .getString("hora"));

                            /*for (WallyHorario h : wally.getHorarios()){
                                fillSchedule(h);
                            }*/

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    public void fillSchedule(WallyHorario horario){
        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors = horario.getCursoColors();
        switch (horario.getHora()){
            case "1":
                switch (horario.getSemana()){
                    case "1": a1.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "2": a2.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "3": a3.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "4": a4.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "5": a5.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "6": a6.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                }
            break;
            case "2":
                switch (horario.getSemana()){
                    case "1": b1.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "2": b2.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "3": b3.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "4": b4.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "5": b5.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "6": b6.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                }
            break;
            case "3":
                switch (horario.getSemana()){
                    case "1": c1.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "2": c2.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "3": c3.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "4": c4.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "5": c5.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "6": c6.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                }
            break;
            case "4":
                switch (horario.getSemana()){
                    case "1": d1.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "2": d2.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "3": d3.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "4": d4.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "5": d5.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "6": d6.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                }
            break;
            case "5":
                switch (horario.getSemana()){
                    case "1": e1.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "2": e2.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "3": e3.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "4": e4.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "5": e5.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "6": e6.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                }
            break;
            case "6":
                switch (horario.getSemana()){
                    case "1": f1.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "2": f2.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "3": f3.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "4": f4.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "5": f5.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "6": f6.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                }
            break;
            case "7":
                switch (horario.getSemana()){
                    case "1": g1.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "2": g2.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "3": g3.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "4": g4.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "5": g5.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "6": g6.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                }
             break;
            case "8":
                switch (horario.getSemana()){
                    case "1": h1.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "2": h2.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "3": h3.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "4": h4.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "5": h5.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "6": h6.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                }
            break;
            case "9":
                switch (horario.getSemana()){
                    case "1": i1.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "2": i2.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "3": i3.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "4": i4.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "5": i5.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "6": i6.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                }
            break;
            case "10":
                switch (horario.getSemana()){
                    case "1": j1.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "2": j2.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "3": j3.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "4": j4.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "5": j5.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "6": j6.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                }
            break;
            case "11":
                switch (horario.getSemana()){
                    case "1": k1.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "2": k2.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "3": k3.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "4": k4.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "5": k5.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "6": k6.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                }
            break;
            case "12":
                switch (horario.getSemana()){
                    case "1": l1.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "2": l2.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "3": l3.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "4": l4.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "5": l5.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "6": l6.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                }
            break;
            case "13":
                switch (horario.getSemana()){
                    case "1": m1.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "2": m2.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "3": m3.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "4": m4.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "5": m5.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "6": m6.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                }
            break;
            case "14":
                switch (horario.getSemana()){
                    case "1": n1.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "2": n2.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "3": n3.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "4": n4.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "5": n5.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "6": n6.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                }
            break;
            case "15":
                switch (horario.getSemana()){
                    case "1": o1.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "2": o2.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "3": o3.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "4": o4.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "5": o5.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "6": o6.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                }
            break;
            case "16":
                switch (horario.getSemana()){
                    case "1": p1.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "2": p2.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "3": p3.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "4": p4.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "5": p5.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "6": p6.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                }
            break;
            case "17":
                switch (horario.getSemana()){
                    case "1": q1.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "2": q2.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "3": q3.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "4": q4.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "5": q5.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "6": q6.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                }
            break;
            case "18":
                switch (horario.getSemana()){
                    case "1": r1.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "2": r2.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "3": r3.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "4": r4.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "5": r5.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "6": r6.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                }
            break;
            case "19":
                switch (horario.getSemana()){
                    case "1": s1.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "2": s2.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "3": s3.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "4": s4.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "5": s5.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                    case "6": s6.setBackgroundColor(Color.rgb(colors.get(0), colors.get(1), colors.get(2)));break;
                }
            break;
        }
    }

}
