package task4;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.Duration;
import java.time.LocalDate;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        StringBuilder sb = new StringBuilder();
       LocalDate localDate=LocalDate.now();
        sb.append(localDate.getDayOfWeek().getValue()).append(".").append(localDate.getMonth()).append(".").append(localDate.getYear()).append(record.getLevel()).append(": ").append(record.getMessage()).append("\n");
        if (record.getThrown() != null) {
            sb.append("Exception:\n");
            StringWriter sw = new StringWriter();
            record.getThrown().printStackTrace(new PrintWriter(sw));
            sb.append(sw.toString());
        }

        return sb.toString();
    }
}
