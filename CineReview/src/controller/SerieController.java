package controller;

import model.Serie;
import util.Dados;
import util.LogUtil;
import util.ValidacaoUtil;

import java.util.ArrayList;

/**
 * Controller responsavel pelo CRUD e buscas de series.
 */
public class SerieController {
    private final Dados dados;

    public SerieController(Dados dados) {
        this.dados = dados;
    }

    public void cadastrar(Serie serie) {
        ValidacaoUtil.validarIdDuplicado(dados.getSeries(), serie.getId(), Serie::getId);
        validar(serie);
        dados.getSeries().add(serie);
        dados.salvarTudo();
        LogUtil.registrar("CADASTRO", "Serie cadastrada: " + serie.getId());
    }

    public boolean alterar(Serie atualizada) {
        Serie serie = buscarPorId(atualizada.getId());
        if (serie == null) {
            return false;
        }
        validar(atualizada);
        serie.setTitulo(atualizada.getTitulo());
        serie.setGenero(atualizada.getGenero());
        serie.setAnoLancamento(atualizada.getAnoLancamento());
        serie.setClassificacaoIndicativa(atualizada.getClassificacaoIndicativa());
        serie.setDescricao(atualizada.getDescricao());
        serie.setTemporadas(atualizada.getTemporadas());
        serie.setEpisodios(atualizada.getEpisodios());
        dados.salvarTudo();
        LogUtil.registrar("ALTERACAO", "Serie alterada: " + serie.getId());
        return true;
    }

    public boolean excluir(int id) {
        Serie serie = buscarPorId(id);
        if (serie == null) {
            return false;
        }
        dados.getSeries().remove(serie);
        dados.salvarTudo();
        LogUtil.registrar("EXCLUSAO", "Serie excluida: " + id);
        return true;
    }

    public ArrayList<Serie> listar() {
        return dados.getSeries();
    }

    public Serie buscarPorId(int id) {
        for (Serie serie : dados.getSeries()) {
            if (serie.getId() == id) {
                return serie;
            }
        }
        return null;
    }

    public ArrayList<Serie> buscar(String titulo) {
        ArrayList<Serie> resultado = new ArrayList<>();
        for (Serie serie : dados.getSeries()) {
            if (serie.getTitulo().equalsIgnoreCase(titulo)) {
                resultado.add(serie);
            }
        }
        return resultado;
    }

    public ArrayList<Serie> buscar(String titulo, String genero) {
        ArrayList<Serie> resultado = new ArrayList<>();
        for (Serie serie : dados.getSeries()) {
            if (serie.getTitulo().equalsIgnoreCase(titulo)
                    && serie.getGenero().equalsIgnoreCase(genero)) {
                resultado.add(serie);
            }
        }
        return resultado;
    }

    public ArrayList<Serie> buscar(int ano) {
        ArrayList<Serie> resultado = new ArrayList<>();
        for (Serie serie : dados.getSeries()) {
            if (serie.getAnoLancamento() == ano) {
                resultado.add(serie);
            }
        }
        return resultado;
    }

    private void validar(Serie serie) {
        ValidacaoUtil.validarCampoObrigatorio(serie.getTitulo(), "titulo");
        ValidacaoUtil.validarCampoObrigatorio(serie.getGenero(), "genero");
        ValidacaoUtil.validarCampoObrigatorio(serie.getClassificacaoIndicativa(), "classificacao indicativa");
        ValidacaoUtil.validarCampoObrigatorio(serie.getDescricao(), "descricao");
    }
}
