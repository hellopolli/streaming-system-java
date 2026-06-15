package controller;

import model.Favorito;
import model.Usuario;
import util.Dados;
import util.LogUtil;
import util.ValidacaoUtil;

import java.util.ArrayList;

/**
 * Controller responsavel pelo CRUD de favoritos.
 */
public class FavoritoController {
    private final Dados dados;

    public FavoritoController(Dados dados) {
        this.dados = dados;
    }

    public void cadastrar(int id, int usuarioId, int conteudoId, String tipoConteudo) {
        ValidacaoUtil.validarIdDuplicado(dados.getFavoritos(), id, Favorito::getId);
        ValidacaoUtil.validarCampoObrigatorio(tipoConteudo, "tipo de conteudo");
        Favorito favorito = new Favorito(id, usuarioId, conteudoId, tipoConteudo);
        dados.getFavoritos().add(favorito);
        Usuario usuario = buscarUsuario(usuarioId);
        if (usuario != null) {
            usuario.adicionarFavorito(favorito);
        }
        dados.salvarTudo();
        LogUtil.registrar("CADASTRO", "Favorito cadastrado: " + id);
    }

    public boolean alterar(int id, int usuarioId, int conteudoId, String tipoConteudo) {
        Favorito favorito = buscarPorId(id);
        if (favorito == null) {
            return false;
        }
        dados.getFavoritos().remove(favorito);
        dados.getFavoritos().add(new Favorito(id, usuarioId, conteudoId, tipoConteudo));
        sincronizarFavoritos();
        dados.salvarTudo();
        LogUtil.registrar("ALTERACAO", "Favorito alterado: " + id);
        return true;
    }

    public boolean excluir(int id) {
        Favorito favorito = buscarPorId(id);
        if (favorito == null) {
            return false;
        }
        dados.getFavoritos().remove(favorito);
        sincronizarFavoritos();
        dados.salvarTudo();
        LogUtil.registrar("EXCLUSAO", "Favorito excluido: " + id);
        return true;
    }

    public ArrayList<Favorito> listar() {
        return dados.getFavoritos();
    }

    public Favorito buscarPorId(int id) {
        for (Favorito favorito : dados.getFavoritos()) {
            if (favorito.getId() == id) {
                return favorito;
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

    private void sincronizarFavoritos() {
        for (Usuario usuario : dados.getUsuarios()) {
            usuario.getFavoritos().clear();
        }
        for (Favorito favorito : dados.getFavoritos()) {
            Usuario usuario = buscarUsuario(favorito.getUsuarioId());
            if (usuario != null) {
                usuario.adicionarFavorito(favorito);
            }
        }
    }
}
