package common;


import org.joda.time.DateTime;

import java.util.stream.IntStream;

public class JodaTimeTest {

    public static void main(String[] args) {


        getForNum();

//        getForDate();

//        getDateByDiffDay();

    }

    private static void getForNum() {

        IntStream.rangeClosed(0,99).forEach(i -> {
            System.out.println("create unique index unique_key on price_detail_"+i+" (uniqueKey);");
        });
    }

    private static void getForDate() {
        for (int i = 2; i <= 4; i++) {

            DateTime dateTime = new DateTime(2021,i,1,0,0);

            final int lastDay = dateTime.dayOfMonth().withMaximumValue().getDayOfMonth();

            for (int j = 1; j <= lastDay; j++) {
                DateTime day = new DateTime(dateTime.getYear(),i,j,1,1);
                final String yyyymMdd = day.toString("YYYYMMdd");
                System.out.println("create table price_cost_"+yyyymMdd+" like price_cost_20210223 ;");
            }

        }
    }


    public static void getDateByDiffDay() {

        //2018-12-10  use jed
        DateTime dateTime = new DateTime(2018,12,10,0,0);

        DateTime dateTime1 = dateTime.plusDays(599);
        System.out.println("2018-12-10 plus:" + dateTime1.toString());

        DateTime dateTimeNew = new DateTime(2020,1,1,0,0);

        DateTime plus = dateTimeNew.plusDays(220);

        System.out.println("2020 plus:" + plus.toString());

    }


}
