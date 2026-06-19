package controller;

import model.Avaliacao;
import model.Conteudo;
import model.Documentario;
import model.Filme;
import model.Relatorio;
import model.Serie;
import model.Usuario;
import util.Dados;


public class RelatorioController {
    private final Dados dados;

    public RelatorioController(Dados dados) {
        this.dados = dados;
    }

    public Relatorio gerarRelatorioGeral() {
        return new Relatorio("Relatorio Geral",
                "Conteudo mais bem avaliado: " + conteudoMaisBemAvaliado() + System.lineSeparator()
                        + "Usuario que mais avaliou: " + usuarioQueMaisAvaliou() + System.lineSeparator()
                        + "Quantidade de filmes: " + dados.getFilmes().size() + System.lineSeparator()
                        + "Quantidade de series: " + dados.getSeries().size() + System.lineSeparator()
                        + "Quantidade de documentarios: " + dados.getDocumentarios().size());
    }

    public String conteudoMaisBemAvaliado() {
        Conteudo melhor = null;
        double maiorMedia = -1;
        for (Filme filme : dados.getFilmes()) {
            if (filme.calcularMedia() > maiorMedia) {
                melhor = filme;
                maiorMedia = filme.calcularMedia();
            }
        }
        for (Serie serie : dados.getSeries()) {
            if (serie.calcularMedia() > maiorMedia) {
                melhor = serie;
                maiorMedia = serie.calcularMedia();
            }
        }
        for (Documentario documentario : dados.getDocumentarios()) {
            if (documentario.calcularMedia() > maiorMedia) {
                melhor = documentario;
                maiorMedia = documentario.calcularMedia();
            }
        }
        return melhor == null ? "Nenhum conteudo avaliado" : melhor.getTitulo() + " - media " + maiorMedia;
    }

    public String usuarioQueMaisAvaliou() {
        Usuario melhor = null;
        int maiorQuantidade = -1;
        for (Usuario usuario : dados.getUsuarios()) {
            int quantidade = 0;
            for (Avaliacao avaliacao : dados.getAvaliacoes()) {
                if (avaliacao.getUsuarioId() == usuario.getId()) {
                    quantidade++;
                }
            }
            if (quantidade > maiorQuantidade) {
                melhor = usuario;
                maiorQuantidade = quantidade;
            }
        }
        return melhor == null ? "Nenhum usuario" : melhor.getNome() + " - " + maiorQuantidade + " avaliacoes";
    }
}
