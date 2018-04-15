package business;

public class Client {
    private String nome;
    private String cpf;
    private int idade;
    private Gender genero;

    public Client(String nome, String cpf, int idade, Gender genero) {
        this.nome = nome;
        this.genero = genero;;
        setCpf(cpf);
        setIdade(idade);
    }

    private void setIdade(int idade) {
        this.idade = idade >= 18 ? idade : 0;
    }

    public String getNome() {
        return nome;
    }

    private void setCpf(String cpf) {
        this.cpf = cpf.length() == 11 ? cpf : null;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public Gender getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return  "Nome: '" + nome + '\'' +
                ", CPF: '" + cpf + '\'' +
                ", Idade: " + idade +
                ", Gênero: " + genero;
    }
}
