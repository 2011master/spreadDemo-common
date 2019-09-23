package common.stringProcess;




import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import utils.JsonUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.StringJoiner;

public class StringUtilsSelf {

    public static void main(String[] args) {
        String groupingByKey1 = getGroupingByKey1(null, "test2");
        String groupingByKey2 = getGroupingByKey2(null, "test2");
        System.out.println(groupingByKey1);
        System.out.println(groupingByKey2);
    }

    public static String getGroupingByKey1(String... params) {
        StringJoiner sj = new StringJoiner("-");
        for (String param : params) {
            sj.add(param);
        }
        return sj.toString();
    }

    public static String getGroupingByKey2(String... params) {

        return StringUtils.join(params, "-");
    }


    public static void getRepeat() throws IOException {

        String s = FileUtils.readFileToString(new File("/Users/kangguowei/Desktop/repeat.txt"), "UTF-8");

    }


}
