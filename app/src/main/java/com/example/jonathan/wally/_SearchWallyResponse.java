package com.example.jonathan.wally;

/**
 * Created by Jonathan on 05/06/2018.
 */

public class _SearchWallyResponse {
    private String nome;
    private String apelido;
    private int id;

    public _SearchWallyResponse(String nome, String apelido, int id){
        this.nome = nome;
        this.apelido = apelido;
        this.id = id;
    }

    public void setNome(String nome){this.nome = nome;}
    public String getNome(){return nome;}
    public void setApelido(String apelido){this.apelido = apelido;}
    public String getApelido(){return apelido;}
    public void setId(int id){this.id = id;}
    public int getId(){return id;}

}
