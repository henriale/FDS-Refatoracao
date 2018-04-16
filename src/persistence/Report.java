package persistence;

import business.Customer;
import collection.AccessRecordCollection;
import formatter.AccessRecordFormatter;
import formatter.FileTitleFormatter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

public class Report {
    private FileTitleFormatter fileTitleFormatter;
    private AccessRecordFormatter accessRecordFormatter;
    private FileWriter fileWriter;

    public Report(FileTitleFormatter fileTitleFormatter, AccessRecordFormatter accessRecordFormatter, String path) throws IOException {
        this.fileTitleFormatter = fileTitleFormatter;
        this.accessRecordFormatter = accessRecordFormatter;
        this.setFileWriter(path);
    }

    private void setFileWriter(String path) throws IOException {
        // check if file already exists
        if (true) {
            // TODO
        }

        this.fileWriter = new FileWriter(String.format(
                "%s/%s.txt",
                path,
                fileTitleFormatter.format(new Date())
        ));
    }

    public void write(AccessRecordCollection accessRecords) throws IOException {
        for (Map.Entry<Date, Customer> entry : accessRecords.getAll()) {
            Customer customer = entry.getValue();
            fileWriter.write(String.format(
                    "%s Customer %s(%s) left the bar.\n",
                    accessRecordFormatter.format(entry.getKey()),
                    customer.getName(),
                    customer.getCpf()
            ));
        }

        fileWriter.close();
    }
}
