package test;

import domain.Aluno;
import domain.Professor;
import domain.Seminario;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class SeminarioTeste01 {
    public static void main(String[] args) {
        ArrayList<Seminario> listaSeminarios = new ArrayList<>();
        ArrayList<Professor> listaProfessores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Digite o nome do professor:");
            String nomeProfessor = scanner.nextLine();
            System.out.println("Digite a especialidade do professor:");
            String especialidadeProfessor = scanner.nextLine();
            Professor professor = new Professor(nomeProfessor, especialidadeProfessor);
            listaProfessores.add(professor);
            System.out.println("Deseja cadastrar outro professor? (s/n)");
            char continuar = scanner.nextLine().charAt(0);
            if (continuar == 'n' || continuar == 'N') {
                break;
            }
        } while (true);

        do {
            int escolha = 0;
            boolean validInput = false;

            while (!validInput) {
                try {
                    System.out.println("Escolha um seminário ou crie um novo:");
                    System.out.println("1. Inteligência Artificial");
                    System.out.println("2. Desenvolvimento Web");
                    System.out.println("3. Ciência de Dados");
                    System.out.println("4. Segurança da Informação");
                    System.out.println("5. Criar novo seminário");

                    escolha = scanner.nextInt();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, digite um número entre 1 e 5.");
                    scanner.next();
                }
            }

            scanner.nextLine();

            String seminarioEscolhido;
            String endereco;
            Professor professor;
            if (escolha >= 1 && escolha <= 4) {
                switch (escolha) {
                    case 1:
                        seminarioEscolhido = "Inteligência Artificial";
                        break;
                    case 2:
                        seminarioEscolhido = "Desenvolvimento Web";
                        break;
                    case 3:
                        seminarioEscolhido = "Ciência de Dados";
                        break;
                    case 4:
                        seminarioEscolhido = "Segurança da Informação";
                        break;
                    default:
                        seminarioEscolhido = "";
                        break;
                }
                System.out.println("Digite o endereço do seminário:");
                endereco = scanner.nextLine();
                professor = new Professor("Junior");
                listaSeminarios.add(new Seminario(seminarioEscolhido, null, endereco, professor));
            } else if (escolha == 5) {
                System.out.println("Digite o nome do novo seminário:");
                seminarioEscolhido = scanner.nextLine();
                System.out.println("Digite o endereço do novo seminário:");
                endereco = scanner.nextLine();
                professor = new Professor("Novo Professor");
                listaSeminarios.add(new Seminario(seminarioEscolhido, null, endereco, professor));
            } else {
                System.out.println("Opção inválida. Escolha um número entre 1 e 5.");
            }

            System.out.println("Deseja adicionar outro seminário? (s/n)");
            char adicionarOutro = scanner.nextLine().charAt(0);
            if (adicionarOutro == 'n' || adicionarOutro == 'N') {
                break;
            }
        } while (true);

        for (Seminario seminario : listaSeminarios) {
            System.out.println("Escolha um professor para o seminário " + seminario.getTitulo() + ":");
            for (int i = 0; i < listaProfessores.size(); i++) {
                System.out.println((i + 1) + ". " + listaProfessores.get(i).getNome() + " - " + listaProfessores.get(i).getEspecialidade());
            }
            int professorIndex = scanner.nextInt() - 1;
            scanner.nextLine();
            if (professorIndex >= 0 && professorIndex < listaProfessores.size()) {
                Professor professor = listaProfessores.get(professorIndex);
                seminario.setProfessorDoCurso(professor);
            } else {
                System.out.println("Opção inválida. Escolha um número válido.");
            }
        }

        do {
            System.out.println("Escolha um seminário para cadastrar alunos:");
            for (int i = 0; i < listaSeminarios.size(); i++) {
                System.out.println((i + 1) + ". " + listaSeminarios.get(i).getTitulo());
            }
            int seminarioIndex = scanner.nextInt() - 1;
            scanner.nextLine();

            if (seminarioIndex >= 0 && seminarioIndex < listaSeminarios.size()) {
                Seminario seminario = listaSeminarios.get(seminarioIndex);
                char continuar;
                do {
                    System.out.println("Digite o nome do aluno:");
                    String nomeAluno = scanner.nextLine();

                    System.out.println("Digite a idade do aluno:");
                    int idadeAluno = scanner.nextInt();
                    scanner.nextLine();

                    Aluno aluno = new Aluno(nomeAluno, idadeAluno, seminario);
                    seminario.addAluno(aluno);
                    aluno.print();
                    System.out.println("__________");

                    System.out.println("Deseja cadastrar outro aluno neste seminário? (s/n)");
                    continuar = scanner.nextLine().charAt(0);
                } while (continuar == 's' || continuar == 'S');
            } else {
                System.out.println("Opção inválida. Escolha um número válido.");
            }

            System.out.println("Deseja cadastrar alunos em outro seminário? (s/n)");
            char cadastrarOutro = scanner.nextLine().charAt(0);
            if (cadastrarOutro == 'n' || cadastrarOutro == 'N') {
                break;
            }
        } while (true);

        for (Seminario seminario : listaSeminarios) {
            seminario.print();
        }
        scanner.close();
    }
}
