public class Socio extends Cliente {
    private String numero;

    public Socio(String nome, String cpf, int idade, char genero, String numero) {
        super(nome, cpf, idade, genero);
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }
}
