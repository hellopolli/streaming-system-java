package model;

import java.io.Serializable;

public class Avaliacao implements Serializable {

    private int id;
    private int nota;
    private String comentario;

    public Avaliacao(int id,
                     int nota,
                     String comentario) {

        this.id = id;
        this.nota = nota;
        this.comentario = comentario;
    }

    public int getId() {
        return id;
    }

    public int getNota() {
        return nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {

        return "Nota: "
                + nota
                + " | "
                + comentario;
    }
}