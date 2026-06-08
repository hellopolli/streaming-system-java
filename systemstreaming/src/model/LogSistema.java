package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class LogSistema implements Serializable {

    private LocalDateTime dataHora;
    private String mensagem;

    public LogSistema(String mensagem) {

        this.dataHora = LocalDateTime.now();
        this.mensagem = mensagem;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getMensagem() {
        return mensagem;
    }

    @Override
    public String toString() {

        return dataHora
                + " - "
                + mensagem;
    }
}