package tests;

import business.Bar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import business.Cliente;

import static org.junit.jupiter.api.Assertions.*;

public class BarTest {
    private static Bar bar;

    @BeforeEach
    public void setUp() {
        bar = new Bar();
    }

    @Test
    public void quantidadeClientes() {
        bar.addCliente(new Cliente("Celso", "12345678901", 63, 'H'));
        assertEquals(1, bar.quantidadeClientes());
        bar.addCliente(new Cliente("Jorge", "22345678902", 63, 'H'));
        assertEquals(2, bar.quantidadeClientes());
        bar.addCliente(new Cliente("Marcia", "32345678903", 63, 'M'));
        assertEquals(3, bar.quantidadeClientes());
        bar.removeCliente("32345678903");
        assertEquals(2, bar.quantidadeClientes());
    }

    @Test
    public void testeClientesCpfExistente(){
        String cpf = "12345678901";
        bar.addCliente(new Cliente("Celso", cpf, 63, 'H'));

        Cliente cliente = bar.consultaCliente(cpf);
        assertTrue(cliente != null);
    }

    @Test
    public void testeClientesCpfInexistente(){
        String cpf = "12345678901";
        bar.addCliente(new Cliente("Celso", cpf, 63, 'H'));

        Cliente cliente = bar.consultaCliente("00000000000");

        assertTrue(cliente == null);
    }

    @Test
    public void testePercentualGeneroHomogenioMasculino() {
        bar.addCliente(new Cliente("Celso", "12345678901", 63, 'H'));
        bar.addCliente(new Cliente("Jorge", "22345678902", 63, 'H'));
        double[] percentual = bar.percentualGenero();
        assertEquals(0, percentual[0]);
        assertEquals(1, percentual[1]);
    }

    @Test
    public void testePercentualGeneroHomogenioFeminino() {
        bar.addCliente(new Cliente("Maria", "12345678901", 63, 'M'));
        bar.addCliente(new Cliente("Carla", "22345678902", 63, 'M'));
        double[] percentual = bar.percentualGenero();
        assertEquals(1, percentual[0]);
        assertEquals(0, percentual[1]);
    }

    @Test
    public void testePercentualGeneroIgualmenteDividido() {
        bar.addCliente(new Cliente("Jorge", "12345678901", 63, 'H'));
        bar.addCliente(new Cliente("Carla", "22345678902", 63, 'M'));

        double[] percentual = bar.percentualGenero();
        assertEquals(0.5, percentual[0]);
        assertEquals(0.5, percentual[1]);
    }

    @Test
    public void testePercentualSocio(){
        //bar.percentualSocio()
    }

    @Test
    public void testeRemoveCliente(){
        //bar.removeCliente()
    }

    @Test
    public void testeContemCpf(){
        //bar.contemCpf(cpf)
    }
}