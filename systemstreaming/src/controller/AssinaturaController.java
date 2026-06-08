package controller;

import model.Assinatura;

import java.util.ArrayList;

public class AssinaturaController {

    private ArrayList<Assinatura> assinaturas = new ArrayList<>();

    public void cadastrar(Assinatura assinatura){
        assinaturas.add(assinatura);
    }

    public ArrayList<Assinatura> listar(){
        return assinaturas;
    }

    public boolean cancelar(int id){

        for(Assinatura assinatura : assinaturas){

            if(assinatura.getId() == id){

                assinatura.setAtiva(false);
                return true;
            }
        }

        return false;
    }
}