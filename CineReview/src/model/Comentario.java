package model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Comentario textual sobre um conteudo.
 */
public class Comentario implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private int usuarioId;
    private int conteudoId;
    private String tipoConteudo;
    private String texto;
    private LocalDateTime data;

    public Comentario(int id, int usuarioId, int conteudoId, String tipoConteudo, String texto) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.conteudoId = conteudoId;
        this.tipoConteudo = tipoConteudo;
        this.texto = texto;
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

    public int getConteudoId() {
        return conteudoId;
    }

    public String getTipoConteudo() {
        return tipoConteudo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Comentario " + id + " | Usuario: " + usuarioId + " | " + tipoConteudo
                + "#" + conteudoId + " | " + texto;
    }
}
