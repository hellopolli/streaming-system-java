package view;

import controller.ComentarioController;
import model.Comentario;
import util.ConsoleUtil;


public class ComentarioView {
    private final ComentarioController controller;

    public ComentarioView(ComentarioController controller) {
        this.controller = controller;
    }

    public void menu() {
        int opcao;
        do {
            System.out.println("\n--- Comentarios ---");
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
                                ConsoleUtil.lerInt("ID do usuario: "),
                                ConsoleUtil.lerInt("ID do conteudo: "),
                                ConsoleUtil.lerTexto("Tipo do conteudo: "),
                                ConsoleUtil.lerTexto("Comentario: "));
                        break;
                    case 2:
                        System.out.println(controller.alterar(ConsoleUtil.lerInt("ID: "),
                                ConsoleUtil.lerTexto("Novo texto: ")) ? "Comentario alterado." : "Comentario nao encontrado.");
                        break;
                    case 3:
                        System.out.println(controller.excluir(ConsoleUtil.lerInt("ID: ")) ? "Comentario excluido." : "Comentario nao encontrado.");
                        break;
                    case 4:
                        for (Comentario comentario : controller.listar()) {
                            System.out.println(comentario);
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
