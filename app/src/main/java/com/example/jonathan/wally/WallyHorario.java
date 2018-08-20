package com.example.jonathan.wally;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonathan on 05/06/2018.
 */

public class WallyHorario {
    private String hora;
    private String semana;
    //private String ciclo;
    private String curso;

    public WallyHorario(String hora, String semana, String curso){
        this.hora = hora;
        this.semana = semana;
        this.curso = curso;
    }

    public void setHora(String hora){this.hora = hora;}
    public String getHora(){return hora;}
    public void setSemana(String semana){this.semana = semana;}
    public String getSemana(){return semana;}
    public void setCurso (String curso) {this.curso = curso; }

    public ArrayList<Integer> getCursoColors() {
        ArrayList<Integer> colors = new ArrayList<Integer>();
        switch (this.curso) {
            case "ADS":
                colors.add(0, 20);
                colors.add(1, 94);
                colors.add(2, 167);
                break;
            case "GE":
                colors.add(0, 78);
                colors.add(1, 162);
                colors.add(2, 106);
                break;
            case "GP":
                colors.add(0, 66);
                colors.add(1, 154);
                colors.add(2, 138);
                break;
            case "LOG":
                colors.add(0, 110);
                colors.add(1, 84);
                colors.add(2, 148);
                break;
            case "SI":
                colors.add(0, 3);
                colors.add(1, 139);
                colors.add(2, 200);
                break;
        }
        return colors;
    }

}
