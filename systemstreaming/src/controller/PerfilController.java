package controller;

import model.Perfil;
import java.util.ArrayList;

public class PerfilController {

    private ArrayList<Perfil> perfis =
            new ArrayList<>();

    public void cadastrar(Perfil perfil){
        perfis.add(perfil);
    }

    public ArrayList<Perfil> listar(){
        return perfis;
    }

    public boolean remover(int id){

        for(Perfil perfil : perfis){

            if(perfil.getId() == id){

                perfis.remove(perfil);
                return true;
            }
        }

        return false;
    }
}