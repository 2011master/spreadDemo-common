package pattern.prototype.junior.deep;

import lombok.Data;

import java.io.*;
import java.util.Date;

@Data
public class WeeklyLog implements Serializable {

    private static final long serialVersionUID = -3189998831615779207L;
    private String name;
    private Date date;
    private String content;
    private Attachment attachment;



    public WeeklyLog deepClone() throws IOException, ClassNotFoundException {

        /**
         * 1,将对象从内存中取出
         * 2，将对象写入到内存
         * 3，返回
         */
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(this);

        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        WeeklyLog weeklyLog = (WeeklyLog) objectInputStream.readObject();

        return weeklyLog;
    }
}
