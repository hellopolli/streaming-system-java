package controller;

import model.LogSistema;

import java.util.ArrayList;

public class LogController {

    private ArrayList<LogSistema> logs =
            new ArrayList<>();

    public void registrar(String mensagem){

        logs.add(
                new LogSistema(mensagem)
        );
    }

    public ArrayList<LogSistema> listar(){

        return logs;
    }
}