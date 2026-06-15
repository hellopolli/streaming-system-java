# CineReview

## Descricao do projeto

CineReview e um sistema Java puro para catalogar, consultar, avaliar e gerenciar filmes, series e documentarios. O projeto foi organizado para apresentacao academica, utilizando Programacao Orientada a Objetos, arquitetura MVC, persistencia em arquivos, serializacao e log de atividades.

## Objetivo

Permitir que usuarios cadastrem conteudos audiovisuais, registrem avaliacoes, comentarios, favoritos e historico assistido, alem de consultar relatorios e recomendacoes baseadas em genero favorito, maior nota e popularidade.

## Estrutura MVC

```text
src/
  controller/  Controllers com regras de CRUD e consultas
  main/        Classe Main para inicializacao
  model/       Entidades, classe abstrata, interface e relacionamentos
  util/        Persistencia, logs, validacoes, excecoes e leitura de console
  view/        Menus e telas de console
```

## Principais classes

- `Conteudo`: classe abstrata com atributos comuns e metodos `exibirDetalhes()` e `calcularPopularidade()`.
- `Filme`, `Serie`, `Documentario`: classes filhas que sobrescrevem `exibirDetalhes()` e implementam `Avaliavel`.
- `Avaliavel`: interface com `adicionarAvaliacao()` e `calcularMedia()`.
- `Usuario`: representa usuarios e associa avaliacoes, agregando favoritos.
- `Avaliacao`, `Comentario`, `Favorito`, `Historico`, `Categoria`: modelos de dominio serializaveis.
- `ArquivoUtil`: grava e le arquivos `.dat` com `ObjectOutputStream` e `ObjectInputStream`.
- `LogUtil`: registra cadastro, alteracao, exclusao, avaliacoes, erros, login e saida em `data/log.txt`.
- `ValidacaoUtil`: valida campos obrigatorios, notas e IDs duplicados.

## Relacionamentos

- Associacao: `Usuario -> Avaliacao`.
- Agregacao: `Usuario -> Favorito`.
- Composicao: `Serie -> Episodio`, pois os episodios sao criados e mantidos pela serie.

## Funcionalidades

- CRUD de usuarios, filmes, series, documentarios, avaliacoes, comentarios, favoritos, historico, categorias e logs.
- Buscas sobrecarregadas por titulo, titulo/genero e ano.
- Relatorios de conteudo mais bem avaliado, usuario que mais avaliou e quantidades por tipo.
- Recomendacoes por genero favorito, maior nota e conteudos mais avaliados.
- Tratamento de `InputMismatchException`, `IOException`, `FileNotFoundException` e `AvaliacaoInvalidaException`.
- Persistencia em `usuarios.dat`, `filmes.dat`, `series.dat`, `documentarios.dat`, `avaliacoes.dat`, `comentarios.dat`, `favoritos.dat` e `historico.dat`.

## Como executar no IntelliJ IDEA

1. Abra o IntelliJ IDEA.
2. Escolha **Open** e selecione a pasta `CineReview`.
3. Marque `src` como Sources Root, se necessario.
4. Abra `src/main/Main.java`.
5. Execute o metodo `main`.

## Como executar pelo terminal

Na pasta `CineReview`, execute:

```bash
javac -d out src/model/*.java src/util/*.java src/controller/*.java src/view/*.java src/main/*.java
java -cp out main.Main
```

## Tecnologias utilizadas

- Java puro.
- Programacao Orientada a Objetos.
- MVC.
- Serializacao nativa do Java.
- Arquivos `.dat` e `.txt`.
- `ArrayList`.

## Utilizacao de IA no desenvolvimento

Este projeto foi gerado com apoio de IA para estruturar as classes, aplicar os requisitos de POO/MVC, organizar os pacotes e produzir um codigo base compilavel para fins academicos. A revisao final deve ser feita pelo estudante, especialmente para adaptar textos, exemplos e demonstracao oral.

## Referencias

- Documentacao oficial do Java: https://docs.oracle.com/en/java/
- Java Object Serialization Specification: https://docs.oracle.com/javase/8/docs/platform/serialization/spec/serialTOC.html
- IntelliJ IDEA Documentation: https://www.jetbrains.com/help/idea/
