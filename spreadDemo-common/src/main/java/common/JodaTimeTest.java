package common;


import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public class JodaTimeTest {

    public static void main(String[] args) {



        for (int i = 02; i <= 02; i++) {

            DateTime dateTime = new DateTime(2020,i,1,0,0);

            final int lastDay = dateTime.dayOfMonth().withMaximumValue().getDayOfMonth();

            for (int j = 1; j <= lastDay; j++) {
                DateTime day = new DateTime(dateTime.getYear(),i,j,1,1);
                final String yyyymMdd = day.toString("YYYYMMdd");
                System.out.println("drop table IF EXISTS cw_xstj_"+yyyymMdd+";");
            }

        }



    }
}
