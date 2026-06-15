package util;

import model.Avaliacao;
import model.Categoria;
import model.Comentario;
import model.Documentario;
import model.Favorito;
import model.Filme;
import model.Historico;
import model.Serie;
import model.Usuario;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Mantem as colecoes em memoria e coordena a persistencia dos arquivos.
 */
public class Dados {
    private static final String PASTA = "data/";

    private ArrayList<Usuario> usuarios;
    private ArrayList<Filme> filmes;
    private ArrayList<Serie> series;
    private ArrayList<Documentario> documentarios;
    private ArrayList<Avaliacao> avaliacoes;
    private ArrayList<Comentario> comentarios;
    private ArrayList<Favorito> favoritos;
    private ArrayList<Historico> historicos;
    private ArrayList<Categoria> categorias;

    public Dados() {
        carregar();
    }

    public final void carregar() {
        usuarios = ArquivoUtil.carregarOuCriar(PASTA + "usuarios.dat");
        filmes = ArquivoUtil.carregarOuCriar(PASTA + "filmes.dat");
        series = ArquivoUtil.carregarOuCriar(PASTA + "series.dat");
        documentarios = ArquivoUtil.carregarOuCriar(PASTA + "documentarios.dat");
        avaliacoes = ArquivoUtil.carregarOuCriar(PASTA + "avaliacoes.dat");
        comentarios = ArquivoUtil.carregarOuCriar(PASTA + "comentarios.dat");
        favoritos = ArquivoUtil.carregarOuCriar(PASTA + "favoritos.dat");
        historicos = ArquivoUtil.carregarOuCriar(PASTA + "historico.dat");
        categorias = ArquivoUtil.carregarOuCriar(PASTA + "categorias.dat");
    }

    public void salvarTudo() {
        try {
            ArquivoUtil.salvar(PASTA + "usuarios.dat", usuarios);
            ArquivoUtil.salvar(PASTA + "filmes.dat", filmes);
            ArquivoUtil.salvar(PASTA + "series.dat", series);
            ArquivoUtil.salvar(PASTA + "documentarios.dat", documentarios);
            ArquivoUtil.salvar(PASTA + "avaliacoes.dat", avaliacoes);
            ArquivoUtil.salvar(PASTA + "comentarios.dat", comentarios);
            ArquivoUtil.salvar(PASTA + "favoritos.dat", favoritos);
            ArquivoUtil.salvar(PASTA + "historico.dat", historicos);
            ArquivoUtil.salvar(PASTA + "categorias.dat", categorias);
        } catch (IOException e) {
            LogUtil.registrarErro("Falha ao salvar dados", e);
        }
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Filme> getFilmes() {
        return filmes;
    }

    public ArrayList<Serie> getSeries() {
        return series;
    }

    public ArrayList<Documentario> getDocumentarios() {
        return documentarios;
    }

    public ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }

    public ArrayList<Favorito> getFavoritos() {
        return favoritos;
    }

    public ArrayList<Historico> getHistoricos() {
        return historicos;
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }
}
