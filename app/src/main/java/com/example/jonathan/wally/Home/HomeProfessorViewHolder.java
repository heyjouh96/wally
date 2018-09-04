package com.example.jonathan.wally.Home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.jonathan.wally.R;

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
