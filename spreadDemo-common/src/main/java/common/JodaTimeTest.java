package common;


import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public class JodaTimeTest {

    public static void main(String[] args) {



        for (int i = 04; i <= 12; i++) {

            DateTime dateTime = new DateTime(2020,i,1,0,0);

            final int lastDay = dateTime.dayOfMonth().withMaximumValue().getDayOfMonth();

            for (int j = 1; j <= lastDay; j++) {
                DateTime day = new DateTime(dateTime.getYear(),i,j,1,1);
                final String yyyymMdd = day.toString("YYYYMMdd");
                System.out.println("alter table cw_xstj_"+yyyymMdd+" add jigouId     int(11)        null comment '财务机构id',add originalWid bigint(20)     null comment '原始skuId',add isUpdate    varchar(5) null comment '是否需要更新仓报价,Y需要';\n");
            }

        }



    }
}
