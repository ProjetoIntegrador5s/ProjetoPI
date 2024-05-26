package com.projeto.model;

import androidx.room.*;

import com.google.gson.annotations.SerializedName;

@Dao
public class EstagiarioModel {

    @SerializedName("id")
    private int id;
    @SerializedName("nome")
    public String nome;
    @SerializedName("matricula")
    public String matricula;
    @SerializedName("nomeCurso")
    private String nomeCurso;
    @SerializedName("dataIngresso")
    private String dataIngresso;
    @SerializedName("telefone")
    private String telefone;
    @SerializedName("email")
    private String email;
    @SerializedName("relatorio1")
    private String relatorio1;
    @SerializedName("relatorio2")
    private String relatorio2;
    @SerializedName("statusRelatorio1")
    private String statusRelatorio1;
    @SerializedName("statusRelatorio2")
    private String statusRelatorio2;
    @SerializedName("comprovanteMatricula")
    private String comprovanteMatricula;

    public EstagiarioModel(int id,String nome, String matricula, String nomeCurso, String dataIngresso, String telefone, String email, String relatorio1, String relatorio2, String statusRelatorio1, String statusRelatorio2, String comprovanteMatricula) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.nomeCurso = nomeCurso;
        this.dataIngresso = dataIngresso;
        this.telefone = telefone;
        this.email = email;
        this.relatorio1 = relatorio1;
        this.relatorio2 = relatorio2;
        this.statusRelatorio1 = statusRelatorio1;
        this.statusRelatorio2 = statusRelatorio2;
        this.comprovanteMatricula = comprovanteMatricula;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getNome() {return nome;}
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(String dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRelatorio1() {
        return relatorio1;
    }

    public void setRelatorio1(String relatorio1) {
        this.relatorio1 = relatorio1;
    }

    public String getRelatorio2() {
        return relatorio2;
    }

    public void setRelatorio2(String relatorio2) {
        this.relatorio2 = relatorio2;
    }

    public String getStatusRelatorio1() {
        return statusRelatorio1;
    }

    public void setStatusRelatorio1(String statusRelatorio1) {
        this.statusRelatorio1 = statusRelatorio1;
    }

    public String getStatusRelatorio2() {
        return statusRelatorio2;
    }

    public void setStatusRelatorio2(String statusRelatorio2) {
        this.statusRelatorio2 = statusRelatorio2;
    }

    public String getComprovanteMatricula() {
        return comprovanteMatricula;
    }

    public void setComprovanteMatricula(String comprovanteMatricula) {
        this.comprovanteMatricula = comprovanteMatricula;
    }
}
