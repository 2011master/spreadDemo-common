package pattern.prototype.junior.shallow;

import java.util.Date;

public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {

        WeeklyLog weeklyLog = new WeeklyLog();
        weeklyLog.setName("张三丰");
        weeklyLog.setContent("develop");
        weeklyLog.setDate(new Date());

        System.out.println("周报：" + weeklyLog.toString());
        System.out.println("=================");
        WeeklyLog clone = weeklyLog.clone();
        System.out.println("副本：" + clone.toString());

        System.out.println("weeklyLog == clone：" + (weeklyLog == clone));
        System.out.println("weeklyLog.getContent() == clone.getContent()：" + (weeklyLog.getContent() == clone.getContent()));
        System.out.println("weeklyLog.getDate() == clone.getDate()："  + (weeklyLog.getDate() == clone.getDate()));
        System.out.println("weeklyLog.getName() == clone.getName()：" + (weeklyLog.getName() == clone.getName()));
    }
}
