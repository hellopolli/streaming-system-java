package controller;

import model.Usuario;
import util.Dados;
import util.LogUtil;
import util.ValidacaoUtil;

import java.util.ArrayList;

/**
 * Controller responsavel pelo CRUD de usuarios.
 */
public class UsuarioController {
    private final Dados dados;

    public UsuarioController(Dados dados) {
        this.dados = dados;
    }

    public void cadastrar(int id, String nome, String email) {
        ValidacaoUtil.validarIdDuplicado(dados.getUsuarios(), id, Usuario::getId);
        ValidacaoUtil.validarCampoObrigatorio(nome, "nome");
        ValidacaoUtil.validarCampoObrigatorio(email, "email");
        dados.getUsuarios().add(new Usuario(id, nome, email));
        dados.salvarTudo();
        LogUtil.registrar("CADASTRO", "Usuario cadastrado: " + id);
    }

    public boolean alterar(int id, String nome, String email) {
        Usuario usuario = buscarPorId(id);
        if (usuario == null) {
            return false;
        }
        ValidacaoUtil.validarCampoObrigatorio(nome, "nome");
        ValidacaoUtil.validarCampoObrigatorio(email, "email");
        usuario.setNome(nome);
        usuario.setEmail(email);
        dados.salvarTudo();
        LogUtil.registrar("ALTERACAO", "Usuario alterado: " + id);
        return true;
    }

    public boolean excluir(int id) {
        Usuario usuario = buscarPorId(id);
        if (usuario == null) {
            return false;
        }
        dados.getUsuarios().remove(usuario);
        dados.salvarTudo();
        LogUtil.registrar("EXCLUSAO", "Usuario excluido: " + id);
        return true;
    }

    public ArrayList<Usuario> listar() {
        return dados.getUsuarios();
    }

    public Usuario buscarPorId(int id) {
        for (Usuario usuario : dados.getUsuarios()) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }
}
