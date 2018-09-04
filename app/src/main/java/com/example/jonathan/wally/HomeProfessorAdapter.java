package com.example.jonathan.wally;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Jonathan on 10/05/2018.
 */

public class HomeProfessorAdapter extends RecyclerView.Adapter {

    private ArrayList<String> wally;
    private Context context;

    public HomeProfessorAdapter(ArrayList<String> wally, Context context) {
        this.wally = wally;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.home_layout, parent, false);

        HomeProfessorViewHolder holder = new HomeProfessorViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        HomeProfessorViewHolder h = (HomeProfessorViewHolder) holder;
        String professor = wally.get(position);
        h.nome.setText(professor);
    }

    @Override
    public int getItemCount() {
        return wally.size();
    }
}
