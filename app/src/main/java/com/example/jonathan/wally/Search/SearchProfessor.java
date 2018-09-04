package com.example.jonathan.wally.Search;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jonathan.wally.R;
import com.example.jonathan.wally.Responses.SearchWallyResponse;
import com.example.jonathan.wally.Schedule.ScheduleProfessor;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SearchProfessor extends AppCompatActivity {

    RecyclerView recyclerView;
    SearchWallyResponse wally;
    TextView txtCarregando;
    EditText edtPesq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_professor);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        recyclerView = findViewById(R.id.search_recycler);
        txtCarregando = findViewById(R.id.txtCarregando);
        edtPesq = findViewById(R.id.edtPesq);
    }

    public void wallySchedule(View v){
        int id = Integer.parseInt(v.getTag().toString());
        Intent it = new Intent(this, ScheduleProfessor.class);
        it.putExtra("id", id);
        startActivity(it);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void search(View v){

        recyclerView.setVisibility(View.INVISIBLE);
        txtCarregando.setText("Carregando...");
        String filtro = edtPesq.getText().toString();

        try {
            getWallyResponse(filtro);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getWallyResponse(String filtro) throws IOException{
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://www.fatecrl.edu.br/wallyAPI/wally/"+filtro)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String myResponse = response.body().string();

                SearchProfessor.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONArray json = new JSONArray(myResponse);
                            ArrayList<SearchWallyResponse> wallyArr = new ArrayList<>();

                            for (int i = 0; i < json.length(); i++){
                                wally = new SearchWallyResponse(json.getJSONObject(i).getString("nome"),
                                        json.getJSONObject(i).getString("apelido"),
                                        json.getJSONObject(i).getInt("id"));

                                wallyArr.add(wally);
                            }

                            recyclerView.setAdapter(new SearchProfessorAdapter(wallyArr, SearchProfessor.this));
                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SearchProfessor.this, LinearLayoutManager.VERTICAL, false);
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setVisibility(View.VISIBLE);
                            txtCarregando.setText("");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}
