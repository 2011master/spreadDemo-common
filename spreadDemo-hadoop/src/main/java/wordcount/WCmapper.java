package wordcount;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
//框架默认每次读一行的数据
public class WCmapper extends Mapper<LongWritable, Text, Text, LongWritable> {

    /*
     1,获取读到的一行数据
     2，分割数据
     3，发送数据
     */

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        value.toString();
        String[] values = StringUtils.split(value.toString(), " ");

        for (String info : values) {
            context.write(new Text(info),new LongWritable(1));
        }
    }
}
