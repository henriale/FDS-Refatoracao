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
    public void testCustomerCount() {
        bar.addCustomer(new Customer("Celso", "12345678901", 63, Gender.MALE));
        assertEquals(1, bar.countCustomers());
        bar.addCustomer(new Customer("Jorge", "22345678902", 63, Gender.MALE));
        assertEquals(2, bar.countCustomers());
        bar.addCustomer(new Customer("Marcia", "32345678903", 63, Gender.FEMALE));
        assertEquals(3, bar.countCustomers());
        bar.removeCustomer("32345678903");
        assertEquals(2, bar.countCustomers());
    }

    @Test
    public void testExistingCPF() {
        String cpf = "12345678901";
        bar.addCustomer(new Customer("Celso", cpf, 63, Gender.MALE));

        Customer customer = bar.queryCustomer(cpf);
        assertTrue(customer != null);
    }

    @Test
    public void testUnexistentCPF() {
        String cpf = "12345678901";
        bar.addCustomer(new Customer("Celso", cpf, 63, Gender.MALE));

        Customer customer = bar.queryCustomer("00000000000");

        assertTrue(customer == null);
    }

    @Test
    // testPercentageOfOnlyMaleGender
    public void testPercentageOfOnlyMaleGender() {
        bar.addCustomer(new Customer("Celso", "12345678901", 63, Gender.MALE));
        bar.addCustomer(new Customer("Jorge", "22345678902", 63, Gender.MALE));

        GenderTuple percentage = bar.getGenderRate();

        assertEquals(1.0, percentage.getMale());
        assertEquals(0.0, percentage.getFemale());
    }

    @Test
    public void testPercentageOfOnlyFemaleGender() {
        bar.addCustomer(new Customer("Maria", "12345678901", 63, Gender.FEMALE));
        bar.addCustomer(new Customer("Carla", "22345678902", 63, Gender.FEMALE));

        GenderTuple percentage = bar.getGenderRate();

        assertEquals(0.0, percentage.getMale());
        assertEquals(1.0, percentage.getFemale());
    }

    @Test
    public void testPercentageOfEquallyDistributedGender() {
        bar.addCustomer(new Customer("Jorge", "12345678901", 63, Gender.MALE));
        bar.addCustomer(new Customer("Carla", "22345678902", 63, Gender.FEMALE));

        GenderTuple percentage = bar.getGenderRate();
        assertEquals(0.5, percentage.getMale());
        assertEquals(0.5, percentage.getFemale());
    }

    @Test
    public void testMembershipPercentage() {
        bar.addCustomer(new Customer("Jorge", "12345678901", 63, Gender.MALE));
        bar.addCustomer(new Member("Carla", "22345678902", 63, Gender.FEMALE, "12312311"));

        MembershipTuple percentage = bar.getMembershipRate();
        assertEquals(0.5, percentage.getRegistered());
        assertEquals(0.5, percentage.getUnregistered());
    }

    @Test
    public void testRemoveCustomer() {
        String cpf = "12345678901";
        bar.addCustomer(new Member("Carla", cpf, 63, Gender.FEMALE, "12312311"));

        Customer customer = bar.removeCustomer(cpf);

        assertEquals(0, bar.countCustomers());
        assertEquals(cpf, customer.getCpf());
    }

    @Test
    public void testExistentCPF() {
        String cpf = "12345678901";
        bar.addCustomer(new Member("Carla", cpf, 63, Gender.FEMALE, "12312311"));

        assertTrue(bar.customerExists(cpf));
    }

    @Test
    public void testbarClose() {
        bar.addCustomer(new Member("Carla", "12345678901", 63, Gender.FEMALE, "12312311"));
        bar.removeCustomer("12345678901");

        try {
            bar.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}