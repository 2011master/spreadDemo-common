package pattern.combination.demo1;

/**
* @desc   图片文件
* @author kanggw
* @datetime 2019/10/21,1:06 下午
*/
public class ImageFile extends AbstractFile{
    @Override
    public void add(AbstractFile abstractFile) {
        System.out.println("不支持该方法");
    }

    @Override
    public void remove(AbstractFile abstractFile) {
        System.out.println("不支持该方法");
    }

    @Override
    public AbstractFile getChild(int i) {
        System.out.println("不支持该方法");
        return null;
    }

    @Override
    public void killVirus() {
        System.out.println("模拟对图象文件杀毒");
    }
}
