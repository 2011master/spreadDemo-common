package jvm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @desc   测试通过system.gc()能否触发 g1的fullgc
 *  args: -XX:+PrintGCDetails -XX:+UseG1GC
 *  结论:可以触发
* @author kanggw
* @datetime 2020/7/1,6:31 下午
*/
public class G1FullGcTest {

    //占点内存，以便在gc日志中看清楚是否有回收过
    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) throws IOException {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

        bReader.readLine();

        System.out.println("调用gc");
        System.gc();

        bReader.readLine();

        System.out.println("执行结束");


    }
}
