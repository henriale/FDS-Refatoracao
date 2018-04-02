public class Cliente {
    private String nome;
    private String cpf;
    private int idade;
    private Character genero;

    public Cliente(String nome, String cpf, int idade, Character genero) {
        this.nome = nome;
        setCpf(cpf);
        setGenero(genero);
        setIdade(idade);
    }

    private void setIdade(int idade) {
        this.idade = idade >= 18 ? idade : 0;
    }

    private void setGenero(Character genero) {
        this.genero = genero.equals('M') || genero.equals('H') ? genero : null;
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
