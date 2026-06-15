package view;

import controller.RecomendacaoController;
import model.Conteudo;
import util.ConsoleUtil;

/**
 * View de console para recomendacoes.
 */
public class RecomendacaoView {
    private final RecomendacaoController controller;

    public RecomendacaoView(RecomendacaoController controller) {
        this.controller = controller;
    }

    public void menu() {
        int opcao;
        do {
            System.out.println("\n--- Recomendacoes ---");
            System.out.println("1 - Gerar recomendacao por usuario");
            System.out.println("2 - Listar conteudos mais avaliados");
            System.out.println("0 - Voltar");
            opcao = ConsoleUtil.lerInt("Opcao: ");
            switch (opcao) {
                case 1:
                    System.out.println(controller.gerarParaUsuario(ConsoleUtil.lerInt("ID do usuario: ")));
                    break;
                case 2:
                    for (Conteudo conteudo : controller.listarConteudosMaisAvaliados()) {
                        conteudo.exibirDetalhes();
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
