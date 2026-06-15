package model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Modelo para exibir entradas de log no padrao MVC.
 */
public class LogRegistro implements Serializable {
    private static final long serialVersionUID = 1L;

    private LocalDateTime data;
    private String acao;
    private String mensagem;

    public LogRegistro(String acao, String mensagem) {
        this.data = LocalDateTime.now();
        this.acao = acao;
        this.mensagem = mensagem;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getAcao() {
        return acao;
    }

    public String getMensagem() {
        return mensagem;
    }

    @Override
    public String toString() {
        return data + " | " + acao + " | " + mensagem;
    }
}
