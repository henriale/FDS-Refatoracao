package formatter;

import java.text.SimpleDateFormat;

public class FileTitleFormatter extends SimpleDateFormat {
    public FileTitleFormatter() {
        super("yyyy-MM-dd-hhmm");
    }
}
