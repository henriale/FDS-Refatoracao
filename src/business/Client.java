package business;

public class Client {
    private String nome;
    private String cpf;
    private int idade;
    private Gender genero;

    public Client(String nome, String cpf, int idade, Gender genero) {
        this.nome = nome;
        this.genero = genero;
        ;
        setCpf(cpf);
        setIdade(idade);
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    private void setCpf(String cpf) {
        this.cpf = cpf.length() == 11 ? cpf : null;
    }

    public int getIdade() {
        return idade;
    }

    private void setIdade(int idade) {
        this.idade = idade >= 18 ? idade : 0;
    }

    public Gender getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return "Nome: '" + nome + '\'' +
                ", CPF: '" + cpf + '\'' +
                ", Idade: " + idade +
                ", Gênero: " + genero;
    }
}
