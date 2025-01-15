package domain;

public class Aluno {
    private String name;
    private int idade;
    private Seminario seminario;


    public Aluno(String name) {
        this.name = name;
    }

    public Aluno(int idade) {
        this.idade = idade;
    }

    public Aluno(Seminario seminario) {
        this.seminario = seminario;
    }


    public Aluno(String name, int idade, Seminario seminario) {
        this.name = name;
        this.idade = idade;
        this.seminario = seminario;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Seminario getSeminario() {
        return seminario;
    }

    public void setSeminario(Seminario seminario) {
        this.seminario = seminario;
    }

    public void print(){
        System.out.println("Nome: "+this.name);
        System.out.println("Idade: "+this.idade);
        if(seminario!=null){
            System.out.println("Seminário escolhido:"+seminario.getTitulo());
        }
    }

}
