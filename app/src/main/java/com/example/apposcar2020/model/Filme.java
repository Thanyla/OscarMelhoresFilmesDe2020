package com.example.apposcar2020.model;

public class Filme {
    private String nome;
    private String diretor;
    private String categoria;

    @Override
    public String toString() {
        return "Filme{" +
                "nome='" + nome + '\'' +
                ", diretor='" + diretor + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }

    public Filme(String nome, String diretor, String categoria) {
        this.nome = nome;
        this.diretor = diretor;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
