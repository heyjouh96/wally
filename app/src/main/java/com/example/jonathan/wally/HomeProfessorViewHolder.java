package com.example.jonathan.wally;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Jonathan on 10/05/2018.
 */

public class HomeProfessorViewHolder extends RecyclerView.ViewHolder {

    final TextView nome;

    public HomeProfessorViewHolder(View view) {
        super(view);
        nome = view.findViewById(R.id.edtNome);
    }
}
