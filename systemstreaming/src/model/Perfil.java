package model;

import java.io.Serializable;

public class Perfil implements Serializable {

    private int id;
    private String nomePerfil;

    public Perfil(int id, String nomePerfil) {
        this.id = id;
        this.nomePerfil = nomePerfil;
    }

    public int getId() {
        return id;
    }

    public String getNomePerfil() {
        return nomePerfil;
    }

    public void setNomePerfil(String nomePerfil) {
        this.nomePerfil = nomePerfil;
    }

    @Override
    public String toString() {
        return nomePerfil;
    }
}