package task2;

import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class WorkDays {
    public static void main(String[] args) {

        LocalDate startDate = LocalDate.of(2020, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 9, 1);

        ExecutorService executor = Executors.newFixedThreadPool(1);
        AtomicInteger workDays = new AtomicInteger();
        for (int year = startDate.getYear(); year < endDate.getYear(); year++) {
            int finalYear = year;
            executor.execute(() -> {
                for (LocalDate date = LocalDate.of(finalYear, 1, 1);
                     date.getYear() == finalYear; date = date.plusDays(1)) {

                    if (date.getDayOfWeek().getValue() >= 1 && date.getDayOfWeek().getValue() <= 5) {
                        workDays.addAndGet(8);
                    }
                    if (date.getDayOfWeek().getValue()==6){
                        workDays.addAndGet(4);
                    }
                }

            });
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Ish soati:"+workDays);
    }
}
