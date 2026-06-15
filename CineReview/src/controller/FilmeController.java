package controller;

import model.Filme;
import util.Dados;
import util.LogUtil;
import util.ValidacaoUtil;

import java.util.ArrayList;

/**
 * Controller responsavel pelo CRUD e buscas de filmes.
 */
public class FilmeController {
    private final Dados dados;

    public FilmeController(Dados dados) {
        this.dados = dados;
    }

    public void cadastrar(Filme filme) {
        ValidacaoUtil.validarIdDuplicado(dados.getFilmes(), filme.getId(), Filme::getId);
        validar(filme);
        dados.getFilmes().add(filme);
        dados.salvarTudo();
        LogUtil.registrar("CADASTRO", "Filme cadastrado: " + filme.getId());
    }

    public boolean alterar(Filme atualizado) {
        Filme filme = buscarPorId(atualizado.getId());
        if (filme == null) {
            return false;
        }
        validar(atualizado);
        filme.setTitulo(atualizado.getTitulo());
        filme.setGenero(atualizado.getGenero());
        filme.setAnoLancamento(atualizado.getAnoLancamento());
        filme.setClassificacaoIndicativa(atualizado.getClassificacaoIndicativa());
        filme.setDescricao(atualizado.getDescricao());
        filme.setDuracaoMinutos(atualizado.getDuracaoMinutos());
        filme.setDiretor(atualizado.getDiretor());
        dados.salvarTudo();
        LogUtil.registrar("ALTERACAO", "Filme alterado: " + filme.getId());
        return true;
    }

    public boolean excluir(int id) {
        Filme filme = buscarPorId(id);
        if (filme == null) {
            return false;
        }
        dados.getFilmes().remove(filme);
        dados.salvarTudo();
        LogUtil.registrar("EXCLUSAO", "Filme excluido: " + id);
        return true;
    }

    public ArrayList<Filme> listar() {
        return dados.getFilmes();
    }

    public Filme buscarPorId(int id) {
        for (Filme filme : dados.getFilmes()) {
            if (filme.getId() == id) {
                return filme;
            }
        }
        return null;
    }

    public ArrayList<Filme> buscar(String titulo) {
        ArrayList<Filme> resultado = new ArrayList<>();
        for (Filme filme : dados.getFilmes()) {
            if (filme.getTitulo().equalsIgnoreCase(titulo)) {
                resultado.add(filme);
            }
        }
        return resultado;
    }

    public ArrayList<Filme> buscar(String titulo, String genero) {
        ArrayList<Filme> resultado = new ArrayList<>();
        for (Filme filme : dados.getFilmes()) {
            if (filme.getTitulo().equalsIgnoreCase(titulo)
                    && filme.getGenero().equalsIgnoreCase(genero)) {
                resultado.add(filme);
            }
        }
        return resultado;
    }

    public ArrayList<Filme> buscar(int ano) {
        ArrayList<Filme> resultado = new ArrayList<>();
        for (Filme filme : dados.getFilmes()) {
            if (filme.getAnoLancamento() == ano) {
                resultado.add(filme);
            }
        }
        return resultado;
    }

    private void validar(Filme filme) {
        ValidacaoUtil.validarCampoObrigatorio(filme.getTitulo(), "titulo");
        ValidacaoUtil.validarCampoObrigatorio(filme.getGenero(), "genero");
        ValidacaoUtil.validarCampoObrigatorio(filme.getClassificacaoIndicativa(), "classificacao indicativa");
        ValidacaoUtil.validarCampoObrigatorio(filme.getDescricao(), "descricao");
        ValidacaoUtil.validarCampoObrigatorio(filme.getDiretor(), "diretor");
    }
}
