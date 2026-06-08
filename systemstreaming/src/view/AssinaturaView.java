package view;

import controller.AssinaturaController;
import model.Assinatura;

import java.util.Scanner;

public class AssinaturaView {

    private AssinaturaController controller;
    private Scanner scanner;

    public AssinaturaView(
            AssinaturaController controller) {

        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void menu() {

        int opcao;

        do {

            System.out.println("\n=== ASSINATURAS ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Cancelar");
            System.out.println("0 - Voltar");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Plano: ");
                    String plano = scanner.nextLine();

                    controller.cadastrar(
                            new Assinatura(
                                    id,
                                    plano
                            )
                    );

                    break;

                case 2:

                    for (Assinatura assinatura :
                            controller.listar()) {

                        System.out.println(
                                assinatura
                        );
                    }

                    break;

                case 3:

                    System.out.print("ID: ");
                    int cancelar =
                            scanner.nextInt();

                    controller.cancelar(
                            cancelar
                    );

                    break;
            }

        } while (opcao != 0);
    }
}