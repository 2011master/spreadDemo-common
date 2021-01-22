package pattern.factory.exercise;

public class GIFReader implements ImageReader {
    @Override
    public void read(String name) {
        System.out.println("读取GIF文件："+name);
    }
}
