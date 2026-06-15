package model;

import util.AvaliacaoInvalidaException;
import util.ValidacaoUtil;

import java.util.ArrayList;

/**
 * Modelo de documentario, especializado a partir de Conteudo.
 */
public class Documentario extends Conteudo implements Avaliavel {
    private static final long serialVersionUID = 1L;

    private String tema;
    private String narrador;
    private ArrayList<Avaliacao> avaliacoes;

    public Documentario(int id, String titulo, String genero, int anoLancamento,
                        String classificacaoIndicativa, String descricao,
                        String tema, String narrador) {
        super(id, titulo, genero, anoLancamento, classificacaoIndicativa, descricao);
        this.tema = tema;
        this.narrador = narrador;
        this.avaliacoes = new ArrayList<>();
    }

    @Override
    public void exibirDetalhes() {
        System.out.println(detalhesBase() + " | Tema: " + tema
                + " | Narrador: " + narrador + " | Media: " + String.format("%.2f", calcularMedia()));
    }

    @Override
    public double calcularPopularidade() {
        return calcularMedia() * avaliacoes.size();
    }

    @Override
    public void adicionarAvaliacao(Avaliacao avaliacao) throws AvaliacaoInvalidaException {
        ValidacaoUtil.validarNota(avaliacao.getNota());
        avaliacoes.add(avaliacao);
    }

    @Override
    public double calcularMedia() {
        if (avaliacoes.isEmpty()) {
            return 0;
        }
        double soma = 0;
        for (Avaliacao avaliacao : avaliacoes) {
            soma += avaliacao.getNota();
        }
        return soma / avaliacoes.size();
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getNarrador() {
        return narrador;
    }

    public void setNarrador(String narrador) {
        this.narrador = narrador;
    }

    public ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }
}
