package controller;

import model.Serie;

import java.util.ArrayList;

public class SerieController {

    private ArrayList<Serie> series = new ArrayList<>();

    public void cadastrar(Serie serie){
        series.add(serie);
    }

    public ArrayList<Serie> listar(){
        return series;
    }

    public Serie buscarPorId(int id){

        for(Serie serie : series){

            if(serie.getId() == id){
                return serie;
            }
        }

        return null;
    }

    public boolean remover(int id){

        Serie serie = buscarPorId(id);

        if(serie != null){
            series.remove(serie);
            return true;
        }

        return false;
    }

    public boolean atualizar(int id, String titulo, int temporadas){

        Serie serie = buscarPorId(id);

        if(serie != null){
            serie.setTitulo(titulo);
            serie.setTemporadas(temporadas);
            return true;
        }

        return false;
    }
}