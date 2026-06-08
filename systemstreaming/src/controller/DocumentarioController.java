package controller;

import model.Documentario;

import java.util.ArrayList;

public class DocumentarioController {

    private ArrayList<Documentario> documentarios = new ArrayList<>();

    public void cadastrar(Documentario documentario){
        documentarios.add(documentario);
    }

    public ArrayList<Documentario> listar(){
        return documentarios;
    }

    public Documentario buscarPorId(int id){

        for(Documentario doc : documentarios){

            if(doc.getId() == id){
                return doc;
            }
        }

        return null;
    }

    public boolean remover(int id){

        Documentario doc = buscarPorId(id);

        if(doc != null){
            documentarios.remove(doc);
            return true;
        }

        return false;
    }
}