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
    private CustomerCollection customers;


    public Bar() {
        this.customers = new CustomerCollection();
        this.accessRecords = new AccessRecordCollection();
    }

    public Collection<Customer> queryCustomers() {
        return customers.getAll();
    }

    public Customer queryCustomer(String cpf) {
        return customers.getByCPF(cpf);
    }

    public int countCustomers() {
        return customers.count();
    }

    public GenderTuple getGenderRate() {
        return customers.genderRate();
    }

    public MembershipTuple getMembershipRate() {
        return customers.membershipRate();
    }

    public void addCustomer(Customer customer) {
        customers.put(customer);
    }

    public Customer removeCustomer(String cpf) {
        Customer customer = customers.remove(cpf);

        accessRecords.put(new Date(), customer);

        return customer;
    }

    public boolean customerExists(String cpf) {
        return customers.hasCPF(cpf);
    }

    public void close() throws Exception {
        if (countCustomers() > 0) {
            throw new Exception("Não foi possível fechar o bar pois ainda há customers dentro!");
        }

        Report report = new Report(new FileTitleFormatter(), new AccessRecordFormatter(), "records");
        report.write(accessRecords);

        Platform.exit();
    }
}
