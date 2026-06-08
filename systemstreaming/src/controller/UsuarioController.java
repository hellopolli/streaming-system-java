package controller;

import model.Usuario;

import java.util.ArrayList;

public class UsuarioController {

    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public void cadastrar(Usuario usuario){
        usuarios.add(usuario);
    }

    public ArrayList<Usuario> listar(){
        return usuarios;
    }

    public Usuario buscarPorId(int id){
        for(Usuario usuario : usuarios){
            if(usuario.getId() == id){
                return usuario;
            }
        }
        return null;
    }

    public boolean remover(int id){
        Usuario usuario = buscarPorId(id);

        if(usuario != null){
            usuarios.remove(usuario);
            return true;
        }

        return false;
    }

    public boolean atualizar(int id, String nome, String email){

        Usuario usuario = buscarPorId(id);

        if(usuario != null){
            usuario.setNome(nome);
            usuario.setEmail(email);
            return true;
        }

        return false;
    }
}