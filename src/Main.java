import java.util.ArrayList;
import java.util.Scanner;

class Aluno {
    private String nome;
    private int idade;
    private char sexo;
    private String curso;
    private double nota;
    private String turno;

    public Aluno(String nome, int idade, char sexo, String curso, double nota, String turno) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.curso = curso;
        this.nota = nota;
        this.turno = turno;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Aluno> listaAlunos = new ArrayList<>();

    static void cadastrarAluno(Scanner scanner) {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a idade do aluno: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o sexo do aluno (M/F): ");
        char sexo = scanner.next().charAt(0);
        scanner.nextLine();

        System.out.print("Digite o curso do aluno: ");
        String curso = scanner.nextLine();

        System.out.print("Digite o turno do aluno (Manhã/Tarde/Noite): ");
        String turno = scanner.nextLine();

        Aluno novoAluno = new Aluno(nome, idade, sexo, curso, 0.0, turno);
        listaAlunos.add(novoAluno);
        System.out.println("Aluno cadastrado com sucesso!");
        exibirDadosAluno(novoAluno);
    }

    static void adicionarNota() {
        if (listaAlunos.isEmpty()) {
            System.out.println("Não há alunos cadastrados.");
            return;
        }

        System.out.println("\nEscolha o aluno para adicionar notas:");
        for (int i = 0; i < listaAlunos.size(); i++) {
            System.out.println((i + 1) + ". " + listaAlunos.get(i).getNome());
        }

        System.out.print("Digite o número do aluno: ");
        String entradaEscolha = scanner.nextLine();

        int escolha;
        try {
            escolha = Integer.parseInt(entradaEscolha);
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Digite um número válido.");
            return;
        }

        if (escolha < 1 || escolha > listaAlunos.size()) {
            System.out.println("Escolha inválida.");
            return;
        }

        Aluno alunoSelecionado = listaAlunos.get(escolha - 1);
        System.out.println("Adicionando nota para " + alunoSelecionado.getNome());

        System.out.print("Digite a nota: ");
        String entradaNota = scanner.nextLine().replace(",", ".");

        double nota;
        try {
            nota = Double.parseDouble(entradaNota);
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido! Digite uma nota numérica.");
            return;
        }

        alunoSelecionado.setNota(nota);

        System.out.println("Nota " + nota + " adicionada para " + alunoSelecionado.getNome());
    }


    static void mediaAlunos() {
        System.out.println("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        if (nome == null || nome.isEmpty()) {
            System.out.println("Nome inválido.");
            return;
        }

        for (Aluno aluno : listaAlunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                System.out.println("A média do aluno " + nome + " é: " + aluno.getNota());
                return;
            }
        }

        System.out.println("Aluno não encontrado.");
    }


    static void mediaTurma() {
        if (listaAlunos.isEmpty()) {
            System.out.println("Não há alunos cadastrados.");
            return;
        }

        double somaNotas = 0.0;
        for (Aluno aluno : listaAlunos) {
            somaNotas += aluno.getNota();
        }
        double mediaTurma = somaNotas / listaAlunos.size();
        System.out.println("A média geral da turma é: " + mediaTurma);
    }

    static void exibirDadosAluno(Aluno a) {
        System.out.println("Nome: " + a.getNome());
        System.out.println("Idade: " + a.getIdade());
        System.out.println("Sexo: " + a.getSexo());
        System.out.println("Curso: " + a.getCurso());
        System.out.println("Turno: " + a.getTurno());
        System.out.println("Nota: " + a.getNota());
    }

    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Ana", 20, 'F', "Engenharia", 8.5, "Manhã");
        Aluno aluno2 = new Aluno("Bruno", 22, 'M', "Medicina", 7.0, "Tarde");
        listaAlunos.add(aluno1);
        listaAlunos.add(aluno2);
        System.out.println(" ");
        System.out.println("Bem-vindo ao sistema de cadastro de alunos!");


        int opcao = 0;
        while (opcao != 6) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Cadastrar novo aluno");
            System.out.println("2. Adicionar notas de alunos");
            System.out.println("3. Media dos alunos");
            System.out.println("4. Media geral da turma");
            System.out.println("5. Exibir dados do aluno");
            System.out.println("6. Sair");

            if (scanner.hasNextInt()) {
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    cadastrarAluno(scanner);
                    break;
                case 2:
                    adicionarNota();
                    break;
                case 3:
                    mediaAlunos();
                    break;
                case 4:
                    mediaTurma();
                    break;
                case 5:
                    System.out.println("Digite o nome do aluno para exibir os dados:");
                    String nomeAluno = scanner.nextLine();

                    if (nomeAluno == null || nomeAluno.isEmpty()) {
                        System.out.println("Nome inválido.");
                        break;
                    }

                    Aluno encontrado = listaAlunos.stream()
                            .filter(a -> a.getNome().equalsIgnoreCase(nomeAluno))
                            .findFirst()
                            .orElse(null);

                    if (encontrado == null) {
                        System.out.println("Aluno não encontrado.");
                    } else {
                        exibirDadosAluno(encontrado);
                    }
                    break;

                case 6:
                    System.out.println("Saindo do sistema. Até mais!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}