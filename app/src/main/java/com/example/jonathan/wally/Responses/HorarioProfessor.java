package com.example.jonathan.wally.Responses;

import org.json.JSONObject;

/**
 * Created by Jonathan on 05/06/2018.
 */

public class HorarioProfessor {
    private JSONObject horarios;

    public HorarioProfessor(JSONObject horarios){
        this.horarios = horarios;
    }

    public void setHorarios(JSONObject horarios){this.horarios = horarios;}
    public JSONObject getHorarios(){return horarios;}
}
