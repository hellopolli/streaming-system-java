package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Utilitario para registro e leitura de atividades do sistema.
 */
public final class LogUtil {
    public static final String CAMINHO_LOG = "data/log.txt";

    private LogUtil() {
    }

    public static void registrar(String acao, String mensagem) {
        escrever(LocalDateTime.now() + " | " + acao + " | " + mensagem);
    }

    public static void registrarErro(String mensagem, Exception excecao) {
        escrever(LocalDateTime.now() + " | ERRO | " + mensagem + " | " + excecao.getMessage());
    }

    private static void escrever(String linha) {
        try {
            java.io.File arquivo = new java.io.File(CAMINHO_LOG);
            java.io.File pasta = arquivo.getParentFile();
            if (pasta != null && !pasta.exists()) {
                pasta.mkdirs();
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Nao foi possivel registrar log: " + e.getMessage());
        }
    }

    public static ArrayList<String> lerLogs() {
        ArrayList<String> linhas = new ArrayList<>();
        java.io.File arquivo = new java.io.File(CAMINHO_LOG);
        if (!arquivo.exists()) {
            return linhas;
        }
        try (java.util.Scanner scanner = new java.util.Scanner(arquivo)) {
            while (scanner.hasNextLine()) {
                linhas.add(scanner.nextLine());
            }
        } catch (IOException e) {
            registrarErro("Falha ao ler logs", e);
        }
        return linhas;
    }
}
