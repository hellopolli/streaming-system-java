package view;

import controller.FilmeController;
import model.Filme;
import util.ConsoleUtil;

/**
 * View de console para filmes.
 */
public class FilmeView {
    private final FilmeController controller;

    public FilmeView(FilmeController controller) {
        this.controller = controller;
    }

    public void menu() {
        int opcao;
        do {
            System.out.println("\n--- Filmes ---");
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
                        controller.cadastrar(lerFilme());
                        break;
                    case 2:
                        System.out.println(controller.alterar(lerFilme()) ? "Filme alterado." : "Filme nao encontrado.");
                        break;
                    case 3:
                        System.out.println(controller.excluir(ConsoleUtil.lerInt("ID: ")) ? "Filme excluido." : "Filme nao encontrado.");
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

    private Filme lerFilme() {
        return new Filme(ConsoleUtil.lerInt("ID: "),
                ConsoleUtil.lerTexto("Titulo: "),
                ConsoleUtil.lerTexto("Genero: "),
                ConsoleUtil.lerInt("Ano de lancamento: "),
                ConsoleUtil.lerTexto("Classificacao indicativa: "),
                ConsoleUtil.lerTexto("Descricao: "),
                ConsoleUtil.lerInt("Duracao em minutos: "),
                ConsoleUtil.lerTexto("Diretor: "));
    }

    private void listar(java.util.ArrayList<Filme> filmes) {
        for (Filme filme : filmes) {
            filme.exibirDetalhes();
        }
    }
}
