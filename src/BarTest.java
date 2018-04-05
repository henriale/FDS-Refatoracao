import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class BarTest {
    private static Bar bar;

    @BeforeEach
    public void setUp() {
        bar = new Bar();
    }

    @Test
    public void quantidadeClientes(){
        bar.addCliente(new Cliente("Celso", "12345678901", 63, 'H'));
        assertEquals(1, bar.quantidadeClientes());
    }

    @Test
    public void testeClientes(){
        Collection<Cliente> clientes = bar.consultaClientes();

        assertFalse(clientes.isEmpty());
        assertEquals(1, clientes.size());
        clientes.add(new Cliente("Doria", "02820102910", 40, 'F'));
        assertEquals(2, clientes.size());
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
    public void testePercentualGenero(){
        //bar.percentualGenero()
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