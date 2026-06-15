package util;

import java.util.List;
import java.util.function.ToIntFunction;

/**
 * Centraliza validacoes de campos, IDs e notas.
 */
public final class ValidacaoUtil {
    private ValidacaoUtil() {
    }

    public static void validarCampoObrigatorio(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("O campo " + campo + " nao pode ser vazio.");
        }
    }

    public static void validarNota(double nota) throws AvaliacaoInvalidaException {
        if (nota < 0 || nota > 5) {
            throw new AvaliacaoInvalidaException("A nota deve estar entre 0 e 5.");
        }
    }

    public static <T> void validarIdDuplicado(List<T> lista, int id, ToIntFunction<T> leitorId) {
        for (T item : lista) {
            if (leitorId.applyAsInt(item) == id) {
                throw new IllegalArgumentException("ID duplicado: " + id);
            }
        }
    }
}
