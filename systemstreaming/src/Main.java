import controller.*;

import view.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Controllers
        UsuarioController usuarioController =
                new UsuarioController();

        PerfilController perfilController =
                new PerfilController();

        AssinaturaController assinaturaController =
                new AssinaturaController();

        FilmeController filmeController =
                new FilmeController();

        SerieController serieController =
                new SerieController();

        DocumentarioController documentarioController =
                new DocumentarioController();

        HistoricoController historicoController =
                new HistoricoController();

        FavoritoController favoritoController =
                new FavoritoController();

        AvaliacaoController avaliacaoController =
                new AvaliacaoController();

        RelatorioController relatorioController =
                new RelatorioController();

        CategoriaController categoriaController =
                new CategoriaController();

        LogController logController =
                new LogController();

        // Views
        UsuarioView usuarioView =
                new UsuarioView(usuarioController);

        PerfilView perfilView =
                new PerfilView(perfilController);

        AssinaturaView assinaturaView =
                new AssinaturaView(assinaturaController);

        FilmeView filmeView =
                new FilmeView(filmeController);

        SerieView serieView =
                new SerieView(serieController);

        DocumentarioView documentarioView =
                new DocumentarioView(documentarioController);

        HistoricoView historicoView =
                new HistoricoView(historicoController);

        FavoritoView favoritoView =
                new FavoritoView(favoritoController);

        AvaliacaoView avaliacaoView =
                new AvaliacaoView(avaliacaoController);

        RelatorioView relatorioView =
                new RelatorioView(relatorioController);

        CategoriaView categoriaView =
                new CategoriaView(categoriaController);

        LogView logView =
                new LogView(logController);

        int opcao;

        do {

            System.out.println("\n=================================");
            System.out.println(" SISTEMA DE STREAMING ");
            System.out.println("=================================");
            System.out.println("1  - Usuários");
            System.out.println("2  - Perfis");
            System.out.println("3  - Assinaturas");
            System.out.println("4  - Filmes");
            System.out.println("5  - Séries");
            System.out.println("6  - Documentários");
            System.out.println("7  - Avaliações");
            System.out.println("8  - Categorias");
            System.out.println("9  - Histórico");
            System.out.println("10 - Favoritos");
            System.out.println("11 - Relatórios");
            System.out.println("12 - Logs");
            System.out.println("0  - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    usuarioView.menu();
                    break;

                case 2:
                    perfilView.menu();
                    break;

                case 3:
                    assinaturaView.menu();
                    break;

                case 4:
                    filmeView.menu();
                    break;

                case 5:
                    serieView.menu();
                    break;

                case 6:
                    documentarioView.menu();
                    break;

                case 7:
                    avaliacaoView.menu();
                    break;

                case 8:
                    categoriaView.menu();
                    break;

                case 9:
                    historicoView.listarHistorico();
                    break;

                case 10:
                    favoritoView.listarFavoritos();
                    break;

                case 11:

                    System.out.println("\n=== RELATÓRIOS ===");
                    System.out.println("1 - Filmes");
                    System.out.println("2 - Séries");

                    int relatorio =
                            scanner.nextInt();

                    if(relatorio == 1){

                        relatorioView.exibirFilmes(
                                filmeController.listar()
                        );

                    } else if(relatorio == 2){

                        relatorioView.exibirSeries(
                                serieController.listar()
                        );
                    }

                    break;

                case 12:

                    logView.listarLogs();

                    break;

                case 0:

                    System.out.println(
                            "\nSistema encerrado."
                    );

                    break;

                default:

                    System.out.println(
                            "\nOpção inválida."
                    );
            }

        } while (opcao != 0);

        scanner.close();
    }
}