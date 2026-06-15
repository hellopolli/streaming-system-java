package model;

import java.io.Serializable;

/**
 * Classe abstrata base para todos os conteudos audiovisuais do CineReview.
 */
public abstract class Conteudo implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String titulo;
    private String genero;
    private int anoLancamento;
    private String classificacaoIndicativa;
    private String descricao;

    protected Conteudo(int id, String titulo, String genero, int anoLancamento,
                       String classificacaoIndicativa, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
        this.classificacaoIndicativa = classificacaoIndicativa;
        this.descricao = descricao;
    }

    public abstract void exibirDetalhes();

    public abstract double calcularPopularidade();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }

    public void setClassificacaoIndicativa(String classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    protected String detalhesBase() {
        return "ID: " + id + " | Titulo: " + titulo + " | Genero: " + genero
                + " | Ano: " + anoLancamento + " | Classificacao: " + classificacaoIndicativa
                + " | Descricao: " + descricao;
    }

    @Override
    public String toString() {
        return id + " - " + titulo + " (" + anoLancamento + ")";
    }
}
