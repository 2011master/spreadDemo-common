package wordcount;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * 1，接收map 传递数据
 * 2，汇总
 */

public class WCreducer extends Reducer<Text, LongWritable,Text, LongWritable> {

    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {

        Long count = 0L;
        for (LongWritable num : values) {
            count += num.get();
        }
        context.write(key,new LongWritable(count));
    }
}
