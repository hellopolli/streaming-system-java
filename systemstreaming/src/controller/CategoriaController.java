package controller;

import model.Categoria;

import java.util.ArrayList;

public class CategoriaController {

    private ArrayList<Categoria> categorias = new ArrayList<>();

    public void cadastrar(Categoria categoria){
        categorias.add(categoria);
    }

    public ArrayList<Categoria> listar(){
        return categorias;
    }

    public boolean remover(int id){

        Categoria categoria = null;

        for(Categoria c : categorias){

            if(c.getId() == id){
                categoria = c;
            }
        }

        if(categoria != null){
            categorias.remove(categoria);
            return true;
        }

        return false;
    }
}