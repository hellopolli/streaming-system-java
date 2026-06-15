package model;

import java.io.Serializable;

/**
 * Resultado textual de relatorios do sistema.
 */
public class Relatorio implements Serializable {
    private static final long serialVersionUID = 1L;

    private String titulo;
    private String resultado;

    public Relatorio(String titulo, String resultado) {
        this.titulo = titulo;
        this.resultado = resultado;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResultado() {
        return resultado;
    }

    @Override
    public String toString() {
        return titulo + System.lineSeparator() + resultado;
    }
}
