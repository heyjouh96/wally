package com.example.jonathan.wally;

/**
 * Created by Jonathan on 05/06/2018.
 */

public class SearchWallyResponse {
    private String nome;
    private String apelido;
    private int id;
    private String img;

    public SearchWallyResponse(String nome, String apelido, int id, String img){
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
    public void setImg(String img){this.apelido = img;}
    public String getImg(){return img;}
}
