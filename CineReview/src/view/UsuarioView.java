package view;

import controller.UsuarioController;
import model.Usuario;
import util.ConsoleUtil;

/**
 * View de console para usuarios.
 */
public class UsuarioView {
    private final UsuarioController controller;

    public UsuarioView(UsuarioController controller) {
        this.controller = controller;
    }

    public void menu() {
        int opcao;
        do {
            System.out.println("\n--- Usuarios ---");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Listar");
            System.out.println("0 - Voltar");
            opcao = ConsoleUtil.lerInt("Opcao: ");
            try {
                switch (opcao) {
                    case 1:
                        controller.cadastrar(ConsoleUtil.lerInt("ID: "),
                                ConsoleUtil.lerTexto("Nome: "),
                                ConsoleUtil.lerTexto("Email: "));
                        break;
                    case 2:
                        boolean alterado = controller.alterar(ConsoleUtil.lerInt("ID: "),
                                ConsoleUtil.lerTexto("Novo nome: "),
                                ConsoleUtil.lerTexto("Novo email: "));
                        System.out.println(alterado ? "Usuario alterado." : "Usuario nao encontrado.");
                        break;
                    case 3:
                        boolean excluido = controller.excluir(ConsoleUtil.lerInt("ID: "));
                        System.out.println(excluido ? "Usuario excluido." : "Usuario nao encontrado.");
                        break;
                    case 4:
                        for (Usuario usuario : controller.listar()) {
                            System.out.println(usuario);
                        }
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opcao invalida.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (opcao != 0);
    }
}
