package controller;

import model.LogRegistro;
import util.LogUtil;

import java.util.ArrayList;


public class LogController {
    public void cadastrar(String acao, String mensagem) {
        LogUtil.registrar(acao, mensagem);
    }

    public boolean alterar(int id, String mensagem) {
        LogUtil.registrar("LOG", "Logs sao registros historicos e nao sao alterados. Solicitacao: " + mensagem);
        return false;
    }

    public boolean excluir(int id) {
        LogUtil.registrar("LOG", "Logs sao preservados. Exclusao solicitada para linha: " + id);
        return false;
    }

    public ArrayList<LogRegistro> listar() {
        ArrayList<LogRegistro> registros = new ArrayList<>();
        for (String linha : LogUtil.lerLogs()) {
            registros.add(new LogRegistro("REGISTRO", linha));
        }
        return registros;
    }
}
