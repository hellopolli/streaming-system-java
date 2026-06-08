package view;

import controller.PerfilController;
import model.Perfil;

import java.util.Scanner;

public class PerfilView {

    private PerfilController controller;
    private Scanner scanner;

    public PerfilView(
            PerfilController controller) {

        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void menu(){

        int opcao;

        do{

            System.out.println("\n=== PERFIL ===");
            System.out.println("1-Cadastrar");
            System.out.println("2-Listar");
            System.out.println("3-Remover");
            System.out.println("0-Voltar");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao){

                case 1:

                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nome Perfil: ");
                    String nome =
                            scanner.nextLine();

                    controller.cadastrar(
                            new Perfil(id,nome)
                    );

                    break;

                case 2:

                    for(Perfil perfil :
                            controller.listar()){

                        System.out.println(
                                perfil
                        );
                    }

                    break;

                case 3:

                    System.out.print("ID: ");

                    int remover =
                            scanner.nextInt();

                    controller.remover(
                            remover
                    );

                    break;
            }

        }while(opcao != 0);
    }
}