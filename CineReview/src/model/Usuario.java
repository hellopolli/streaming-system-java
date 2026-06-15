package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Usuario do sistema. Associa avaliacoes e agrega favoritos.
 */
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String nome;
    private String email;
    private ArrayList<Avaliacao> avaliacoes;
    private ArrayList<Favorito> favoritos;

    public Usuario(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.avaliacoes = new ArrayList<>();
        this.favoritos = new ArrayList<>();
    }

    public void adicionarAvaliacao(Avaliacao avaliacao) {
        avaliacoes.add(avaliacao);
    }

    public void adicionarFavorito(Favorito favorito) {
        favoritos.add(favorito);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public ArrayList<Favorito> getFavoritos() {
        return favoritos;
    }

    @Override
    public String toString() {
        return id + " - " + nome + " <" + email + ">";
    }
}
