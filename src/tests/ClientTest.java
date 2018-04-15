package tests;

import business.Client;
import business.Gender;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientTest {
    @Test
    public void criarCliente() {
        Client client = new Client("Maria", "12345678901", 21, Gender.FEMALE);
    }

    @Test
    public void testeGeneroCorreto(){
        Client client = new Client("Henrique", "14554609234", 30, Gender.MALE);
        //assert não funciona com Character
        assertEquals(Gender.MALE, client.getGenero());
    }

    @Test
    public void testeIdade(){
        Client client = new Client("Vanessa", "14325654344", 20, Gender.FEMALE);
        assertEquals(20, client.getIdade());
    }

    @Test
    public void testeNome(){
        Client client = new Client("Gabriel", "13223143212", 33, Gender.MALE);
        assertEquals("Gabriel", client.getNome());
    }

    @Test
    public void testeIdadeMenor18(){
        Client client = new Client("Paula", "54663348909", 16, Gender.MALE);
        assertEquals(0, client.getIdade());
    }

    @Test
    public void testeCpfIncorreto(){
        Client client = new Client("Ariel", "6243254", 30, Gender.MALE);
        assertEquals(null, client.getCpf());
    }
}