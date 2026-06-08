package controller;

import model.Avaliacao;

import java.util.ArrayList;

public class AvaliacaoController {

    private ArrayList<Avaliacao> avaliacoes = new ArrayList<>();

    public void adicionar(Avaliacao avaliacao){
        avaliacoes.add(avaliacao);
    }

    public ArrayList<Avaliacao> listar(){
        return avaliacoes;
    }

    public double calcularMedia(){

        if(avaliacoes.isEmpty()){
            return 0;
        }

        double soma = 0;

        for(Avaliacao avaliacao : avaliacoes){
            soma += avaliacao.getNota();
        }

        return soma / avaliacoes.size();
    }
}