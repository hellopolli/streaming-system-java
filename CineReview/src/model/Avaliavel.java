package model;

import util.AvaliacaoInvalidaException;


public interface Avaliavel {
    void adicionarAvaliacao(Avaliacao avaliacao) throws AvaliacaoInvalidaException;

    double calcularMedia();
}
