package formatter;

import java.text.SimpleDateFormat;

public class AccessRecordFormatter extends SimpleDateFormat {
    public AccessRecordFormatter() {
        super("dd/MM/yyyy hh:mm");
    }
}
