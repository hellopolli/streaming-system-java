package view;

import controller.AvaliacaoController;
import model.Avaliacao;
import util.ConsoleUtil;


public class AvaliacaoView {
    private final AvaliacaoController controller;

    public AvaliacaoView(AvaliacaoController controller) {
        this.controller = controller;
    }

    public void menu() {
        int opcao;
        do {
            System.out.println("\n--- Avaliacoes ---");
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
                                ConsoleUtil.lerTexto("Tipo do conteudo (filme/serie/documentario): "),
                                ConsoleUtil.lerDouble("Nota (0 a 5): "));
                        break;
                    case 2:
                        System.out.println(controller.alterar(ConsoleUtil.lerInt("ID: "),
                                ConsoleUtil.lerDouble("Nova nota: ")) ? "Avaliacao alterada." : "Avaliacao nao encontrada.");
                        break;
                    case 3:
                        System.out.println(controller.excluir(ConsoleUtil.lerInt("ID: ")) ? "Avaliacao excluida." : "Avaliacao nao encontrada.");
                        break;
                    case 4:
                        for (Avaliacao avaliacao : controller.listar()) {
                            System.out.println(avaliacao);
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
