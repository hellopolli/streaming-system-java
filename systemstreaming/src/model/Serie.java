package model;

import model.interfaces.Reproduzivel;

public class Serie extends Conteudo implements Reproduzivel {

    private int temporadas;

    public Serie(int id,
                 String titulo,
                 String genero,
                 int temporadas) {

        super(id, titulo, genero);
        this.temporadas = temporadas;
    }

    @Override
    public String exibirDetalhes() {

        return "Série: "
                + getTitulo()
                + " | Temporadas: "
                + temporadas;
    }

    @Override
    public void reproduzir() {
        System.out.println("Reproduzindo série...");
    }

    @Override
    public void pausar() {
        System.out.println("Série pausada.");
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    @Override
    public String toString() {
        return exibirDetalhes();
    }
}