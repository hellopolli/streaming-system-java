package controller;

import model.Conteudo;

import java.util.ArrayList;

public class HistoricoController {

    private ArrayList<Conteudo> historico = new ArrayList<>();

    public void registrarVisualizacao(Conteudo conteudo){
        historico.add(conteudo);
    }

    public ArrayList<Conteudo> listarHistorico(){
        return historico;
    }
}