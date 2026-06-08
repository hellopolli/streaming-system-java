package view;

import controller.CategoriaController;
import model.Categoria;

import java.util.Scanner;

public class CategoriaView {

    private CategoriaController controller;
    private Scanner scanner;

    public CategoriaView(
            CategoriaController controller){

        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void menu(){

        int opcao;

        do{

            System.out.println("\n=== CATEGORIA ===");
            System.out.println("1-Cadastrar");
            System.out.println("2-Listar");
            System.out.println("0-Voltar");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao){

                case 1:

                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nome: ");
                    String nome =
                            scanner.nextLine();

                    controller.cadastrar(
                            new Categoria(
                                    id,
                                    nome
                            )
                    );

                    break;

                case 2:

                    for(Categoria categoria :
                            controller.listar()){

                        System.out.println(
                                categoria
                        );
                    }

                    break;
            }

        }while(opcao != 0);
    }
}