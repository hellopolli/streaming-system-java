package model;

import model.interfaces.Reproduzivel;

public class Filme extends Conteudo implements Reproduzivel {

    private int duracao;

    public Filme(int id,
                 String titulo,
                 String genero,
                 int duracao) {

        super(id, titulo, genero);
        this.duracao = duracao;
    }

    @Override
    public String exibirDetalhes() {

        return "Filme: "
                + getTitulo()
                + " | Gênero: "
                + getGenero()
                + " | Duração: "
                + duracao + " min";
    }

    @Override
    public void reproduzir() {
        System.out.println("Reproduzindo filme...");
    }

    @Override
    public void pausar() {
        System.out.println("Filme pausado.");
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return exibirDetalhes();
    }
}