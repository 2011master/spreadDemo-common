package pattern.combination.demo3;

/**
* @desc   调用端
* @author kanggw
* @datetime 2019/10/22,12:56 下午
*/
public class Client {

    public static void main(String[] args) {
        AbstractFile textFile,videoFile;
        FolderFile folder1 = new FolderFile();
        FolderFile folder2 = new FolderFile();
        FolderFile folder3 = new FolderFile();
        FolderFile folder4 = new FolderFile();

        textFile = new TextFile();
        videoFile = new VideoFile();
        ImageFile imageFile = new ImageFile();

        folder1.add(folder2);
        folder1.add(folder3);
        folder1.add(folder4);

        folder2.add(textFile);
        folder3.add(imageFile);
        folder4.add(videoFile);

        folder1.killVirus();


    }
}
