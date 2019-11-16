package pattern.combination.demo3;

/**
* @desc   组合模式抽象类: 模拟对文件夹进行杀毒 安全模式
* @author kanggw
* @datetime 2019/10/21,1:04 下午
*/
public abstract class AbstractFile {

    public void add(AbstractFile abstractFile) {
        System.out.println("不支持该方法");

    }

    public void remove(AbstractFile abstractFile) {
        System.out.println("不支持该方法");
    }

    public AbstractFile getChild(int i) {
        System.out.println("不支持该方法");
        return null;
    }

    public abstract void killVirus();



}
