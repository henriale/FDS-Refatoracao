package business;

public class Socio extends Client {
    private String numero;

    public Socio(String nome, String cpf, int idade, char genero, String numero) {
        super(nome, cpf, idade, genero);
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return  "Nome: '" + getNome() + '\'' +
                ", CPF: '" + getCpf() + '\'' +
                ", Idade: " + getIdade() +
                ", Gênero: " + getGenero() +
                ", Nº sócio: " + numero;
    }
}
