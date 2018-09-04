package com.example.jonathan.wally;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Jonathan on 10/05/2018.
 */

public class SearchProfessorViewHolder extends RecyclerView.ViewHolder {

    final TextView txtNome, txtApelido;
    final RelativeLayout container;

    public SearchProfessorViewHolder(View view) {
        super(view);
        txtNome = view.findViewById(R.id.txtNome);
        txtApelido = view.findViewById(R.id.txtApelido);
        container = view.findViewById(R.id.container);
    }
}
