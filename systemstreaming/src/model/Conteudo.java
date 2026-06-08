package model;

import java.io.Serializable;

public abstract class Conteudo implements Serializable {

    private int id;
    private String titulo;
    private String genero;
    private double avaliacao;

    public Conteudo(int id, String titulo, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
    }

    public abstract String exibirDetalhes();

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }
}