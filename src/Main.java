import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.HashMap;

class Aluno {
    private String nome;
    private int idade;
    private char sexo;
    private int matricula;
    private String curso;
    private double nota;
    private String turno;

    public Aluno(String nome, int idade, char sexo, int matricula, String curso, double nota, String turno) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.matricula = matricula;
        this.curso = curso;
        this.nota = nota;
        this.turno = turno;
    }

    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public char getSexo() { return sexo; }
    public int getMatricula() { return matricula; }
    public String getCurso() { return curso; }
    public double getNota() { return nota; }
    public String getTurno() { return turno; }

    public void setNota(double nota) { this.nota = nota; }
}


public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Aluno> listaAlunos = new ArrayList<>();
    static HashSet<String> cursos = new HashSet<>();
    static HashMap<Integer, Aluno> mapa = new HashMap<>();

    static void cadastrarAluno(Scanner scanner) {

        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a idade do aluno: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o sexo do aluno (M/F): ");
        char sexo = scanner.next().charAt(0);
        scanner.nextLine();

        System.out.print("Digite o número da matrícula: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        if (mapa.containsKey(matricula)) {
            System.out.println("Já existe um aluno com essa matrícula!");
            return;
        }

        System.out.print("Digite o curso do aluno: ");
        String curso = scanner.nextLine();
        cursos.add(curso);

        System.out.print("Digite o turno (Manhã/Tarde/Noite): ");
        String turno = scanner.nextLine();

        Aluno novoAluno = new Aluno(nome, idade, sexo, matricula, curso, 0.0, turno);

        listaAlunos.add(novoAluno);
        mapa.put(matricula, novoAluno);

        System.out.println("Aluno cadastrado com sucesso!");
        exibirDadosAluno(novoAluno);
    }

    static void adicionarNota() {
        System.out.print("Digite a matrícula do aluno: ");
        int matricula = Integer.parseInt(scanner.nextLine());

        Aluno aluno = mapa.get(matricula);

        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        System.out.print("Digite a nota: ");
        double nota = Double.parseDouble(scanner.nextLine().replace(",", "."));
        aluno.setNota(nota);

        System.out.println("Nota adicionada ao aluno " + aluno.getNome());
    }

    static void mediaAluno() {
        System.out.print("Digite a matrícula do aluno: ");
        int matricula = Integer.parseInt(scanner.nextLine());

        Aluno aluno = mapa.get(matricula);

        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        System.out.println("A média do aluno " + aluno.getNome() + " é: " + aluno.getNota());
    }

    static void mediaTurma() {
        if (listaAlunos.isEmpty()) {
            System.out.println("Não há alunos cadastrados.");
            return;
        }

        double soma = 0;
        for (Aluno aluno : listaAlunos) {
            soma += aluno.getNota();
        }

        double media = soma / listaAlunos.size();
        System.out.println("Média geral da turma: " + media);
    }

    static void exibirTodosAlunos() {
        System.out.println("---- Lista de Alunos ----");
        for (Aluno a : listaAlunos) {
            exibirDadosAluno(a);
            System.out.println();
        }
    }

    static void exibirDadosAluno(Aluno a) {
        System.out.println("---- Dados do Aluno ----");
        System.out.println("Nome: " + a.getNome());
        System.out.println("Idade: " + a.getIdade());
        System.out.println("Sexo: " + a.getSexo());
        System.out.println("Matrícula: " + a.getMatricula());
        System.out.println("Curso: " + a.getCurso());
        System.out.println("Turno: " + a.getTurno());
        System.out.println("Nota: " + a.getNota());
    }

    public static void main(String[] args) {
        // Exemplo inicial
        Aluno aluno1 = new Aluno("Ana", 20, 'F', 101, "Engenharia", 8.5, "Manhã");
        Aluno aluno2 = new Aluno("Bruno", 22, 'M', 102, "Medicina", 7.0, "Tarde");

        listaAlunos.add(aluno1);
        listaAlunos.add(aluno2);

        mapa.put(101, aluno1);
        mapa.put(102, aluno2);

        cursos.add("Engenharia");
        cursos.add("Medicina");

        int opcao = 0;

        while (opcao != 7) {
            System.out.println("\nMenu:");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Adicionar nota");
            System.out.println("3 - Média do aluno");
            System.out.println("4 - Média da turma");
            System.out.println("5 - Exibir dados do aluno");
            System.out.println("6 - Exibir todos os alunos");
            System.out.println("7 - Sair");
            System.out.print("Opção: ");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> cadastrarAluno(scanner);
                case 2 -> adicionarNota();
                case 3 -> mediaAluno();
                case 4 -> mediaTurma();
                case 5 -> {
                    System.out.print("Digite a matrícula do aluno: ");
                    int mat = Integer.parseInt(scanner.nextLine());
                    Aluno aluno = mapa.get(mat);
                    if (aluno == null)
                        System.out.println("Aluno não encontrado.");
                    else
                        exibirDadosAluno(aluno);
                }
                case 6 -> exibirTodosAlunos();
                case 7 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}
