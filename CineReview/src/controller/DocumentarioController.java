package controller;

import model.Documentario;
import util.Dados;
import util.LogUtil;
import util.ValidacaoUtil;

import java.util.ArrayList;

/**
 * Controller responsavel pelo CRUD e buscas de documentarios.
 */
public class DocumentarioController {
    private final Dados dados;

    public DocumentarioController(Dados dados) {
        this.dados = dados;
    }

    public void cadastrar(Documentario documentario) {
        ValidacaoUtil.validarIdDuplicado(dados.getDocumentarios(), documentario.getId(), Documentario::getId);
        validar(documentario);
        dados.getDocumentarios().add(documentario);
        dados.salvarTudo();
        LogUtil.registrar("CADASTRO", "Documentario cadastrado: " + documentario.getId());
    }

    public boolean alterar(Documentario atualizado) {
        Documentario documentario = buscarPorId(atualizado.getId());
        if (documentario == null) {
            return false;
        }
        validar(atualizado);
        documentario.setTitulo(atualizado.getTitulo());
        documentario.setGenero(atualizado.getGenero());
        documentario.setAnoLancamento(atualizado.getAnoLancamento());
        documentario.setClassificacaoIndicativa(atualizado.getClassificacaoIndicativa());
        documentario.setDescricao(atualizado.getDescricao());
        documentario.setTema(atualizado.getTema());
        documentario.setNarrador(atualizado.getNarrador());
        dados.salvarTudo();
        LogUtil.registrar("ALTERACAO", "Documentario alterado: " + documentario.getId());
        return true;
    }

    public boolean excluir(int id) {
        Documentario documentario = buscarPorId(id);
        if (documentario == null) {
            return false;
        }
        dados.getDocumentarios().remove(documentario);
        dados.salvarTudo();
        LogUtil.registrar("EXCLUSAO", "Documentario excluido: " + id);
        return true;
    }

    public ArrayList<Documentario> listar() {
        return dados.getDocumentarios();
    }

    public Documentario buscarPorId(int id) {
        for (Documentario documentario : dados.getDocumentarios()) {
            if (documentario.getId() == id) {
                return documentario;
            }
        }
        return null;
    }

    public ArrayList<Documentario> buscar(String titulo) {
        ArrayList<Documentario> resultado = new ArrayList<>();
        for (Documentario documentario : dados.getDocumentarios()) {
            if (documentario.getTitulo().equalsIgnoreCase(titulo)) {
                resultado.add(documentario);
            }
        }
        return resultado;
    }

    public ArrayList<Documentario> buscar(String titulo, String genero) {
        ArrayList<Documentario> resultado = new ArrayList<>();
        for (Documentario documentario : dados.getDocumentarios()) {
            if (documentario.getTitulo().equalsIgnoreCase(titulo)
                    && documentario.getGenero().equalsIgnoreCase(genero)) {
                resultado.add(documentario);
            }
        }
        return resultado;
    }

    public ArrayList<Documentario> buscar(int ano) {
        ArrayList<Documentario> resultado = new ArrayList<>();
        for (Documentario documentario : dados.getDocumentarios()) {
            if (documentario.getAnoLancamento() == ano) {
                resultado.add(documentario);
            }
        }
        return resultado;
    }

    private void validar(Documentario documentario) {
        ValidacaoUtil.validarCampoObrigatorio(documentario.getTitulo(), "titulo");
        ValidacaoUtil.validarCampoObrigatorio(documentario.getGenero(), "genero");
        ValidacaoUtil.validarCampoObrigatorio(documentario.getClassificacaoIndicativa(), "classificacao indicativa");
        ValidacaoUtil.validarCampoObrigatorio(documentario.getDescricao(), "descricao");
        ValidacaoUtil.validarCampoObrigatorio(documentario.getTema(), "tema");
        ValidacaoUtil.validarCampoObrigatorio(documentario.getNarrador(), "narrador");
    }
}
