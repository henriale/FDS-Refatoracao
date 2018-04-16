package tests;

import business.Customer;
import business.Gender;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {
    @Test
    public void testGenderCorrectness() {
        Customer customer = new Customer("Henrique", "14554609234", 30, Gender.MALE);
        //assert não funciona com Character
        assertEquals(Gender.MALE, customer.getGender());
    }

    @Test
    public void testAge() {
        Customer customer = new Customer("Vanessa", "14325654344", 20, Gender.FEMALE);
        assertEquals(20, customer.getAge());
    }

    @Test
    public void testName() {
        Customer customer = new Customer("Gabriel", "13223143212", 33, Gender.MALE);
        assertEquals("Gabriel", customer.getName());
    }

    @Test
    public void testAgedLessThan18() {
        Customer customer = new Customer("Paula", "54663348909", 16, Gender.MALE);
        assertEquals(0, customer.getAge());
    }

    @Test
    public void testInvalidCPF() {
        Customer customer = new Customer("Ariel", "6243254", 30, Gender.MALE);
        assertEquals(null, customer.getCpf());
    }
}