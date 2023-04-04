package eaj.pessoa;


public class Pessoa {
    private int id;
    
    private String nome; 
    private int idade;

    
    public Pessoa(int id, String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }



    public Pessoa(){

    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
