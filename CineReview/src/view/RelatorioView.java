package view;

import controller.RelatorioController;

/**
 * View de console para relatorios.
 */
public class RelatorioView {
    private final RelatorioController controller;

    public RelatorioView(RelatorioController controller) {
        this.controller = controller;
    }

    public void menu() {
        System.out.println("\n--- Relatorios ---");
        System.out.println(controller.gerarRelatorioGeral());
    }
}
