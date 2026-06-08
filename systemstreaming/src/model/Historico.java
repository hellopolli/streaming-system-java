package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Historico implements Serializable {

    private int id;
    private Usuario usuario;
    private Conteudo conteudo;
    private LocalDateTime dataVisualizacao;

    public Historico(int id,
                     Usuario usuario,
                     Conteudo conteudo) {

        this.id = id;
        this.usuario = usuario;
        this.conteudo = conteudo;
        this.dataVisualizacao = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Conteudo getConteudo() {
        return conteudo;
    }

    public LocalDateTime getDataVisualizacao() {
        return dataVisualizacao;
    }

    @Override
    public String toString() {

        return usuario.getNome()
                + " assistiu "
                + conteudo.getTitulo()
                + " em "
                + dataVisualizacao;
    }
}