package business;

import collection.AccessRecordCollection;
import collection.CustomerCollection;
import formatter.AccessRecordFormatter;
import formatter.FileTitleFormatter;
import javafx.application.Platform;
import persistence.Report;

import java.util.Collection;
import java.util.Date;

public class Bar {
    private AccessRecordCollection accessRecords;
    private CustomerCollection clientes;


    public Bar() {
        this.clientes = new CustomerCollection();
        this.accessRecords = new AccessRecordCollection();
    }

    public Collection<Client> consultaClientes() {
        return clientes.consultaClientes();
    }

    public Client consultaCliente(String cpf) {
        return clientes.consultaCliente(cpf);
    }

    public int quantidadeClientes() {
        return clientes.quantidadeClientes();
    }

    public GenderTuple percentualGenero() {
        return clientes.percentualGenero();
    }

    public MembershipTuple percentualSocios() {
        return clientes.percentualSocios();
    }

    public void addCliente(Client client) {
        clientes.addCliente(client);
    }

    public Client removeCliente(String cpf) {
        Client cliente = clientes.removeCliente(cpf);

        accessRecords.put(new Date(), cliente);

        return cliente;
    }

    public boolean contemCpf(String cpf) {
        return clientes.contemCpf(cpf);
    }

    public void fechar() throws Exception {
        if (quantidadeClientes() > 0) {
            throw new Exception("Não foi possível fechar o bar pois ainda há clientes dentro!");
        }

        Report report = new Report(new FileTitleFormatter(), new AccessRecordFormatter(), "records");
        report.write(accessRecords);

        Platform.exit();
    }
}
