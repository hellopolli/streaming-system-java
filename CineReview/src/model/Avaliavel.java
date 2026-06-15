package model;

import util.AvaliacaoInvalidaException;

/**
 * Define o contrato para conteudos que podem receber avaliacoes.
 */
public interface Avaliavel {
    void adicionarAvaliacao(Avaliacao avaliacao) throws AvaliacaoInvalidaException;

    double calcularMedia();
}
