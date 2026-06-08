package view;

import controller.UsuarioController;
import model.Usuario;

import java.util.Scanner;

public class UsuarioView {

    private UsuarioController controller;
    private Scanner scanner;

    public UsuarioView(UsuarioController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void menu() {

        int opcao;

        do {

            System.out.println("\n=== USUARIOS ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Remover");
            System.out.println("0 - Voltar");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    cadastrar();
                    break;

                case 2:
                    listar();
                    break;

                case 3:
                    atualizar();
                    break;

                case 4:
                    remover();
                    break;
            }

        } while (opcao != 0);
    }

    private void cadastrar() {

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        controller.cadastrar(
                new Usuario(id, nome, email)
        );

        System.out.println("Usuario cadastrado.");
    }

    private void listar() {

        for (Usuario usuario : controller.listar()) {
            System.out.println(usuario);
        }
    }

    private void atualizar() {

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();

        System.out.print("Novo email: ");
        String email = scanner.nextLine();

        if (controller.atualizar(id, nome, email)) {
            System.out.println("Atualizado.");
        } else {
            System.out.println("Usuario nao encontrado.");
        }
    }

    private void remover() {

        System.out.print("ID: ");
        int id = scanner.nextInt();

        if (controller.remover(id)) {
            System.out.println("Removido.");
        } else {
            System.out.println("Usuario nao encontrado.");
        }
    }
}