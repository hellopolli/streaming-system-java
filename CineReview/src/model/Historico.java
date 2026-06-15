package model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Registro de conteudo assistido por um usuario.
 */
public class Historico implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private int usuarioId;
    private int conteudoId;
    private String tipoConteudo;
    private LocalDateTime dataAssistido;

    public Historico(int id, int usuarioId, int conteudoId, String tipoConteudo) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.conteudoId = conteudoId;
        this.tipoConteudo = tipoConteudo;
        this.dataAssistido = LocalDateTime.now();
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

    public LocalDateTime getDataAssistido() {
        return dataAssistido;
    }

    @Override
    public String toString() {
        return "Historico " + id + " | Usuario: " + usuarioId + " assistiu "
                + tipoConteudo + "#" + conteudoId + " em " + dataAssistido;
    }
}
