package business;

import javafx.application.Platform;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Bar {
    private Map<String, Client> clientes;
    private Map<Date, Client> accessRecords;

    public Bar() {
        this.clientes = new HashMap<>(10);
        this.accessRecords = new HashMap<>(10);
    }

    public Collection<Client> consultaClientes(){
        return clientes.values();
    }

    public Client consultaCliente(String cpf) {
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

        for (Map.Entry<String, Client> cliente : clientes.entrySet()) {
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

        for (Map.Entry<String, Client> entry : clientes.entrySet()) {
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

    public void addCliente(Client client) {
        if (!clientes.containsKey(client.getCpf())) {
            clientes.put(client.getCpf(), client);
        }

    }

    public Client removeCliente(String cpf){
        if (clientes.containsKey(cpf)) {
            return clientes.remove(cpf);
        }

        Client cliente = clientes.remove(cpf);
        accessRecords.put(new Date(), cliente);

        return cliente;
    }

    public boolean contemCpf(String cpf) {
        return clientes.containsKey(cpf);
    }

    public void fechar() throws Exception {
        if (quantidadeClientes() > 0) {
            throw new Exception("Não foi possível fechar o bar pois ainda há clientes dentro!");
        }

        for (Map.Entry<Date, Client> entry : accessRecords.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getCpf());
        }

        Platform.exit();
    }
}
