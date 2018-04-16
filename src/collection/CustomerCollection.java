package collection;

import business.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerCollection {
    private Map<String, Client> clientes;

    public CustomerCollection() {
        this.clientes = new HashMap<>(10);
    }

    public Collection<Client> consultaClientes() {
        return clientes.values();
    }

    public Client consultaCliente(String cpf) {
        if (clientes.containsKey(cpf)) {
            return clientes.get(cpf);
        }

        return null;
    }

    public int quantidadeClientes() {
        return clientes.size();
    }

    public GenderTuple percentualGenero() {
        double m = 0;
        double f = 0;

        if (clientes.isEmpty()) {
            return new GenderTuple(0, 0);
        }

        for (Map.Entry<String, Client> cliente : clientes.entrySet()) {
            if (cliente.getValue().getGenero() == Gender.MALE) {
                m++;
            } else if (cliente.getValue().getGenero() == Gender.FEMALE) {
                f++;
            }
        }
        return new GenderTuple(m / clientes.size(), f / clientes.size());
    }

    public MembershipTuple percentualSocios() {
        double socio = 0;
        double naoSocio = 0;
        double[] retorno = new double[2];

        if (clientes.isEmpty()) {
            return new MembershipTuple(0.0, 0.0);
        }

        for (Map.Entry<String, Client> entry : clientes.entrySet()) {
            if (entry.getValue() instanceof Socio) {
                socio++;
            } else {
                naoSocio++;
            }
        }

        return new MembershipTuple(socio / clientes.size(), naoSocio / clientes.size());
    }

    public void addCliente(Client client) {
        if (!clientes.containsKey(client.getCpf())) {
            clientes.put(client.getCpf(), client);
        }
    }

    public Client removeCliente(String cpf) {
        if (!clientes.containsKey(cpf)) {
            return null;
        }

        Client cliente = clientes.remove(cpf);

        return cliente;
    }

    public boolean contemCpf(String cpf) {
        return clientes.containsKey(cpf);
    }
}
