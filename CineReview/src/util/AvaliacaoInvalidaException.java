package util;

/**
 * Excecao personalizada para notas fora do intervalo permitido.
 */
public class AvaliacaoInvalidaException extends Exception {
    public AvaliacaoInvalidaException(String mensagem) {
        super(mensagem);
    }
}
