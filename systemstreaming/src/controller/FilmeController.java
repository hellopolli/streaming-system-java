package controller;

import model.Filme;

import java.util.ArrayList;

public class FilmeController {

    private ArrayList<Filme> filmes = new ArrayList<>();

    public void cadastrar(Filme filme){
        filmes.add(filme);
    }

    public ArrayList<Filme> listar(){
        return filmes;
    }

    public Filme buscarPorId(int id){

        for(Filme filme : filmes){

            if(filme.getId() == id){
                return filme;
            }
        }

        return null;
    }

    public boolean remover(int id){

        Filme filme = buscarPorId(id);

        if(filme != null){
            filmes.remove(filme);
            return true;
        }

        return false;
    }

    public boolean atualizar(int id, String titulo, String genero){

        Filme filme = buscarPorId(id);

        if(filme != null){
            filme.setTitulo(titulo);
            filme.setGenero(genero);
            return true;
        }

        return false;
    }
}