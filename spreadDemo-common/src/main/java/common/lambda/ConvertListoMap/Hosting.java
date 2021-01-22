package common.lambda.ConvertListoMap;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Hosting {

    private int Id;
    private String name;
    private long websites;

    public Hosting() {
    }

    public Hosting(int id, String name, long websites) {
        Id = id;
        this.name = name;
        this.websites = websites;
    }




    public static void main(String[] args) {

        List<Hosting> hostings = Lists.newArrayList();
        hostings.add(new Hosting(2, "test01", 123L));
        Hosting reduce = hostings.stream().reduce(new Hosting(), (v1, v2) -> {
            int sum = v1.Id + v2.Id;
            v1.setId(sum);
            return v1;
        });
        System.out.println(reduce.toString());
    }

}