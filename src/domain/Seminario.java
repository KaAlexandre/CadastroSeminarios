package domain;

public class Seminario {
    private String titulo;
    private Aluno[] alunos;
    private String endereco;
    private Professor professorDoCurso;


    public Seminario(String titulo) {
        this.titulo = titulo;
    }

    public Seminario(String titulo, Professor professorDoCurso) {
        this.titulo = titulo;
        this.professorDoCurso = professorDoCurso;
    }

    public Seminario(String titulo, Aluno[] alunos) {
        this.titulo = titulo;
        this.alunos = alunos;
    }

    public Seminario(String titulo, Aluno[] alunos, String endereco, Professor professorDoCurso) {
        this.titulo = titulo;
        this.alunos = alunos;
        this.endereco = endereco;
        this.professorDoCurso = professorDoCurso;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Aluno[] getAlunos() {
        return alunos;
    }

    public void setAlunos(Aluno[] alunos) {
        this.alunos = alunos;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public Professor getProfessorDoCurso() {
        return professorDoCurso;
    }

    public void setProfessorDoCurso(Professor professorDoCurso) {
        this.professorDoCurso = professorDoCurso;
    }

    public void print() {
        System.out.println("Título: " + this.titulo);
        System.out.println("Endereço: " + this.endereco);
        if (professorDoCurso != null) {
            System.out.println("Professor: " + professorDoCurso.getNome());
        }
        if (alunos != null && alunos.length > 0) {
            System.out.print("Alunos: ");
            for (Aluno aluno : alunos) {
                System.out.println(aluno.getName());
            }

            }
        System.out.println("____________");
        }
    public void addAluno(Aluno aluno) {
        if (this.alunos == null) {
            this.alunos = new Aluno[1];
            this.alunos[0] = aluno;
        } else {
            Aluno[] newAlunos = new Aluno[this.alunos.length + 1];
            System.arraycopy(this.alunos, 0, newAlunos, 0, this.alunos.length);
            newAlunos[this.alunos.length] = aluno;
            this.alunos = newAlunos;
        }
    }

}
