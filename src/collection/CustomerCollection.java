package collection;

import business.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerCollection {
    private Map<String, Customer> customers;

    public CustomerCollection() {
        this.customers = new HashMap<>(10);
    }

    public Collection<Customer> getAll() {
        return customers.values();
    }

    public Customer getByCPF(String cpf) {
        if (customers.containsKey(cpf)) {
            return customers.get(cpf);
        }

        return null;
    }

    public int count() {
        return customers.size();
    }

    public GenderTuple genderRate() {
        double m = 0;
        double f = 0;

        if (customers.isEmpty()) {
            return new GenderTuple(0, 0);
        }

        for (Map.Entry<String, Customer> customer : customers.entrySet()) {
            if (customer.getValue().getGender() == Gender.MALE) {
                m++;
            } else if (customer.getValue().getGender() == Gender.FEMALE) {
                f++;
            }
        }
        return new GenderTuple(m / customers.size(), f / customers.size());
    }

    public MembershipTuple membershipRate() {
        double registered = 0;
        double unregistered = 0;

        if (customers.isEmpty()) {
            return new MembershipTuple(0.0, 0.0);
        }

        for (Map.Entry<String, Customer> entry : customers.entrySet()) {
            if (entry.getValue() instanceof Member) {
                registered++;
            } else {
                unregistered++;
            }
        }

        return new MembershipTuple(registered / customers.size(), unregistered / customers.size());
    }

    public void put(Customer customer) {
        if (!customers.containsKey(customer.getCpf())) {
            customers.put(customer.getCpf(), customer);
        }
    }

    public Customer remove(String cpf) {
        if (!customers.containsKey(cpf)) {
            return null;
        }

        Customer customer = customers.remove(cpf);

        return customer;
    }

    public boolean hasCPF(String cpf) {
        return customers.containsKey(cpf);
    }
}
