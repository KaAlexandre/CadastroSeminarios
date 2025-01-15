package domain;

public class Professor {
    private String nome;
    private String especialidade;
    private Seminario[] seminarios;
    private Seminario seminario;

    public Professor(String nome) {
        this.nome = nome;
    }

    public Professor(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public Professor(String nome, String especialidade, Seminario[] seminarios) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.seminarios = seminarios;
    }

    public Professor(String nome, String especialidade, Seminario seminario) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.seminario = seminario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Seminario[] getSeminarios() {
        return seminarios;
    }

    public void setSeminarios(Seminario[] seminarios) {
        this.seminarios = seminarios;
    }

    public void print() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Especialidade: " + this.especialidade);
    }
}
