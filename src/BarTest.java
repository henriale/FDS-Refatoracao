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
    public void quantidadeClientes(){
        bar.addCliente(new Cliente("Celso", "12345678901", 63, 'H'));
        assertEquals(1, bar.quantidadeClientes());
    }

    @Test
    public void testeClientes(){
        //bar.consultaClientes()
    }

    @Test
    public void testeClientesCpf(){
        //bar.consultaClientes(cpf)
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