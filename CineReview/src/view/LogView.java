package view;

import controller.LogController;
import model.LogRegistro;
import util.ConsoleUtil;

/**
 * View de console para logs do sistema.
 */
public class LogView {
    private final LogController controller;

    public LogView(LogController controller) {
        this.controller = controller;
    }

    public void menu() {
        int opcao;
        do {
            System.out.println("\n--- Logs do Sistema ---");
            System.out.println("1 - Cadastrar log manual");
            System.out.println("2 - Alterar log");
            System.out.println("3 - Excluir log");
            System.out.println("4 - Listar");
            System.out.println("0 - Voltar");
            opcao = ConsoleUtil.lerInt("Opcao: ");
            switch (opcao) {
                case 1:
                    controller.cadastrar(ConsoleUtil.lerTexto("Acao: "), ConsoleUtil.lerTexto("Mensagem: "));
                    break;
                case 2:
                    System.out.println(controller.alterar(ConsoleUtil.lerInt("Linha: "),
                            ConsoleUtil.lerTexto("Mensagem: ")) ? "Log alterado." : "Logs nao sao alteraveis.");
                    break;
                case 3:
                    System.out.println(controller.excluir(ConsoleUtil.lerInt("Linha: ")) ? "Log excluido." : "Logs sao preservados.");
                    break;
                case 4:
                    for (LogRegistro log : controller.listar()) {
                        System.out.println(log);
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);
    }
}
