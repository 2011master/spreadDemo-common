package pattern.facade.service.impl;

import org.springframework.core.io.ClassPathResource;
import pattern.facade.service.FileWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Writer implements FileWriter {
    @Override
    public void write(String encryptStr, String fileNameDes){
        System.out.println("保存密文，写入文件。");
        ClassPathResource classPathResource = new ClassPathResource(fileNameDes);
        File file = null;
        try {
            file = new File(classPathResource.getPath());
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileOutputStream outFS = new FileOutputStream(file);
        ) {
            outFS.write(encryptStr.getBytes());
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在！");
        } catch (IOException e) {
            System.out.println("文件操作错误！");
        }
    }

}
