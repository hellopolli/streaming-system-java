package controller;

import model.Filme;
import model.Serie;

import java.util.ArrayList;

public class RelatorioController {

    public void gerarRelatorioFilmes(ArrayList<Filme> filmes){

        System.out.println("\n=== FILMES ===");

        for(Filme filme : filmes){
            System.out.println(filme);
        }
    }

    public void gerarRelatorioSeries(ArrayList<Serie> series){

        System.out.println("\n=== SERIES ===");

        for(Serie serie : series){
            System.out.println(serie);
        }
    }
}