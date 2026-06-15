package controller;

import model.Historico;
import util.Dados;
import util.LogUtil;
import util.ValidacaoUtil;

import java.util.ArrayList;

/**
 * Controller responsavel pelo CRUD de historico assistido.
 */
public class HistoricoController {
    private final Dados dados;

    public HistoricoController(Dados dados) {
        this.dados = dados;
    }

    public void cadastrar(int id, int usuarioId, int conteudoId, String tipoConteudo) {
        ValidacaoUtil.validarIdDuplicado(dados.getHistoricos(), id, Historico::getId);
        ValidacaoUtil.validarCampoObrigatorio(tipoConteudo, "tipo de conteudo");
        dados.getHistoricos().add(new Historico(id, usuarioId, conteudoId, tipoConteudo));
        dados.salvarTudo();
        LogUtil.registrar("CADASTRO", "Historico cadastrado: " + id);
    }

    public boolean alterar(int id, int usuarioId, int conteudoId, String tipoConteudo) {
        Historico historico = buscarPorId(id);
        if (historico == null) {
            return false;
        }
        dados.getHistoricos().remove(historico);
        dados.getHistoricos().add(new Historico(id, usuarioId, conteudoId, tipoConteudo));
        dados.salvarTudo();
        LogUtil.registrar("ALTERACAO", "Historico alterado: " + id);
        return true;
    }

    public boolean excluir(int id) {
        Historico historico = buscarPorId(id);
        if (historico == null) {
            return false;
        }
        dados.getHistoricos().remove(historico);
        dados.salvarTudo();
        LogUtil.registrar("EXCLUSAO", "Historico excluido: " + id);
        return true;
    }

    public ArrayList<Historico> listar() {
        return dados.getHistoricos();
    }

    public Historico buscarPorId(int id) {
        for (Historico historico : dados.getHistoricos()) {
            if (historico.getId() == id) {
                return historico;
            }
        }
        return null;
    }
}
