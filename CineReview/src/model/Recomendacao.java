package model;

import java.io.Serializable;


public class Recomendacao implements Serializable {
    private static final long serialVersionUID = 1L;

    private int usuarioId;
    private String mensagem;

    public Recomendacao(int usuarioId, String mensagem) {
        this.usuarioId = usuarioId;
        this.mensagem = mensagem;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public String getMensagem() {
        return mensagem;
    }

    @Override
    public String toString() {
        return "Usuario " + usuarioId + ": " + mensagem;
    }
}
