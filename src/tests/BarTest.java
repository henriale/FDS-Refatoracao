package tests;

import business.Bar;
import business.Client;
import business.Socio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BarTest {
    private static Bar bar;

    @BeforeEach
    public void setUp() {
        bar = new Bar();
    }

    @Test
    public void quantidadeClientes() {
        bar.addCliente(new Client("Celso", "12345678901", 63, 'H'));
        assertEquals(1, bar.quantidadeClientes());
        bar.addCliente(new Client("Jorge", "22345678902", 63, 'H'));
        assertEquals(2, bar.quantidadeClientes());
        bar.addCliente(new Client("Marcia", "32345678903", 63, 'M'));
        assertEquals(3, bar.quantidadeClientes());
        bar.removeCliente("32345678903");
        assertEquals(2, bar.quantidadeClientes());
    }

    @Test
    public void testeClientesCpfExistente(){
        String cpf = "12345678901";
        bar.addCliente(new Client("Celso", cpf, 63, 'H'));

        Client client = bar.consultaCliente(cpf);
        assertTrue(client != null);
    }

    @Test
    public void testeClientesCpfInexistente(){
        String cpf = "12345678901";
        bar.addCliente(new Client("Celso", cpf, 63, 'H'));

        Client client = bar.consultaCliente("00000000000");

        assertTrue(client == null);
    }

    @Test
    public void testePercentualGeneroHomogenioMasculino() {
        bar.addCliente(new Client("Celso", "12345678901", 63, 'H'));
        bar.addCliente(new Client("Jorge", "22345678902", 63, 'H'));
        double[] percentual = bar.percentualGenero();
        assertEquals(0, percentual[0]);
        assertEquals(1, percentual[1]);
    }

    @Test
    public void testePercentualGeneroHomogenioFeminino() {
        bar.addCliente(new Client("Maria", "12345678901", 63, 'M'));
        bar.addCliente(new Client("Carla", "22345678902", 63, 'M'));
        double[] percentual = bar.percentualGenero();
        assertEquals(1, percentual[0]);
        assertEquals(0, percentual[1]);
    }

    @Test
    public void testePercentualGeneroIgualmenteDividido() {
        bar.addCliente(new Client("Jorge", "12345678901", 63, 'H'));
        bar.addCliente(new Client("Carla", "22345678902", 63, 'M'));

        double[] percentual = bar.percentualGenero();
        assertEquals(0.5, percentual[0]);
        assertEquals(0.5, percentual[1]);
    }

    @Test
    public void testePercentualSocio(){
        bar.addCliente(new Client("Jorge", "12345678901", 63, 'H'));
        bar.addCliente(new Socio("Carla", "22345678902", 63, 'M', "12312311"));

        double[] percentual = bar.percentualSocios();
        assertEquals(0.5, percentual[0]);
        assertEquals(0.5, percentual[1]);
    }

    @Test
    public void testeRemoveCliente(){
        String cpf = "12345678901";
        bar.addCliente(new Socio("Carla", cpf, 63, 'M', "12312311"));

        Client client = bar.removeCliente(cpf);

        assertEquals(0, bar.quantidadeClientes());
        assertEquals(cpf, client.getCpf());
    }

    @Test
    public void testeContemCpf(){
        String cpf = "12345678901";
        bar.addCliente(new Socio("Carla", cpf, 63, 'M', "12312311"));

        assertTrue(bar.contemCpf(cpf));
    }

    @Test
    public void testeFecharBar(){
        bar.addCliente(new Socio("Carla", "12345678901", 63, 'M', "12312311"));
        bar.removeCliente("12345678901");

        try {
            bar.fechar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}