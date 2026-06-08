# Sistema de Gerenciamento de Streaming

## Integrantes

* Heloá
* Yara
* Gabriely
* Rafael

---

# Descrição do Projeto

O Sistema de Gerenciamento de Streaming foi desenvolvido em Java utilizando os conceitos de Programação Orientada a Objetos (POO) e arquitetura MVC (Model-View-Controller).

O sistema permite gerenciar usuários, perfis, assinaturas, filmes, séries, documentários, avaliações, categorias, favoritos e histórico de visualização, simulando o funcionamento básico de uma plataforma de streaming.

---

# Objetivos

* Aplicar os conceitos de Programação Orientada a Objetos.
* Utilizar arquitetura MVC.
* Implementar herança, polimorfismo, interfaces e classes abstratas.
* Trabalhar com coleções.
* Desenvolver múltiplos CRUDs.
* Simular um sistema real de streaming.

---

# Funcionalidades

## Usuários

* Cadastrar usuário
* Listar usuários
* Atualizar usuário
* Remover usuário

## Perfis

* Criar perfil
* Listar perfis
* Remover perfil

## Assinaturas

* Criar assinatura
* Listar assinaturas
* Cancelar assinatura

## Filmes

* Cadastrar filme
* Listar filmes
* Atualizar filme
* Remover filme

## Séries

* Cadastrar série
* Listar séries
* Atualizar série
* Remover série

## Documentários

* Cadastrar documentário
* Listar documentários
* Remover documentários

## Avaliações

* Registrar avaliação
* Listar avaliações
* Calcular média das avaliações

## Categorias

* Cadastrar categoria
* Listar categorias
* Remover categoria

## Histórico

* Consultar histórico de visualizações

## Favoritos

* Consultar conteúdos favoritos

## Relatórios

* Relatório de filmes
* Relatório de séries

## Logs

* Consulta dos registros do sistema

---

# Estrutura do Projeto

## Model

* Conteudo (Classe Abstrata)
* Filme
* Serie
* Documentario
* Episodio
* Usuario
* Perfil
* Assinatura
* Avaliacao
* Historico
* Categoria
* LogSistema

## Controller

* UsuarioController
* PerfilController
* AssinaturaController
* FilmeController
* SerieController
* DocumentarioController
* HistoricoController
* FavoritoController
* AvaliacaoController
* RelatorioController
* CategoriaController
* LogController

## View

* UsuarioView
* PerfilView
* AssinaturaView
* FilmeView
* SerieView
* DocumentarioView
* HistoricoView
* FavoritoView
* AvaliacaoView
* RelatorioView
* CategoriaView
* LogView

---

# Relações Entre Classes

## Herança

A classe abstrata Conteudo é a classe mãe do sistema.

Subclasses:

* Filme
* Serie
* Documentario

---

## Interface

A interface Reproduzivel é implementada por:

* Filme
* Serie
* Documentario

---

## Associação

Um usuário pode interagir com conteúdos do catálogo.

Exemplo:

Usuario → Conteudo

---

## Agregação

Um usuário pode possuir perfis associados.

Usuario → Perfil

---

## Composição

Uma série é composta por episódios.

Serie → Episodio

Se a série deixar de existir, seus episódios também deixam de existir.

---

# Conceitos Aplicados

* Encapsulamento
* Herança
* Polimorfismo
* Classe Abstrata
* Interface
* Coleções
* MVC
* Estruturas de Controle
* Estruturas de Repetição
* CRUD
* Relacionamentos entre Objetos

---

# Como Executar

## Requisitos

* Java JDK 17 ou superior
* IntelliJ IDEA ou VS Code

## Passos

1. Clonar o repositório:

git clone URL_DO_REPOSITORIO

2. Abrir o projeto na IDE.

3. Executar a classe:

Main.java

4. Utilizar o menu principal para acessar as funcionalidades do sistema.

---

# Uso de Inteligência Artificial

Durante o desenvolvimento do projeto foi utilizada Inteligência Artificial como ferramenta de apoio para:

* Planejamento da estrutura do sistema.
* Sugestão de arquitetura MVC.
* Revisão de código.
* Geração de exemplos de implementação.
* Apoio na documentação.

Todo o código foi revisado, adaptado e compreendido pelos integrantes antes da entrega.

---

# Referências

* Material das aulas da disciplina.

* Documentação Oficial Java:
  https://docs.oracle.com/javase/

* Oracle Java Tutorials:
  https://docs.oracle.com/javase/tutorial/

* Git Documentation:
  https://git-scm.com/doc

---

# Considerações Finais

Este projeto foi desenvolvido com o objetivo de aplicar os conceitos estudados na disciplina de Programação Orientada a Objetos, utilizando boas práticas de desenvolvimento, organização em camadas e modelagem orientada a objetos.
