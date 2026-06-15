package view;

import controller.FavoritoController;
import model.Favorito;
import util.ConsoleUtil;

/**
 * View de console para favoritos.
 */
public class FavoritoView {
    private final FavoritoController controller;

    public FavoritoView(FavoritoController controller) {
        this.controller = controller;
    }

    public void menu() {
        int opcao;
        do {
            System.out.println("\n--- Favoritos ---");
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
                                ConsoleUtil.lerTexto("Novo tipo: ")) ? "Favorito alterado." : "Favorito nao encontrado.");
                        break;
                    case 3:
                        System.out.println(controller.excluir(ConsoleUtil.lerInt("ID: ")) ? "Favorito excluido." : "Favorito nao encontrado.");
                        break;
                    case 4:
                        for (Favorito favorito : controller.listar()) {
                            System.out.println(favorito);
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
