package view;

import controller.FavoritoController;
import model.Conteudo;

public class FavoritoView {

    private FavoritoController controller;

    public FavoritoView(
            FavoritoController controller) {

        this.controller = controller;
    }

    public void listarFavoritos() {

        System.out.println(
                "\n=== FAVORITOS ==="
        );

        for (Conteudo conteudo :
                controller.listarFavoritos()) {

            System.out.println(
                    conteudo
            );
        }
    }
}