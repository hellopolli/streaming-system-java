package model;

import java.io.Serializable;

/**
 * Parte composta de uma serie. Episodios pertencem ao ciclo de vida da serie.
 */
public class Episodio implements Serializable {
    private static final long serialVersionUID = 1L;

    private int numero;
    private String titulo;
    private int duracaoMinutos;

    public Episodio(int numero, String titulo, int duracaoMinutos) {
        this.numero = numero;
        this.titulo = titulo;
        this.duracaoMinutos = duracaoMinutos;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    @Override
    public String toString() {
        return "Episodio " + numero + " - " + titulo + " (" + duracaoMinutos + " min)";
    }
}
