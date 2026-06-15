package view;

import util.ConsoleUtil;
import util.LogUtil;

/**
 * View principal responsavel pela navegacao do sistema.
 */
public class MainView {
    private final UsuarioView usuarioView;
    private final FilmeView filmeView;
    private final SerieView serieView;
    private final DocumentarioView documentarioView;
    private final AvaliacaoView avaliacaoView;
    private final ComentarioView comentarioView;
    private final FavoritoView favoritoView;
    private final HistoricoView historicoView;
    private final RelatorioView relatorioView;
    private final RecomendacaoView recomendacaoView;
    private final LogView logView;
    private final CategoriaView categoriaView;

    public MainView(UsuarioView usuarioView, FilmeView filmeView, SerieView serieView,
                    DocumentarioView documentarioView, AvaliacaoView avaliacaoView,
                    ComentarioView comentarioView, FavoritoView favoritoView,
                    HistoricoView historicoView, RelatorioView relatorioView,
                    RecomendacaoView recomendacaoView, LogView logView,
                    CategoriaView categoriaView) {
        this.usuarioView = usuarioView;
        this.filmeView = filmeView;
        this.serieView = serieView;
        this.documentarioView = documentarioView;
        this.avaliacaoView = avaliacaoView;
        this.comentarioView = comentarioView;
        this.favoritoView = favoritoView;
        this.historicoView = historicoView;
        this.relatorioView = relatorioView;
        this.recomendacaoView = recomendacaoView;
        this.logView = logView;
        this.categoriaView = categoriaView;
    }

    public void iniciar() {
        LogUtil.registrar("LOGIN", "Sistema iniciado");
        int opcao;
        do {
            exibirMenu();
            opcao = ConsoleUtil.lerInt("Escolha uma opcao: ");
            switch (opcao) {
                case 1:
                    usuarioView.menu();
                    break;
                case 2:
                    filmeView.menu();
                    break;
                case 3:
                    serieView.menu();
                    break;
                case 4:
                    documentarioView.menu();
                    break;
                case 5:
                    avaliacaoView.menu();
                    break;
                case 6:
                    comentarioView.menu();
                    break;
                case 7:
                    favoritoView.menu();
                    break;
                case 8:
                    historicoView.menu();
                    break;
                case 9:
                    relatorioView.menu();
                    break;
                case 10:
                    recomendacaoView.menu();
                    break;
                case 11:
                    logView.menu();
                    break;
                case 12:
                    categoriaView.menu();
                    break;
                case 0:
                    LogUtil.registrar("SAIDA", "Sistema encerrado");
                    System.out.println("Encerrando CineReview...");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);
    }

    private void exibirMenu() {
        System.out.println("\n=================================");
        System.out.println("CINE REVIEW");
        System.out.println("===========");
        System.out.println("1 - Gerenciar Usuarios");
        System.out.println("2 - Gerenciar Filmes");
        System.out.println("3 - Gerenciar Series");
        System.out.println("4 - Gerenciar Documentarios");
        System.out.println("5 - Avaliacoes");
        System.out.println("6 - Comentarios");
        System.out.println("7 - Favoritos");
        System.out.println("8 - Historico Assistido");
        System.out.println("9 - Relatorios");
        System.out.println("10 - Recomendacoes");
        System.out.println("11 - Logs do Sistema");
        System.out.println("12 - Gerenciar Categorias");
        System.out.println("0 - Sair");
    }
}
