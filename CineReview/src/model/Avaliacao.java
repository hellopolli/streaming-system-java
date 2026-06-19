package model;

import java.io.Serializable;
import java.time.LocalDateTime;


public class Avaliacao implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private int usuarioId;
    private int conteudoId;
    private String tipoConteudo;
    private double nota;
    private LocalDateTime data;

    public Avaliacao(int id, int usuarioId, int conteudoId, String tipoConteudo, double nota) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.conteudoId = conteudoId;
        this.tipoConteudo = tipoConteudo;
        this.nota = nota;
        this.data = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getConteudoId() {
        return conteudoId;
    }

    public void setConteudoId(int conteudoId) {
        this.conteudoId = conteudoId;
    }

    public String getTipoConteudo() {
        return tipoConteudo;
    }

    public void setTipoConteudo(String tipoConteudo) {
        this.tipoConteudo = tipoConteudo;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public LocalDateTime getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Avaliacao " + id + " | Usuario: " + usuarioId + " | Conteudo: "
                + tipoConteudo + "#" + conteudoId + " | Nota: " + nota;
    }
}
