package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Utilitario generico de persistencia por serializacao.
 */
public final class ArquivoUtil {
    private ArquivoUtil() {
    }

    public static <T> void salvar(String caminho, ArrayList<T> dados) throws IOException {
        File arquivo = new File(caminho);
        File pasta = arquivo.getParentFile();
        if (pasta != null && !pasta.exists()) {
            pasta.mkdirs();
        }
        try (ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            saida.writeObject(dados);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> ArrayList<T> carregar(String caminho) throws IOException, ClassNotFoundException {
        File arquivo = new File(caminho);
        if (!arquivo.exists()) {
            throw new FileNotFoundException("Arquivo nao encontrado: " + caminho);
        }
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (ArrayList<T>) entrada.readObject();
        }
    }

    public static <T> ArrayList<T> carregarOuCriar(String caminho) {
        try {
            return carregar(caminho);
        } catch (FileNotFoundException e) {
            LogUtil.registrar("ARQUIVO", "Criado novo armazenamento para " + caminho);
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            LogUtil.registrarErro("Falha ao carregar " + caminho, e);
            return new ArrayList<>();
        }
    }
}
