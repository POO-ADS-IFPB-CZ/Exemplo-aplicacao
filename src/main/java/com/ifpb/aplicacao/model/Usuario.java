package com.ifpb.aplicacao.model;

import com.ifpb.aplicacao.enumeration.Cargo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Usuario implements Serializable {

    private String nome;
    private LocalDate nascimento;
    private char sexo;
    private Cargo cargo;
    private String login;
    private String senha;

    public Usuario() {
    }

    public Usuario(String nome, LocalDate nascimento, char sexo, Cargo cargo, String login, String senha) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.cargo = cargo;
        this.login = login;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", nascimento=" + nascimento +
                ", sexo=" + sexo +
                ", cargo=" + cargo +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(getLogin(), usuario.getLogin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogin());
    }
}
