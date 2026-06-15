package controller;

import model.Avaliacao;
import model.Documentario;
import model.Filme;
import model.Serie;
import model.Usuario;
import util.AvaliacaoInvalidaException;
import util.Dados;
import util.LogUtil;
import util.ValidacaoUtil;

import java.util.ArrayList;

/**
 * Controller responsavel pelo CRUD de avaliacoes.
 */
public class AvaliacaoController {
    private final Dados dados;

    public AvaliacaoController(Dados dados) {
        this.dados = dados;
    }

    public void cadastrar(int id, int usuarioId, int conteudoId, String tipoConteudo, double nota)
            throws AvaliacaoInvalidaException {
        ValidacaoUtil.validarIdDuplicado(dados.getAvaliacoes(), id, Avaliacao::getId);
        ValidacaoUtil.validarCampoObrigatorio(tipoConteudo, "tipo de conteudo");
        ValidacaoUtil.validarNota(nota);
        Usuario usuario = buscarUsuario(usuarioId);
        if (usuario == null) {
            throw new IllegalArgumentException("Usuario nao encontrado.");
        }
        Avaliacao avaliacao = new Avaliacao(id, usuarioId, conteudoId, tipoConteudo, nota);
        associarAoConteudo(avaliacao);
        usuario.adicionarAvaliacao(avaliacao);
        dados.getAvaliacoes().add(avaliacao);
        dados.salvarTudo();
        LogUtil.registrar("AVALIACAO", "Avaliacao cadastrada: " + id);
    }

    public boolean alterar(int id, double nota) throws AvaliacaoInvalidaException {
        Avaliacao avaliacao = buscarPorId(id);
        if (avaliacao == null) {
            return false;
        }
        ValidacaoUtil.validarNota(nota);
        avaliacao.setNota(nota);
        sincronizarAvaliacoes();
        dados.salvarTudo();
        LogUtil.registrar("ALTERACAO", "Avaliacao alterada: " + id);
        return true;
    }

    public boolean excluir(int id) {
        Avaliacao avaliacao = buscarPorId(id);
        if (avaliacao == null) {
            return false;
        }
        dados.getAvaliacoes().remove(avaliacao);
        sincronizarAvaliacoes();
        dados.salvarTudo();
        LogUtil.registrar("EXCLUSAO", "Avaliacao excluida: " + id);
        return true;
    }

    public ArrayList<Avaliacao> listar() {
        return dados.getAvaliacoes();
    }

    public Avaliacao buscarPorId(int id) {
        for (Avaliacao avaliacao : dados.getAvaliacoes()) {
            if (avaliacao.getId() == id) {
                return avaliacao;
            }
        }
        return null;
    }

    private Usuario buscarUsuario(int id) {
        for (Usuario usuario : dados.getUsuarios()) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    private void associarAoConteudo(Avaliacao avaliacao) throws AvaliacaoInvalidaException {
        String tipo = avaliacao.getTipoConteudo().toLowerCase();
        if ("filme".equals(tipo)) {
            for (Filme filme : dados.getFilmes()) {
                if (filme.getId() == avaliacao.getConteudoId()) {
                    filme.adicionarAvaliacao(avaliacao);
                    return;
                }
            }
        } else if ("serie".equals(tipo) || "série".equals(tipo)) {
            for (Serie serie : dados.getSeries()) {
                if (serie.getId() == avaliacao.getConteudoId()) {
                    serie.adicionarAvaliacao(avaliacao);
                    return;
                }
            }
        } else if ("documentario".equals(tipo) || "documentário".equals(tipo)) {
            for (Documentario documentario : dados.getDocumentarios()) {
                if (documentario.getId() == avaliacao.getConteudoId()) {
                    documentario.adicionarAvaliacao(avaliacao);
                    return;
                }
            }
        }
        throw new IllegalArgumentException("Conteudo nao encontrado para avaliacao.");
    }

    private void sincronizarAvaliacoes() {
        for (Usuario usuario : dados.getUsuarios()) {
            usuario.getAvaliacoes().clear();
        }
        for (Filme filme : dados.getFilmes()) {
            filme.getAvaliacoes().clear();
        }
        for (Serie serie : dados.getSeries()) {
            serie.getAvaliacoes().clear();
        }
        for (Documentario documentario : dados.getDocumentarios()) {
            documentario.getAvaliacoes().clear();
        }
        for (Avaliacao avaliacao : dados.getAvaliacoes()) {
            try {
                Usuario usuario = buscarUsuario(avaliacao.getUsuarioId());
                if (usuario != null) {
                    usuario.adicionarAvaliacao(avaliacao);
                }
                associarAoConteudo(avaliacao);
            } catch (Exception e) {
                LogUtil.registrarErro("Falha ao sincronizar avaliacao", e);
            }
        }
    }
}
