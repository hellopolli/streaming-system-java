package view;

import controller.DocumentarioController;
import model.Documentario;

import java.util.Scanner;

public class DocumentarioView {

    private DocumentarioController controller;
    private Scanner scanner;

    public DocumentarioView(
            DocumentarioController controller) {

        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void menu() {

        int opcao;

        do {

            System.out.println("\n=== DOCUMENTÁRIOS ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Remover");
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

                    System.out.print("Tema: ");
                    String tema = scanner.nextLine();

                    controller.cadastrar(
                            new Documentario(
                                    id,
                                    titulo,
                                    genero,
                                    tema
                            )
                    );

                    break;

                case 2:

                    for (Documentario doc :
                            controller.listar()) {

                        System.out.println(doc);
                    }

                    break;

                case 3:

                    System.out.print("ID: ");
                    int remover = scanner.nextInt();

                    controller.remover(remover);

                    break;
            }

        } while (opcao != 0);
    }
}