package wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * 描述运行的类
 * 1，得到job对象
 * 2，进行描述
 */
public class WCrunner {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        Configuration configuration = new Configuration();
        Job instance = Job.getInstance(configuration);
        instance.setJarByClass(WCreducer.class);

        instance.setMapperClass(WCmapper.class);
        instance.setReducerClass(WCreducer.class);

        instance.setOutputKeyClass(Text.class);
        instance.setOutputValueClass(LongWritable.class);

        instance.setMapOutputKeyClass(Text.class);
        instance.setMapOutputValueClass(LongWritable.class);

        //设置路径
        FileInputFormat.setInputPaths(instance,new Path("/wc/srcData/"));
        FileOutputFormat.setOutputPath(instance,new Path("/wc/targetData"));
        //将job提交给集群运行
        instance.waitForCompletion(true);
    }
}
