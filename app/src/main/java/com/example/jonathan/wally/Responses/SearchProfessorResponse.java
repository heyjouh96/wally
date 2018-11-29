package com.example.jonathan.wally.Responses;

import org.json.JSONObject;

/**
 * Created by Jonathan on 05/06/2018.
 */

public class SearchProfessorResponse {
    private String nome;
    private String apelido;
    private int id;
    private String img;

    public SearchProfessorResponse(String nome, String apelido, int id, String img){
        this.nome = nome;
        this.apelido = apelido;
        this.id = id;
        this.img = img;
    }

    public void setNome(String nome){this.nome = nome;}
    public String getNome(){return nome;}
    public void setApelido(String apelido){this.apelido = apelido;}
    public String getApelido(){return apelido;}
    public void setId(int id){this.id = id;}
    public int getId(){return id;}
    public void setImg(String img){this.img = img;}
    public String getImg(){return img;}
}
