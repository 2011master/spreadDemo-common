package pattern.factory.exercise;

public class GIFReaderFactory implements ReaderFactory {
    @Override
    public void readImg(String name) {
        System.out.println("开始读取GIF文件");
        createReader().read(name);
    }

    public ImageReader createReader() {
        System.out.println("创建GIFReader");
        return new GIFReader();
    }
}
