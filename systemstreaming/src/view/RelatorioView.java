package view;

import controller.RelatorioController;
import model.Filme;
import model.Serie;

import java.util.ArrayList;

public class RelatorioView {

    private RelatorioController controller;

    public RelatorioView(
            RelatorioController controller) {

        this.controller = controller;
    }

    public void exibirFilmes(
            ArrayList<Filme> filmes) {

        controller.gerarRelatorioFilmes(
                filmes
        );
    }

    public void exibirSeries(
            ArrayList<Serie> series) {

        controller.gerarRelatorioSeries(
                series
        );
    }
}