package pattern.prototype.junior.deep;



import java.io.IOException;
import java.util.Date;

public class Client {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Attachment attachment = new Attachment();
        attachment.setName("附件");
        WeeklyLog weeklyLog = new WeeklyLog();
        weeklyLog.setName("张三丰");
        weeklyLog.setContent("develop");
        weeklyLog.setDate(new Date());
        weeklyLog.setAttachment(attachment);


        System.out.println("周报：" + weeklyLog.toString());
        System.out.println("=================");
        WeeklyLog clone = weeklyLog.deepClone();
        System.out.println("副本：" + clone.toString());

        System.out.println("weeklyLog == clone：" + (weeklyLog == clone));
        System.out.println("weeklyLog.getContent() == clone.getContent()：" + (weeklyLog.getContent() == clone.getContent()));
        System.out.println("weeklyLog.getDate() == clone.getDate()："  + (weeklyLog.getDate() == clone.getDate()));
        System.out.println("weeklyLog.getName() == clone.getName()：" + (weeklyLog.getName() == clone.getName()));
        System.out.println("weeklyLog.getAttachment() == clone.getAttachment() ：" + (weeklyLog.getAttachment() == clone.getAttachment()));
    }
}
