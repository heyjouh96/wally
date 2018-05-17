package com.example.jonathan.wally;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Jonathan on 17/05/2018.
 */

public class HorariosFragment extends android.support.v4.app.Fragment {

    TextView txtHorario;

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
        return view;
    }
}
