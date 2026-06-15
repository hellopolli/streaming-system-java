package model;

import util.AvaliacaoInvalidaException;
import util.ValidacaoUtil;

import java.util.ArrayList;

/**
 * Modelo de serie com composicao de episodios.
 */
public class Serie extends Conteudo implements Avaliavel {
    private static final long serialVersionUID = 1L;

    private int temporadas;
    private int episodios;
    private ArrayList<Episodio> listaEpisodios;
    private ArrayList<Avaliacao> avaliacoes;

    public Serie(int id, String titulo, String genero, int anoLancamento,
                 String classificacaoIndicativa, String descricao,
                 int temporadas, int episodios) {
        super(id, titulo, genero, anoLancamento, classificacaoIndicativa, descricao);
        this.temporadas = temporadas;
        this.episodios = episodios;
        this.listaEpisodios = new ArrayList<>();
        this.avaliacoes = new ArrayList<>();
        for (int i = 1; i <= episodios; i++) {
            listaEpisodios.add(new Episodio(i, "Episodio " + i, 45));
        }
    }

    @Override
    public void exibirDetalhes() {
        System.out.println(detalhesBase() + " | Temporadas: " + temporadas
                + " | Episodios: " + episodios + " | Media: " + String.format("%.2f", calcularMedia()));
    }

    @Override
    public double calcularPopularidade() {
        return calcularMedia() * avaliacoes.size() + temporadas;
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

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    public ArrayList<Episodio> getListaEpisodios() {
        return listaEpisodios;
    }

    public ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }
}
