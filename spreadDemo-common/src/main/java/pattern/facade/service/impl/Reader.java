package pattern.facade.service.impl;

import org.springframework.core.io.ClassPathResource;
import pattern.facade.Client;
import pattern.facade.service.FileReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class Reader implements FileReader {

    @Override
    public String read(String fileNameSrc) {
        System.out.print("读取文件，获取明文：");
        StringBuffer sb = new StringBuffer();
        ClassPathResource classPathResource = new ClassPathResource(fileNameSrc);
        try (FileInputStream inFS = new FileInputStream(classPathResource.getFile())) {
            int data;
            while ((data = inFS.read()) != -1) {
                sb = sb.append((char) data);
            }
            System.out.println(sb.toString());
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在！");
        } catch (IOException e) {
            System.out.println("文件操作错误！");
        }
        return sb.toString();
    }

}
