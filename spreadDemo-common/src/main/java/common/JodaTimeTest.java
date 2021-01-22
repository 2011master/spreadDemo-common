package common;


import org.joda.time.DateTime;

public class JodaTimeTest {

    public static void main(String[] args) {



        for (int i = 1; i <= 2; i++) {

            DateTime dateTime = new DateTime(2021,i,1,0,0);

            final int lastDay = dateTime.dayOfMonth().withMaximumValue().getDayOfMonth();

            for (int j = 1; j <= lastDay; j++) {
                DateTime day = new DateTime(dateTime.getYear(),i,j,1,1);
                final String yyyymMdd = day.toString("YYYYMMdd");
                System.out.println("CREATE TABLE `price_cost_"+yyyymMdd+"` (\n" +
                        "  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',\n" +
                        "  `wid` bigint(20) NOT NULL DEFAULT '0' COMMENT '商品sku',\n" +
                        "  `Day` date NOT NULL COMMENT '仓报介生成日期',\n" +
                        "  `channelId` varchar(50) NOT NULL COMMENT '渠道id',\n" +
                        "  `orgId` int(11) NOT NULL COMMENT '渠道id',\n" +
                        "  `price` decimal(18,4) DEFAULT NULL COMMENT '成本价',\n" +
                        "  `quantity` int(11) DEFAULT NULL COMMENT '数量',\n" +
                        "  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',\n" +
                        "  PRIMARY KEY (`id`),\n" +
                        "  UNIQUE KEY `unique_key` (`wid`,`orgId`,`channelId`)\n" +
                        ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='仓报价查询表'");
            }

        }

//        getDateByDiffDay();

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
