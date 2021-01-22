package pattern.combination.demo2;

/**
* @desc   视频文件
* @author kanggw
* @datetime 2019/10/21,1:06 下午
*/
public class VideoFile extends AbstractFile {
    @Override
    public void killVirus() {
        System.out.println("模拟对视频文件杀毒");
    }
}
