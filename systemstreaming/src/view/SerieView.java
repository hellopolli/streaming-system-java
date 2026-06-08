package view;

import controller.SerieController;
import model.Serie;

import java.util.Scanner;

public class SerieView {

    private SerieController controller;
    private Scanner scanner;

    public SerieView(SerieController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void menu() {

        int opcao;

        do {

            System.out.println("\n=== SÉRIES ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Remover");
            System.out.println("0 - Voltar");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Gênero: ");
                    String genero = scanner.nextLine();

                    System.out.print("Temporadas: ");
                    int temporadas = scanner.nextInt();

                    controller.cadastrar(
                            new Serie(id, titulo, genero, temporadas)
                    );

                    break;

                case 2:

                    for (Serie serie : controller.listar()) {
                        System.out.println(serie);
                    }

                    break;

                case 3:

                    System.out.print("ID: ");
                    int atualizar = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Novo título: ");
                    String novoTitulo = scanner.nextLine();

                    System.out.print("Temporadas: ");
                    int novasTemp = scanner.nextInt();

                    controller.atualizar(
                            atualizar,
                            novoTitulo,
                            novasTemp
                    );

                    break;

                case 4:

                    System.out.print("ID: ");
                    int remover = scanner.nextInt();

                    controller.remover(remover);

                    break;
            }

        } while (opcao != 0);
    }
}