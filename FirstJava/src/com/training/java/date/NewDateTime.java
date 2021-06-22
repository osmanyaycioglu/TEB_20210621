package com.training.java.date;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NewDateTime {

    public static SimpleDateFormat    dateFormatLoc = new SimpleDateFormat("yyyy-MM-dd");
    public static List<String>        strList       = Collections.synchronizedList(new ArrayList<>());
    public static Map<String, String> map1          = new ConcurrentHashMap<>();

    public Map<String, String>        map2          = new ConcurrentHashMap<>();
    public Map<String, String>        map3;
    public static int                 counter;

    public void name() {
        Map<String, String> map1 = new HashMap<>();
    }

    public static void main(final String[] args) {
        NewDateTime.counter++;
        Date dateLoc = new Date();
        Calendar calendarLoc = new GregorianCalendar();
        calendarLoc.add(Calendar.DAY_OF_MONTH,
                        1);


        LocalDate date1 = LocalDate.now()
                                   .plusDays(1);
        LocalTime timeLoc = LocalTime.now();
        LocalDateTime dateTimeLoc = LocalDateTime.now()
                                                 .plusDays(1)
                                                 .plusHours(3);

        LocalDate ofLoc = LocalDate.of(2020,
                                       3,
                                       20);
        LocalDateTime of2Loc = LocalDateTime.of(2020,
                                                3,
                                                20,
                                                1,
                                                1,
                                                5);
        int dayOfMonthLoc = of2Loc.getDayOfMonth();

        LocalDate parseLoc = LocalDate.parse("2020-03-20");
        parseLoc.isAfter(LocalDate.parse("2020-03-21"));
        parseLoc.isBefore(LocalDate.parse("2020-03-21"));

        ZoneId zoneIdLoc = ZoneId.of("Europe/Berlin");
        ZonedDateTime dateTime2Loc = ZonedDateTime.of(LocalDateTime.now(),
                                                      zoneIdLoc);
        ZonedDateTime.parse("2019-04-01T16:24:11.252+05:30[Asia/Calcutta]");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm:ss Z");

        String formatLoc = dateTime2Loc.format(formatter);
        System.out.println(formatLoc);
    }
}
