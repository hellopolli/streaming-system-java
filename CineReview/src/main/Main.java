package main;

import controller.AvaliacaoController;
import controller.CategoriaController;
import controller.ComentarioController;
import controller.DocumentarioController;
import controller.FavoritoController;
import controller.FilmeController;
import controller.HistoricoController;
import controller.LogController;
import controller.RecomendacaoController;
import controller.RelatorioController;
import controller.SerieController;
import controller.UsuarioController;
import util.Dados;
import view.AvaliacaoView;
import view.CategoriaView;
import view.ComentarioView;
import view.DocumentarioView;
import view.FavoritoView;
import view.FilmeView;
import view.HistoricoView;
import view.LogView;
import view.MainView;
import view.RecomendacaoView;
import view.RelatorioView;
import view.SerieView;
import view.UsuarioView;

/**
 * Classe principal de inicializacao do CineReview.
 */
public class Main {
    public static void main(String[] args) {
        Dados dados = new Dados();

        UsuarioController usuarioController = new UsuarioController(dados);
        FilmeController filmeController = new FilmeController(dados);
        SerieController serieController = new SerieController(dados);
        DocumentarioController documentarioController = new DocumentarioController(dados);
        AvaliacaoController avaliacaoController = new AvaliacaoController(dados);
        ComentarioController comentarioController = new ComentarioController(dados);
        FavoritoController favoritoController = new FavoritoController(dados);
        HistoricoController historicoController = new HistoricoController(dados);
        CategoriaController categoriaController = new CategoriaController(dados);
        RelatorioController relatorioController = new RelatorioController(dados);
        RecomendacaoController recomendacaoController = new RecomendacaoController(dados);
        LogController logController = new LogController();

        MainView mainView = new MainView(
                new UsuarioView(usuarioController),
                new FilmeView(filmeController),
                new SerieView(serieController),
                new DocumentarioView(documentarioController),
                new AvaliacaoView(avaliacaoController),
                new ComentarioView(comentarioController),
                new FavoritoView(favoritoController),
                new HistoricoView(historicoController),
                new RelatorioView(relatorioController),
                new RecomendacaoView(recomendacaoController),
                new LogView(logController),
                new CategoriaView(categoriaController)
        );

        mainView.iniciar();
    }
}
