import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import pattern.facade.service.Facade;
import pattern.facade.service.impl.FacdeOne;

public class FacadeTest {

    @Test
    public void testFacade() {
        Facade facade;
        facade = new FacdeOne();
        String path = "pattern/facade/myHeart.txt";
        String targetPath = "pattern/facade/encryptMyHeart.txt";
        facade.handle(path,targetPath);
    }
}
