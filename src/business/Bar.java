package business;

import javafx.application.Platform;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Bar {
    private final HashMap<Date, Client> accessRecords;
    private Map<String, Client> clientes;


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
            if (cliente.getValue().getGenero() == Gender.MALE) {
                m++;
            } else if (cliente.getValue().getGenero() == Gender.FEMALE) {
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
        if (! clientes.containsKey(cpf)) {
            return null;
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

        try {
            // create formatters and file writer. constructor(FileTitleFormatter, AccessRecordFormatter, AccessRecordsCollection, path)
            SimpleDateFormat fileDateFormatter = new SimpleDateFormat("yyyy-MM-dd-hhmm");
            SimpleDateFormat recordDateFormatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            FileWriter fw = new FileWriter(String.format("records/%s.txt", fileDateFormatter.format(new Date())));

            // check if file already exists
            if (true) {
                // TODO
            }

            // write in file
            for (Map.Entry<Date, Client> entry : accessRecords.entrySet()) {
                Client cliente = entry.getValue();
                fw.write(String.format(
                        "%s Client %s(%s) left the bar.\n",
                        recordDateFormatter.format(entry.getKey()),
                        cliente.getNome(),
                        cliente.getCpf()
                ));
            }

            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Platform.exit();
    }
}
