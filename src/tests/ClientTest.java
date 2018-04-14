package tests;

import business.Client;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientTest {
    @Test
    public void criarCliente() {
        Client client = new Client("Maria", "12345678901", 21, 'M');
    }

    @Test
    public void testeGeneroErrado(){
        Client client = new Client("Carlos", "12332112332", 23, 'F');
        assertEquals(null, client.getGenero());
    }

    @Test
    public void testeGeneroCorreto(){
        Client client = new Client("Henrique", "14554609234", 30, 'H');
        //assert não funciona com Character
        assertEquals("H", client.getGenero().toString());
    }

    @Test
    public void testeIdade(){
        Client client = new Client("Vanessa", "14325654344", 20, 'M');
        assertEquals(20, client.getIdade());
    }

    @Test
    public void testeNome(){
        Client client = new Client("Gabriel", "13223143212", 33, 'H');
        assertEquals("Gabriel", client.getNome());
    }

    @Test
    public void testeIdadeMenor18(){
        Client client = new Client("Paula", "54663348909", 16, 'H');
        assertEquals(0, client.getIdade());
    }

    @Test
    public void testeCpfIncorreto(){
        Client client = new Client("Ariel", "6243254", 30, 'H');
        assertEquals(null, client.getCpf());
    }
}