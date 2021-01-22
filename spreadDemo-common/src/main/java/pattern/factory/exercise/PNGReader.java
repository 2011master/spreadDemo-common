package pattern.factory.exercise;

public class PNGReader implements ImageReader {
    @Override
    public void read(String name) {
        System.out.println("读取PNG文件："+name);
    }
}
