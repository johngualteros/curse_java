package date_local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) throws Exception {
        //Dates
        //Before
        Calendar c= Calendar.getInstance();
        c.set(2022,Calendar.JANUARY,1);
        //After
        LocalDate date= LocalDate.of(2022, Month.APRIL,1); //can't be mutable
        System.out.println(date);
        //Times
        LocalTime time=LocalTime.of(6,45,20);
        System.out.println(time);
        //Date Time
        LocalDateTime dateTime= LocalDateTime.of(date,time);
        LocalDateTime dateTime2= LocalDateTime.of(2022,4,2,7,30,20);
        System.out.println(dateTime);

        LocalDateTime lastWeek= dateTime.minusDays(7);
        System.out.println(lastWeek);

        //format
        String dateFormatted=dateTime.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(dateFormatted);
    }
}
