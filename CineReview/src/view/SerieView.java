package view;

import controller.SerieController;
import model.Serie;
import util.ConsoleUtil;

/**
 * View de console para series.
 */
public class SerieView {
    private final SerieController controller;

    public SerieView(SerieController controller) {
        this.controller = controller;
    }

    public void menu() {
        int opcao;
        do {
            System.out.println("\n--- Series ---");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Listar");
            System.out.println("5 - Buscar por titulo");
            System.out.println("6 - Buscar por titulo e genero");
            System.out.println("7 - Buscar por ano");
            System.out.println("0 - Voltar");
            opcao = ConsoleUtil.lerInt("Opcao: ");
            try {
                switch (opcao) {
                    case 1:
                        controller.cadastrar(lerSerie());
                        break;
                    case 2:
                        System.out.println(controller.alterar(lerSerie()) ? "Serie alterada." : "Serie nao encontrada.");
                        break;
                    case 3:
                        System.out.println(controller.excluir(ConsoleUtil.lerInt("ID: ")) ? "Serie excluida." : "Serie nao encontrada.");
                        break;
                    case 4:
                        listar(controller.listar());
                        break;
                    case 5:
                        listar(controller.buscar(ConsoleUtil.lerTexto("Titulo: ")));
                        break;
                    case 6:
                        listar(controller.buscar(ConsoleUtil.lerTexto("Titulo: "), ConsoleUtil.lerTexto("Genero: ")));
                        break;
                    case 7:
                        listar(controller.buscar(ConsoleUtil.lerInt("Ano: ")));
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

    private Serie lerSerie() {
        return new Serie(ConsoleUtil.lerInt("ID: "),
                ConsoleUtil.lerTexto("Titulo: "),
                ConsoleUtil.lerTexto("Genero: "),
                ConsoleUtil.lerInt("Ano de lancamento: "),
                ConsoleUtil.lerTexto("Classificacao indicativa: "),
                ConsoleUtil.lerTexto("Descricao: "),
                ConsoleUtil.lerInt("Temporadas: "),
                ConsoleUtil.lerInt("Episodios: "));
    }

    private void listar(java.util.ArrayList<Serie> series) {
        for (Serie serie : series) {
            serie.exibirDetalhes();
        }
    }
}
