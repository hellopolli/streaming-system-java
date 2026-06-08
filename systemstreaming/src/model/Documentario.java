package model;

import model.interfaces.Reproduzivel;

public class Documentario extends Conteudo implements Reproduzivel {

    private String tema;

    public Documentario(int id,
                        String titulo,
                        String genero,
                        String tema) {

        super(id, titulo, genero);
        this.tema = tema;
    }

    @Override
    public String exibirDetalhes() {

        return "Documentário: "
                + getTitulo()
                + " | Tema: "
                + tema;
    }

    @Override
    public void reproduzir() {
        System.out.println("Reproduzindo documentário...");
    }

    @Override
    public void pausar() {
        System.out.println("Documentário pausado.");
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    @Override
    public String toString() {
        return exibirDetalhes();
    }
}