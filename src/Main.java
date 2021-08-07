import jdk.jshell.execution.LocalExecutionControl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;


public class Main {
    public static void main(String[] args) {
//        first task
        returnDurationOfLessons();
//        second task
        returnTimeOfLection();
//        third task
        returnDateFromString("1999/Jun/18 07:34:56 PM");
//        fourth task
        System.out.println(returnStringFromDate(LocalDateTime.of(2001, 01, 15, 23, 56)));
//        fifth task
        calculateMinutesFromDate();

    }

    //    method for first task
//    long days = date1.until(date2, ChronoUnit.DAYS);
    public static void returnDurationOfLessons() {
        LocalDateTime startTime = LocalDateTime.of(2021, 8, 02, 20, 00);
        LocalDateTime endTime = LocalDateTime.of(2021, 8, 07, 16, 00);
        long days = startTime.until(endTime, ChronoUnit.DAYS);
        long hours = startTime.until(endTime, ChronoUnit.HOURS);
        long minutes = startTime.until(endTime, ChronoUnit.MINUTES);
        long seconds = startTime.until(endTime, ChronoUnit.SECONDS);
        System.out.println("С понедельника " + days + " по субботу " + hours + " прошло " + minutes + " дня/ " + seconds + " часов/ " + minutes + " минут/ " + seconds + " секунд ");
    }

    //    method for second task
    public static void returnTimeOfLection() {
        Duration duration = Duration.ofHours(2);
        System.out.println("In the lection " + duration.toMinutes() + " minutes or " + duration.toSeconds() + " seconds");
    }

    //    method for third task
    public static void returnDateFromString(String line) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MMM/dd hh:mm:ss a", Locale.ENGLISH);
        LocalDateTime date = LocalDateTime.parse(line, formatter);
        System.out.println(date);
    }

    //method for fourth task
    public static String returnStringFromDate(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm yyyy/MM/dd");
        return date.format(formatter);
    }

    //    method for fifth task
    public static void calculateMinutesFromDate() {
        String[] months = new String[]{"Spring", "Summer", "Autumn"};
        LocalDateTime start = LocalDateTime.of(1965, 01, 01, 00, 00);
        LocalDateTime end = start.plusMonths(2);
        Duration firstPartWinter = Duration.between(start, end);
        for (String month : months) {
            start = end;
            end = end.plusMonths(3);
            System.out.println(month + " " + Duration.between(start, end).toMinutes());
        }
        Duration winter = firstPartWinter.plus(Duration.between(end, end.plusMonths(1)));
        System.out.println("Winter " + winter.toMinutes());

    }


}
