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

public class HorariosFragment extends android.support.v4.app.Fragment {

    TextView txtHorario;
    RecyclerView recyclerView;

    public HorariosFragment () {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_horarios, container, false);
        txtHorario = (TextView)view.findViewById(R.id.horario);

        Bundle bundle = getArguments();
        String horario = bundle.getString("horario");
        txtHorario.setText(""+horario);

        recyclerView = view.findViewById(R.id.wally_recycler);

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

        recyclerView.setAdapter(new WallyAdapter(wally, view.getContext()));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }
}
