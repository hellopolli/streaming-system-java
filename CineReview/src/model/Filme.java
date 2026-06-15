package model;

import util.AvaliacaoInvalidaException;
import util.ValidacaoUtil;

import java.util.ArrayList;

/**
 * Modelo de filme, especializado a partir de Conteudo.
 */
public class Filme extends Conteudo implements Avaliavel {
    private static final long serialVersionUID = 1L;

    private int duracaoMinutos;
    private String diretor;
    private ArrayList<Avaliacao> avaliacoes;

    public Filme(int id, String titulo, String genero, int anoLancamento,
                 String classificacaoIndicativa, String descricao,
                 int duracaoMinutos, String diretor) {
        super(id, titulo, genero, anoLancamento, classificacaoIndicativa, descricao);
        this.duracaoMinutos = duracaoMinutos;
        this.diretor = diretor;
        this.avaliacoes = new ArrayList<>();
    }

    @Override
    public void exibirDetalhes() {
        System.out.println(detalhesBase() + " | Duracao: " + duracaoMinutos
                + " min | Diretor: " + diretor + " | Media: " + String.format("%.2f", calcularMedia()));
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

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }
}
