package view;

import controller.FilmeController;
import model.Filme;

import java.util.Scanner;

public class FilmeView {

    private FilmeController controller;
    private Scanner scanner;

    public FilmeView(FilmeController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void menu() {

        int opcao;

        do {

            System.out.println("\n=== FILMES ===");
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

        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();

        System.out.print("Genero: ");
        String genero = scanner.nextLine();

        System.out.print("Duracao: ");
        int duracao = scanner.nextInt();

        controller.cadastrar(
                new Filme(
                        id,
                        titulo,
                        genero,
                        duracao
                )
        );

        System.out.println("Filme cadastrado.");
    }

    private void listar() {

        for (Filme filme : controller.listar()) {
            System.out.println(filme);
        }
    }

    private void atualizar() {

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Novo titulo: ");
        String titulo = scanner.nextLine();

        System.out.print("Novo genero: ");
        String genero = scanner.nextLine();

        if (controller.atualizar(id, titulo, genero)) {
            System.out.println("Atualizado.");
        } else {
            System.out.println("Filme nao encontrado.");
        }
    }

    private void remover() {

        System.out.print("ID: ");
        int id = scanner.nextInt();

        if (controller.remover(id)) {
            System.out.println("Removido.");
        } else {
            System.out.println("Filme nao encontrado.");
        }
    }
}