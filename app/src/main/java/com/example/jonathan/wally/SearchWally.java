package com.example.jonathan.wally;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SearchWally extends AppCompatActivity {

    RecyclerView recyclerView;
    SearchWallyResponse wally;
    TextView txtCarregando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_wally);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        recyclerView = findViewById(R.id.search_recycler);
        txtCarregando = findViewById(R.id.txtCarregando);

        try {
            getWallyResponse();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void wallySchedule(View v){
        int id = Integer.parseInt(v.getTag().toString());
        Intent it = new Intent(this, ScheduleWally.class);
        it.putExtra("id", id);
        startActivity(it);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void getWallyResponse() throws IOException{
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://www.fatecrl.edu.br/wallyAPI/wally")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String myResponse = response.body().string();

                SearchWally.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONArray json = new JSONArray(myResponse);
                            ArrayList<SearchWallyResponse> wallyArr = new ArrayList<>();

                            for (int i = 0; i < json.length(); i++){
                                wally = new SearchWallyResponse(json.getJSONObject(i).getString("name"),
                                        json.getJSONObject(i).getString("apelido"),
                                        json.getJSONObject(i).getInt("id"));

                                wallyArr.add(wally);
                            }

                            recyclerView.setAdapter(new SearchAdapter(wallyArr, SearchWally.this));
                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SearchWally.this, LinearLayoutManager.VERTICAL, false);
                            recyclerView.setLayoutManager(layoutManager);
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
