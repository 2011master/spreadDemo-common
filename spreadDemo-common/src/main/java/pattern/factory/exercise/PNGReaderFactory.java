package pattern.factory.exercise;

public class PNGReaderFactory implements ReaderFactory {
    @Override
    public void readImg(String name) {
        System.out.println("开始读取PNG文件");
        createReader().read(name);
    }

    public ImageReader createReader() {
        System.out.println("创建PNGReader");
        return new PNGReader();
    }
}
