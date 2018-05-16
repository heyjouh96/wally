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

public class SearchAdapter extends RecyclerView.Adapter {

    private ArrayList<String> wally;
    private Context context;

    public SearchAdapter(ArrayList<String> wally, Context context) {
        this.wally = wally;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.layout_search_wally, parent, false);

        SearchViewHolder holder = new SearchViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        SearchViewHolder h = (SearchViewHolder) holder;
        String professor = wally.get(position);
        h.nome.setText(professor);
    }

    @Override
    public int getItemCount() {
        return wally.size();
    }
}
