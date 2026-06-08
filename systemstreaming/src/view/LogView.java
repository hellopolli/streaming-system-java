package view;

import controller.LogController;
import model.LogSistema;

public class LogView {

    private LogController controller;

    public LogView(
            LogController controller) {

        this.controller = controller;
    }

    public void listarLogs() {

        System.out.println(
                "\n=== LOGS ==="
        );

        for (LogSistema log :
                controller.listar()) {

            System.out.println(
                    log
            );
        }
    }
}