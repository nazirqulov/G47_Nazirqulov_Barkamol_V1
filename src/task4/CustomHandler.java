package task4;

import java.time.Duration;
import java.time.LocalDate;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class CustomHandler extends Handler {
    @Override
    public void publish(LogRecord record) {
        LocalDate localDate=LocalDate.now();
        System.out.println(localDate.getYear()+"."+localDate.getMonth().getValue()+"."+localDate.getDayOfWeek().getValue()+"."+record.getLevel());
    }

    @Override
    public void flush() {

    }

    @Override
    public void close() throws SecurityException {

    }
}
