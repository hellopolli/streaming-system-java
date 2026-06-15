package controller;

import model.Avaliacao;
import model.Conteudo;
import model.Documentario;
import model.Filme;
import model.Recomendacao;
import model.Serie;
import util.Dados;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller responsavel por recomendacoes baseadas em genero, nota e popularidade.
 */
public class RecomendacaoController {
    private final Dados dados;

    public RecomendacaoController(Dados dados) {
        this.dados = dados;
    }

    public Recomendacao gerarParaUsuario(int usuarioId) {
        String generoFavorito = descobrirGeneroFavorito(usuarioId);
        Conteudo melhor = buscarMelhorConteudo(generoFavorito);
        if (melhor == null) {
            melhor = buscarMaisAvaliado();
        }
        String mensagem = melhor == null
                ? "Ainda nao ha dados suficientes para recomendacao."
                : "Recomendado: " + melhor.getTitulo() + " | Genero: " + melhor.getGenero()
                + " | Popularidade: " + String.format("%.2f", melhor.calcularPopularidade());
        return new Recomendacao(usuarioId, mensagem);
    }

    public ArrayList<Conteudo> listarConteudosMaisAvaliados() {
        ArrayList<Conteudo> conteudos = todosConteudos();
        conteudos.sort((a, b) -> Double.compare(b.calcularPopularidade(), a.calcularPopularidade()));
        return conteudos;
    }

    private String descobrirGeneroFavorito(int usuarioId) {
        Map<String, Integer> contagem = new HashMap<>();
        for (Avaliacao avaliacao : dados.getAvaliacoes()) {
            if (avaliacao.getUsuarioId() == usuarioId) {
                Conteudo conteudo = buscarConteudo(avaliacao.getTipoConteudo(), avaliacao.getConteudoId());
                if (conteudo != null) {
                    contagem.put(conteudo.getGenero(), contagem.getOrDefault(conteudo.getGenero(), 0) + 1);
                }
            }
        }
        String favorito = "";
        int maior = 0;
        for (Map.Entry<String, Integer> entrada : contagem.entrySet()) {
            if (entrada.getValue() > maior) {
                favorito = entrada.getKey();
                maior = entrada.getValue();
            }
        }
        return favorito;
    }

    private Conteudo buscarMelhorConteudo(String genero) {
        Conteudo melhor = null;
        double maiorMedia = -1;
        for (Conteudo conteudo : todosConteudos()) {
            if ((genero.isEmpty() || conteudo.getGenero().equalsIgnoreCase(genero))
                    && media(conteudo) > maiorMedia) {
                melhor = conteudo;
                maiorMedia = media(conteudo);
            }
        }
        return melhor;
    }

    private Conteudo buscarMaisAvaliado() {
        ArrayList<Conteudo> conteudos = listarConteudosMaisAvaliados();
        return conteudos.isEmpty() ? null : conteudos.get(0);
    }

    private Conteudo buscarConteudo(String tipo, int id) {
        String tipoNormalizado = tipo.toLowerCase();
        for (Filme filme : dados.getFilmes()) {
            if ("filme".equals(tipoNormalizado) && filme.getId() == id) {
                return filme;
            }
        }
        for (Serie serie : dados.getSeries()) {
            if (("serie".equals(tipoNormalizado) || "série".equals(tipoNormalizado)) && serie.getId() == id) {
                return serie;
            }
        }
        for (Documentario documentario : dados.getDocumentarios()) {
            if (("documentario".equals(tipoNormalizado) || "documentário".equals(tipoNormalizado))
                    && documentario.getId() == id) {
                return documentario;
            }
        }
        return null;
    }

    private double media(Conteudo conteudo) {
        if (conteudo instanceof Filme) {
            return ((Filme) conteudo).calcularMedia();
        }
        if (conteudo instanceof Serie) {
            return ((Serie) conteudo).calcularMedia();
        }
        if (conteudo instanceof Documentario) {
            return ((Documentario) conteudo).calcularMedia();
        }
        return 0;
    }

    private ArrayList<Conteudo> todosConteudos() {
        ArrayList<Conteudo> conteudos = new ArrayList<>();
        conteudos.addAll(dados.getFilmes());
        conteudos.addAll(dados.getSeries());
        conteudos.addAll(dados.getDocumentarios());
        return conteudos;
    }
}
