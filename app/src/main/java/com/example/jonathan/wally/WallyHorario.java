package com.example.jonathan.wally;

/**
 * Created by Jonathan on 05/06/2018.
 */

public class WallyHorario {
    private String hora;
    private String semana;
    /* private String ciclo;
    private String curso; */

    public WallyHorario(String hora, String semana){
        this.hora = hora;
        this.semana = semana;
    }

    public void setHora(String hora){this.hora = hora;}
    public String getHora(){return hora;}
    public void setSemana(String semana){this.semana = semana;}
    public String getSemana(){return semana;}

}
