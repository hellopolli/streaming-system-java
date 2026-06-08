package model;

import java.io.Serializable;

public class Episodio implements Serializable {

    private String titulo;
    private int numero;

    public Episodio(String titulo,
                    int numero) {

        this.titulo = titulo;
        this.numero = numero;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {

        return "Ep "
                + numero
                + " - "
                + titulo;
    }
}