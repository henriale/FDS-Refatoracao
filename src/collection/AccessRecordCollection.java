package collection;

import business.Client;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AccessRecordCollection {
    private HashMap<Date, Client> records;

    public AccessRecordCollection() {
        records = new HashMap<>();
    }

    public AccessRecordCollection put(Date date, Client customer) {
        records.put(date, customer);

        return this;
    }

    public Set<Map.Entry<Date, Client>> getAll() {
        return records.entrySet();
    }
}
