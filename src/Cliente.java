public class Cliente {
    private String nome;
    private String cpf;
    private int idade;
    private Character genero;

    public Cliente(String nome, String cpf, int idade, Character genero) {
        this.nome = nome;
        this.cpf = cpf;
        this.genero = genero;
        setIdade(idade);
    }

    public void setIdade(int idade) {
        if (idade < 18) {
            this.idade = idade;
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public Character getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", idade=" + idade +
                ", genero=" + genero +
                '}';
    }
}
