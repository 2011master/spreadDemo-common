package pattern.combination.demo1;

/**
* @desc   文本文件
* @author kanggw
* @datetime 2019/10/21,1:06 下午
*/
public class TextFile extends AbstractFile{
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
        System.out.println("模拟对文本文件杀毒");
    }
}
