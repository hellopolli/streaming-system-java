package controller;

import model.Conteudo;

import java.util.HashSet;
import java.util.Set;

public class FavoritoController {

    private Set<Conteudo> favoritos = new HashSet<>();

    public void adicionarFavorito(Conteudo conteudo){
        favoritos.add(conteudo);
    }

    public void removerFavorito(Conteudo conteudo){
        favoritos.remove(conteudo);
    }

    public Set<Conteudo> listarFavoritos(){
        return favoritos;
    }
}