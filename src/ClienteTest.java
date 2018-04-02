import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {
    @Test
    public void criarCliente() {
        Cliente cliente = new Cliente("Maria", "12345678901", 21, 'M');
    }

    @Test
    public void testeGeneroErrado(){
        Cliente cliente = new Cliente("Carlos", "12332112332", 23, 'F');
        assertEquals(null, cliente.getGenero());
    }

    @Test
    public void testeGeneroCorreto(){
        Cliente cliente = new Cliente("Henrique", "14554609234", 30, 'H');
        //assert não funciona com Character
        assertEquals("H", cliente.getGenero().toString());
    }

    @Test
    public void testeIdade(){
        Cliente cliente = new Cliente("Vanessa", "14325654344", 20, 'M');
        assertEquals(20, cliente.getIdade());
    }

    @Test
    public void testeNome(){
        Cliente cliente = new Cliente("Gabriel", "13223143212", 33, 'H');
        assertEquals("Gabriel", cliente.getNome());
    }

    @Test
    public void testeIdadeMenor18(){
        Cliente cliente = new Cliente("Paula", "54663348909", 16, 'H');
        assertEquals(0, cliente.getIdade());
    }

    @Test
    public void testeCpfIncorreto(){
        Cliente cliente = new Cliente("Ariel", "6243254", 30, 'H');
        assertEquals(null, cliente.getCpf());
    }
}