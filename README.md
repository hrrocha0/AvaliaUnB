# AvaliaUnB

Henrique Rodrigues Rocha - 211036061

## Sobre

Este projeto foi desenvolvido para a disciplina Bancos de Dados (2023.1) na Universidade de Brasília.
O objetivo é criar um sistema em que os estudantes possam avaliar professores e disciplinas as quais cursou em semestres anteriores, assim como denunciar avaliações ofensivas.

Essa implementação cumpre com os seguintes requisitos:

- [X] Modelo Entidade Relacionamento do banco de dados;
- [X] Modelo Relacional do banco de dados;
- [X] Interface visual para interação com o usuário;
- [X] CRUD para as principais entidades do banco de dados;
- [X] Camada de persistência SQL;
- [X] Código para a inserção de linhas em cada tabela;
- [X] Construção de uma *View*;
- [ ] Construção de uma *Procedure*;
- [ ] Inserção de dados binários (BLOB);
- [X] Vídeo apresentando o programa desenvolvido.

## Instruções de Execução

Para executar a aplicação, uma versão do Java compatível deve estar instalada (o JDK utilizado neste programa foi o *Eclipse Adoptium jdk-17.0.1.12-hotspot*). Então, basta executar o arquivo *AvaliaUnB-1.0.0.jar*, que pode ser encontrado no diretório *jar* do projeto. O banco de dados já deve estar inicializado, porém as tabelas podem ser criadas por meio do arquivo *init.sql*, e os dados principais pelo script *data.main.kts*. O programa também pode ser executado pelo Gradle, por meio do comando

```
gradlew run
```

A IDE *Intellij Idea (2023.1)* providencia métodos para facilitar a execução do programa em Kotlin, como um compilador integrado para a versão mais recente da linguagem (1.9.0). Ao usar essa IDE, também é possível executar o programa rodando diretamente o arquivo *Main.kt*.
