package tests;

import business.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BarTest {
    private static Bar bar;

    @BeforeEach
    public void setUp() {
        bar = new Bar();
    }

    @Test
    public void quantidadeClientes() {
        bar.addCliente(new Client("Celso", "12345678901", 63, Gender.MALE));
        assertEquals(1, bar.quantidadeClientes());
        bar.addCliente(new Client("Jorge", "22345678902", 63, Gender.MALE));
        assertEquals(2, bar.quantidadeClientes());
        bar.addCliente(new Client("Marcia", "32345678903", 63, Gender.FEMALE));
        assertEquals(3, bar.quantidadeClientes());
        bar.removeCliente("32345678903");
        assertEquals(2, bar.quantidadeClientes());
    }

    @Test
    public void testeClientesCpfExistente() {
        String cpf = "12345678901";
        bar.addCliente(new Client("Celso", cpf, 63, Gender.MALE));

        Client client = bar.consultaCliente(cpf);
        assertTrue(client != null);
    }

    @Test
    public void testeClientesCpfInexistente() {
        String cpf = "12345678901";
        bar.addCliente(new Client("Celso", cpf, 63, Gender.MALE));

        Client client = bar.consultaCliente("00000000000");

        assertTrue(client == null);
    }

    @Test
    public void testePercentualGeneroHomogenioMasculino() {
        bar.addCliente(new Client("Celso", "12345678901", 63, Gender.MALE));
        bar.addCliente(new Client("Jorge", "22345678902", 63, Gender.MALE));

        GenderTuple percentage = bar.percentualGenero();

        assertEquals(1.0, percentage.getMale());
        assertEquals(0.0, percentage.getFemale());
    }

    @Test
    public void testePercentualGeneroHomogenioFeminino() {
        bar.addCliente(new Client("Maria", "12345678901", 63, Gender.FEMALE));
        bar.addCliente(new Client("Carla", "22345678902", 63, Gender.FEMALE));

        GenderTuple percentage = bar.percentualGenero();

        assertEquals(0.0, percentage.getMale());
        assertEquals(1.0, percentage.getFemale());
    }

    @Test
    public void testePercentualGeneroIgualmenteDividido() {
        bar.addCliente(new Client("Jorge", "12345678901", 63, Gender.MALE));
        bar.addCliente(new Client("Carla", "22345678902", 63, Gender.FEMALE));

        GenderTuple percentage = bar.percentualGenero();
        assertEquals(0.5, percentage.getMale());
        assertEquals(0.5, percentage.getFemale());
    }

    @Test
    public void testePercentualSocio() {
        bar.addCliente(new Client("Jorge", "12345678901", 63, Gender.MALE));
        bar.addCliente(new Socio("Carla", "22345678902", 63, Gender.FEMALE, "12312311"));

        MembershipTuple percentage = bar.percentualSocios();
        assertEquals(0.5, percentage.getRegistered());
        assertEquals(0.5, percentage.getUnregistered());
    }

    @Test
    public void testeRemoveCliente() {
        String cpf = "12345678901";
        bar.addCliente(new Socio("Carla", cpf, 63, Gender.FEMALE, "12312311"));

        Client client = bar.removeCliente(cpf);

        assertEquals(0, bar.quantidadeClientes());
        assertEquals(cpf, client.getCpf());
    }

    @Test
    public void testeContemCpf() {
        String cpf = "12345678901";
        bar.addCliente(new Socio("Carla", cpf, 63, Gender.FEMALE, "12312311"));

        assertTrue(bar.contemCpf(cpf));
    }

    @Test
    public void testeFecharBar() {
        bar.addCliente(new Socio("Carla", "12345678901", 63, Gender.FEMALE, "12312311"));
        bar.removeCliente("12345678901");

        try {
            bar.fechar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}