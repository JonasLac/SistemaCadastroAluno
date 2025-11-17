📚 Sistema de Gerenciamento de Alunos

Este projeto é um Sistema Simples de Gerenciamento de Alunos desenvolvido em Java. Ele utiliza a estrutura de uma aplicação de console (linha de comando) para simular o cadastro e a manipulação de dados de estudantes.

💻 Conceitos Utilizados
O código demonstra a aplicação de vários conceitos fundamentais da Programação Orientada a Objetos (POO) e da linguagem Java:

Classes e Objetos: Definição da classe Aluno para representar a entidade estudante, encapsulando seus atributos (nome, idade, curso, nota, etc.) e métodos (getters e setters) para acesso e modificação. A classe Main atua como o ponto de entrada e o gerenciador do sistema.

Encapsulamento: Uso de atributos private na classe Aluno e fornecimento de métodos public (getters e setters) para controlar o acesso aos dados.

Estruturas de Dados Dinâmicas: Utilização de ArrayList<Aluno> para armazenar uma coleção dinâmica de objetos Aluno, permitindo adicionar e gerenciar os estudantes de forma flexível.

Entrada e Saída (I/O) e Interação com o Usuário: Uso da classe Scanner para receber dados de entrada do usuário através do console, permitindo a interação via menu de opções.

Estruturas de Controle: Emprego de while (para o menu principal) e switch (para as opções do menu) para controlar o fluxo de execução do programa.

Tratamento de Exceções: Implementação de blocos try-catch para lidar com possíveis erros de formatação de entrada (como NumberFormatException) ao ler números inteiros ou double do usuário.

Métodos Estáticos (static): As funcionalidades de gerenciamento (cadastro, adicionar nota, calcular média, etc.) são implementadas como métodos estáticos na classe Main para fácil acesso no contexto do sistema de console.

APIs do Java: Demonstra o uso de funcionalidades como System.out.println(), manipulação de strings e o uso básico da Stream API (listaAlunos.stream().filter(...)) para busca de alunos por nome.

✨ Funcionalidades
O sistema oferece as seguintes opções ao usuário:

Cadastrar novo aluno: Adiciona um novo objeto Aluno à lista.

Adicionar notas de alunos: Permite selecionar um aluno e atualizar sua nota.

Média dos alunos: Exibe a nota (média, neste contexto simplificado) de um aluno específico, buscando-o pelo nome.

Média geral da turma: Calcula e exibe a média de todas as notas dos alunos cadastrados.

Exibir dados do aluno: Mostra todos os dados de um aluno específico, buscando-o pelo nome.

Sair: Encerra a aplicação.
