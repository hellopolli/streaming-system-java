package util;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Metodos auxiliares para entrada segura de dados no console.
 */
public final class ConsoleUtil {
    private static final Scanner SCANNER = new Scanner(System.in);

    private ConsoleUtil() {
    }

    public static int lerInt(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                int valor = SCANNER.nextInt();
                SCANNER.nextLine();
                return valor;
            } catch (InputMismatchException e) {
                SCANNER.nextLine();
                LogUtil.registrarErro("Entrada inteira invalida", e);
                System.out.println("Digite um numero inteiro valido.");
            }
        }
    }

    public static double lerDouble(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                double valor = SCANNER.nextDouble();
                SCANNER.nextLine();
                return valor;
            } catch (InputMismatchException e) {
                SCANNER.nextLine();
                LogUtil.registrarErro("Entrada decimal invalida", e);
                System.out.println("Digite um numero valido.");
            }
        }
    }

    public static String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return SCANNER.nextLine();
    }
}
