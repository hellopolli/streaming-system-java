package view;

import controller.AvaliacaoController;
import model.Avaliacao;

import java.util.Scanner;

public class AvaliacaoView {

    private AvaliacaoController controller;
    private Scanner scanner;

    public AvaliacaoView(
            AvaliacaoController controller) {

        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void menu() {

        int opcao;

        do {

            System.out.println("\n=== AVALIAÇÕES ===");
            System.out.println("1 - Avaliar");
            System.out.println("2 - Listar");
            System.out.println("3 - Média");
            System.out.println("0 - Voltar");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("ID: ");
                    int id = scanner.nextInt();

                    System.out.print("Nota: ");
                    int nota = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Comentário: ");
                    String comentario =
                            scanner.nextLine();

                    controller.adicionar(
                            new Avaliacao(
                                    id,
                                    nota,
                                    comentario
                            )
                    );

                    break;

                case 2:

                    for (Avaliacao avaliacao :
                            controller.listar()) {

                        System.out.println(
                                avaliacao
                        );
                    }

                    break;

                case 3:

                    System.out.println(
                            "Média: "
                                    + controller.calcularMedia()
                    );

                    break;
            }

        } while (opcao != 0);
    }
}