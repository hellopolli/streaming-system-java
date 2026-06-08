package view;

import controller.HistoricoController;
import model.Conteudo;

public class HistoricoView {

    private HistoricoController controller;

    public HistoricoView(
            HistoricoController controller) {

        this.controller = controller;
    }

    public void listarHistorico() {

        System.out.println(
                "\n=== HISTÓRICO ==="
        );

        for (Conteudo conteudo :
                controller.listarHistorico()) {

            System.out.println(
                    conteudo
            );
        }
    }
}