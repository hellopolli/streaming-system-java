package model;

import java.io.Serializable;

public class Assinatura implements Serializable {

    private int id;
    private String plano;
    private boolean ativa;

    public Assinatura(int id, String plano) {

        this.id = id;
        this.plano = plano;
        this.ativa = true;
    }

    public int getId() {
        return id;
    }

    public String getPlano() {
        return plano;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    @Override
    public String toString() {

        return plano
                + " | Ativa: "
                + ativa;
    }
}