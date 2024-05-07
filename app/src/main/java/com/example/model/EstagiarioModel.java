package com.example.model;

import java.io.File;
import java.util.Date;

public class EstagiarioModel {

    private int id;
    private String nome;
    private int matricula;
    private int nomeCurso;
    private Date dataIngresso;
    private String telefone;
    private String email;
    private File relatorio1;
    private File relatorio2;
    private String statusRelatorio1;
    private String statusRelatorio2;
    private File comprovanteMatricula;

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getNome() {return nome;}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(int nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Date getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(Date dataIngresso) {
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

    public File getRelatorio1() {
        return relatorio1;
    }

    public void setRelatorio1(File relatorio1) {
        this.relatorio1 = relatorio1;
    }

    public File getRelatorio2() {
        return relatorio2;
    }

    public void setRelatorio2(File relatorio2) {
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

    public File getComprovanteMatricula() {
        return comprovanteMatricula;
    }

    public void setComprovanteMatricula(File comprovanteMatricula) {
        this.comprovanteMatricula = comprovanteMatricula;
    }
}
