package view;

import controller.HistoricoController;
import model.Historico;
import util.ConsoleUtil;

/**
 * View de console para historico assistido.
 */
public class HistoricoView {
    private final HistoricoController controller;

    public HistoricoView(HistoricoController controller) {
        this.controller = controller;
    }

    public void menu() {
        int opcao;
        do {
            System.out.println("\n--- Historico Assistido ---");
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
                                ConsoleUtil.lerTexto("Tipo do conteudo: "));
                        break;
                    case 2:
                        System.out.println(controller.alterar(ConsoleUtil.lerInt("ID: "),
                                ConsoleUtil.lerInt("Novo ID do usuario: "),
                                ConsoleUtil.lerInt("Novo ID do conteudo: "),
                                ConsoleUtil.lerTexto("Novo tipo: ")) ? "Historico alterado." : "Historico nao encontrado.");
                        break;
                    case 3:
                        System.out.println(controller.excluir(ConsoleUtil.lerInt("ID: ")) ? "Historico excluido." : "Historico nao encontrado.");
                        break;
                    case 4:
                        for (Historico historico : controller.listar()) {
                            System.out.println(historico);
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
