package pattern.facade;

import org.springframework.core.io.ClassPathResource;
import pattern.facade.service.Facade;
import pattern.facade.service.impl.FacdeOne;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Client {

    public static void main(String[] args) {
        Facade facade;
        facade = new FacdeOne();
//        facade.handle("pattern/facade/myHeart.txt","pattern/facade/encryptMyHeart.txt");

        String path = "pattern/facade/myHeart.txt";
        String targetPath = "/Users/kangguowei/myGit/spreadDemo/spreadDemo-common/src/main/resources/pattern/facade";
        ClassPathResource classPathResource = new ClassPathResource(path);
        facade.handle(path,targetPath);
    }
}
