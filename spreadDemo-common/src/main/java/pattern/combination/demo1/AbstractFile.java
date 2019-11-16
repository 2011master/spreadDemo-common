package pattern.combination.demo1;

/**
* @desc   组合模式抽象类: 模拟对文件夹进行杀毒
* @author kanggw
* @datetime 2019/10/21,1:04 下午
*/
public abstract class AbstractFile {

    public abstract void add(AbstractFile abstractFile);

    public abstract void remove(AbstractFile abstractFile);

    public abstract AbstractFile getChild(int i);

    public abstract void killVirus();

}
