package business;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Bar {
    private Map<String, Cliente> clientes;

    public Bar() {
        this.clientes = new HashMap<>(10);
    }

    public Collection<Cliente> consultaClientes(){
        return clientes.values();
    }

    public Cliente consultaCliente(String cpf) {
        if (clientes.containsKey(cpf)){
            return clientes.get(cpf);
        }

        return null;
    }

    public int quantidadeClientes() {
        return clientes.size();
    }

    public double[] percentualGenero() {
        double m = 0;
        double f = 0;
        double[] retorno = new double[2];

        if (clientes.isEmpty()) {
            return retorno;
        }

        for (Map.Entry<String, Cliente> cliente : clientes.entrySet()) {
            if (cliente.getValue().getGenero() == 'M') {
                m++;
            } else {
                f++;
            }
        }

        retorno[0] = m/clientes.size();
        retorno[1] = f/clientes.size();

        return retorno;
    }

    public double[] percentualSocios() {
        double socio = 0;
        double naoSocio = 0;
        double[] retorno = new double[2];

        for (Map.Entry<String, Cliente> entry : clientes.entrySet()) {
            if (entry.getValue() instanceof Socio) {
                socio++;
            } else {
                naoSocio++;
            }
        }

        retorno[0] = socio/clientes.size();
        retorno[1] = naoSocio/clientes.size();

        return retorno;
    }

    public void addCliente(Cliente cliente) {
        if (!clientes.containsKey(cliente.getCpf())) {
            clientes.put(cliente.getCpf(), cliente);
        }

    }

    public Cliente removeCliente(String cpf){
        if (clientes.containsKey(cpf)) {
            return clientes.remove(cpf);
        }

        return null;
    }

    public boolean contemCpf(String cpf) {
        return clientes.containsKey(cpf);
    }

    public void fechar() {
        // persist data in file
    }
}
