package model;

import java.io.Serializable;

/**
 * Conteudo marcado como favorito por um usuario.
 */
public class Favorito implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private int usuarioId;
    private int conteudoId;
    private String tipoConteudo;

    public Favorito(int id, int usuarioId, int conteudoId, String tipoConteudo) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.conteudoId = conteudoId;
        this.tipoConteudo = tipoConteudo;
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

    public int getConteudoId() {
        return conteudoId;
    }

    public String getTipoConteudo() {
        return tipoConteudo;
    }

    @Override
    public String toString() {
        return "Favorito " + id + " | Usuario: " + usuarioId + " | "
                + tipoConteudo + "#" + conteudoId;
    }
}
