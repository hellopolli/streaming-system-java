package controller;

import model.Comentario;
import util.Dados;
import util.LogUtil;
import util.ValidacaoUtil;

import java.util.ArrayList;


public class ComentarioController {
    private final Dados dados;

    public ComentarioController(Dados dados) {
        this.dados = dados;
    }

    public void cadastrar(int id, int usuarioId, int conteudoId, String tipoConteudo, String texto) {
        ValidacaoUtil.validarIdDuplicado(dados.getComentarios(), id, Comentario::getId);
        ValidacaoUtil.validarCampoObrigatorio(tipoConteudo, "tipo de conteudo");
        ValidacaoUtil.validarCampoObrigatorio(texto, "texto");
        dados.getComentarios().add(new Comentario(id, usuarioId, conteudoId, tipoConteudo, texto));
        dados.salvarTudo();
        LogUtil.registrar("CADASTRO", "Comentario cadastrado: " + id);
    }

    public boolean alterar(int id, String texto) {
        Comentario comentario = buscarPorId(id);
        if (comentario == null) {
            return false;
        }
        ValidacaoUtil.validarCampoObrigatorio(texto, "texto");
        comentario.setTexto(texto);
        dados.salvarTudo();
        LogUtil.registrar("ALTERACAO", "Comentario alterado: " + id);
        return true;
    }

    public boolean excluir(int id) {
        Comentario comentario = buscarPorId(id);
        if (comentario == null) {
            return false;
        }
        dados.getComentarios().remove(comentario);
        dados.salvarTudo();
        LogUtil.registrar("EXCLUSAO", "Comentario excluido: " + id);
        return true;
    }

    public ArrayList<Comentario> listar() {
        return dados.getComentarios();
    }

    public Comentario buscarPorId(int id) {
        for (Comentario comentario : dados.getComentarios()) {
            if (comentario.getId() == id) {
                return comentario;
            }
        }
        return null;
    }
}
