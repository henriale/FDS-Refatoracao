package collection;

import business.Customer;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AccessRecordCollection {
    private HashMap<Date, Customer> records;

    public AccessRecordCollection() {
        records = new HashMap<>();
    }

    public AccessRecordCollection put(Date date, Customer customer) {
        records.put(date, customer);

        return this;
    }

    public Set<Map.Entry<Date, Customer>> getAll() {
        return records.entrySet();
    }
}
