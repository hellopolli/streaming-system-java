package view;

import controller.CategoriaController;
import model.Categoria;
import util.ConsoleUtil;

/**
 * View de console para categorias.
 */
public class CategoriaView {
    private final CategoriaController controller;

    public CategoriaView(CategoriaController controller) {
        this.controller = controller;
    }

    public void menu() {
        int opcao;
        do {
            System.out.println("\n--- Categorias ---");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Listar");
            System.out.println("0 - Voltar");
            opcao = ConsoleUtil.lerInt("Opcao: ");
            try {
                switch (opcao) {
                    case 1:
                        controller.cadastrar(ConsoleUtil.lerInt("ID: "),
                                ConsoleUtil.lerTexto("Nome: "),
                                ConsoleUtil.lerTexto("Descricao: "));
                        break;
                    case 2:
                        System.out.println(controller.alterar(ConsoleUtil.lerInt("ID: "),
                                ConsoleUtil.lerTexto("Novo nome: "),
                                ConsoleUtil.lerTexto("Nova descricao: ")) ? "Categoria alterada." : "Categoria nao encontrada.");
                        break;
                    case 3:
                        System.out.println(controller.excluir(ConsoleUtil.lerInt("ID: ")) ? "Categoria excluida." : "Categoria nao encontrada.");
                        break;
                    case 4:
                        for (Categoria categoria : controller.listar()) {
                            System.out.println(categoria);
                        }
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
}
