package common.stream;

import com.fasterxml.jackson.core.util.Separators;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class MyInputStream {

    public static void main(String[] args) {
//        String property = System.getProperty("user.dir");

        //vm启动时所设置的工作目录
//        System.out.println("用户工作目录："+property);

        try {
            zipOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void zipOutputStream() throws IOException {

        //指定输出目录
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream("spreadDemo-common/src/main/resources/pattern/facade/test.zip"));

        //内部文件可以有多个
        ZipEntry entry1 = new ZipEntry("file1");


        zipOutputStream.putNextEntry(entry1);

        //向zipOutputStream发送数据
        FileInputStream fileInputStream = new FileInputStream(new File("spreadDemo-common/src/main/resources/pattern/facade/myHeart.txt"));


        int temp;

        while ((temp = fileInputStream.read()) != -1) {
            zipOutputStream.write(temp);
        }

        zipOutputStream.closeEntry();

        zipOutputStream.close();
    }
}
