package pattern.prototype.junior.shallow;

import lombok.Data;

import java.util.Date;

@Data
public class WeeklyLog implements Cloneable {

    private String name;
    private Date date;
    private String content;


    @Override
    public WeeklyLog clone() throws CloneNotSupportedException {
        return (WeeklyLog) super.clone();
    }
}
