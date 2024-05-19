package com.projeto.network;

import com.google.gson.annotations.SerializedName;

public class ApiResponseModel {

    @SerializedName("id")
    private int id;
    @SerializedName("nome")
    public String nome;
    @SerializedName("matricula")
    public int matricula;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}
