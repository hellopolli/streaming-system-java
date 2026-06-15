package controller;

import model.Categoria;
import util.Dados;
import util.LogUtil;
import util.ValidacaoUtil;

import java.util.ArrayList;

/**
 * Controller responsavel pelo CRUD de categorias.
 */
public class CategoriaController {
    private final Dados dados;

    public CategoriaController(Dados dados) {
        this.dados = dados;
    }

    public void cadastrar(int id, String nome, String descricao) {
        ValidacaoUtil.validarIdDuplicado(dados.getCategorias(), id, Categoria::getId);
        ValidacaoUtil.validarCampoObrigatorio(nome, "nome");
        ValidacaoUtil.validarCampoObrigatorio(descricao, "descricao");
        dados.getCategorias().add(new Categoria(id, nome, descricao));
        dados.salvarTudo();
        LogUtil.registrar("CADASTRO", "Categoria cadastrada: " + id);
    }

    public boolean alterar(int id, String nome, String descricao) {
        Categoria categoria = buscarPorId(id);
        if (categoria == null) {
            return false;
        }
        ValidacaoUtil.validarCampoObrigatorio(nome, "nome");
        ValidacaoUtil.validarCampoObrigatorio(descricao, "descricao");
        categoria.setNome(nome);
        categoria.setDescricao(descricao);
        dados.salvarTudo();
        LogUtil.registrar("ALTERACAO", "Categoria alterada: " + id);
        return true;
    }

    public boolean excluir(int id) {
        Categoria categoria = buscarPorId(id);
        if (categoria == null) {
            return false;
        }
        dados.getCategorias().remove(categoria);
        dados.salvarTudo();
        LogUtil.registrar("EXCLUSAO", "Categoria excluida: " + id);
        return true;
    }

    public ArrayList<Categoria> listar() {
        return dados.getCategorias();
    }

    public Categoria buscarPorId(int id) {
        for (Categoria categoria : dados.getCategorias()) {
            if (categoria.getId() == id) {
                return categoria;
            }
        }
        return null;
    }
}
