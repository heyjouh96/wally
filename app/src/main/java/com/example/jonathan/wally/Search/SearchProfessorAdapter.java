package com.example.jonathan.wally.Search;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jonathan.wally.R;
import com.example.jonathan.wally.Responses.SearchProfessorResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Jonathan on 10/05/2018.
 */

public class SearchProfessorAdapter extends RecyclerView.Adapter {

    private ArrayList<SearchProfessorResponse> wally;
    private Context context;

    public SearchProfessorAdapter(ArrayList<SearchProfessorResponse> wally, Context context) {
        this.wally = wally;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.search_professor_layout, parent, false);

        SearchProfessorViewHolder holder = new SearchProfessorViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        SearchProfessorViewHolder h = (SearchProfessorViewHolder) holder;
        String nome = wally.get(position).getNome();
        String apelido = wally.get(position).getApelido();
        int id = wally.get(position).getId();
        String img = wally.get(position).getImg();
        h.txtNome.setText(nome);
        h.txtApelido.setText(apelido);
        h.container.setTag(""+id);

        Picasso.get().load(img).resize(500, 560).centerCrop().into(h.imgWally);
    }

    @Override
    public int getItemCount() {
        return wally.size();
    }


}
