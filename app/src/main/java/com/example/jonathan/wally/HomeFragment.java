package com.example.jonathan.wally;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jonathan on 17/05/2018.
 */

public class HomeFragment extends android.support.v4.app.Fragment {

    TextView txtHorario;
    RecyclerView recyclerView;

    public HomeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        txtHorario = (TextView)view.findViewById(R.id.horario);

        Bundle bundle = getArguments();
        String horario = bundle.getString("horario");
        txtHorario.setText(""+horario);

        recyclerView = view.findViewById(R.id.home_recycler);

        ArrayList<String> wally = new ArrayList<>();
        wally.add("Chiara");
        wally.add("Garcia");
        wally.add("Dora");
        wally.add("Mauricio");
        wally.add("Ruy");
        wally.add("Rosimeire");
        wally.add("Sobrino");
        wally.add("Ciro");
        wally.add("Taipina");

        recyclerView.setAdapter(new HomeProfessorAdapter(wally, view.getContext()));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }
}
