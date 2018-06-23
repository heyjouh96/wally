package com.example.jonathan.wally;

import java.util.ArrayList;

/**
 * Created by Jonathan on 05/06/2018.
 */

public class ScheduleWallyResponse {
    private String nome;
    private ArrayList<WallyHorario> horarios;

    public ScheduleWallyResponse(String nome, ArrayList<WallyHorario> horarios){
        this.nome = nome;
        this.horarios = horarios;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<WallyHorario> getHorarios() {
        return horarios;
    }

    public void setHorarios(ArrayList<WallyHorario> horarios) {
        this.horarios = horarios;
    }
}
