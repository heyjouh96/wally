package com.example.jonathan.wally.Responses;

import org.json.JSONObject;

/**
 * Created by Jonathan on 05/06/2018.
 */

public class HorarioProfessor {
    private JSONObject horarios;
    private String nm_professor;
    private String email;

    public HorarioProfessor(JSONObject horarios, String nm_professor, String email){
        this.horarios = horarios;
        this.nm_professor = nm_professor;
        this.email = email;
    }

    public void setHorarios(JSONObject horarios){this.horarios = horarios;}
    public JSONObject getHorarios(){return horarios;}
    public void setNomeProfessor(String nm_professor){this.nm_professor = nm_professor;}
    public String getNomeProfessor(){return nm_professor;}
    public void setEmail(String email){this.email = email;}
    public String getEmail(){
        if(email.equals("0")) {
            return "";
        } else {
            return email;
        }
    }
}
