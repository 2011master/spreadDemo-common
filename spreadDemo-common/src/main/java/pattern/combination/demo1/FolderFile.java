package pattern.combination.demo1;

import com.google.common.collect.Lists;

import java.util.List;

/**
* @desc   文件夹
* @author kanggw
* @datetime 2019/10/21,1:06 下午
*/
public class FolderFile extends AbstractFile{

    private List<AbstractFile> fileList = Lists.newArrayList();

    @Override
    public void add(AbstractFile abstractFile) {
        fileList.add(abstractFile);
    }

    @Override
    public void remove(AbstractFile abstractFile) {
        fileList.remove(abstractFile);
    }

    @Override
    public AbstractFile getChild(int i) {
        return fileList.get(i);
    }

    @Override
    public void killVirus() {
        fileList.forEach(AbstractFile::killVirus);
    }
}
