package pattern.combination.demo2;

import com.google.common.collect.Lists;

import java.util.List;

/**
* @desc   文件夹
* @author kanggw
* @datetime 2019/10/21,1:06 下午
*/
public class FolderFile extends AbstractFile {

    private List<AbstractFile> fileList = Lists.newArrayList();

    public void add(AbstractFile abstractFile) {
        fileList.add(abstractFile);
    }

    public void remove(AbstractFile abstractFile) {
        fileList.remove(abstractFile);
    }

    public AbstractFile getChild(int i) {
        return fileList.get(i);
    }

    @Override
    public void killVirus() {
        fileList.forEach(AbstractFile::killVirus);
    }
}
