package pattern.combination.demo1;

/**
* @desc   调用端
* @author kanggw
* @datetime 2019/10/22,12:56 下午
*/
public class Client {

    public static void main(String[] args) {
        AbstractFile folder1,folder2,folder3,folder4,textFile,imageFile,videoFile;
        folder1 = new FolderFile();
        folder2 = new FolderFile();
        folder3 = new FolderFile();
        folder4 = new FolderFile();

        textFile = new TextFile();
        imageFile = new ImageFile();
        videoFile = new VideoFile();

        folder1.add(folder2);
        folder1.add(folder3);
        folder1.add(folder4);

        folder2.add(textFile);
        folder3.add(imageFile);
        folder4.add(videoFile);

        folder1.killVirus();


    }
}
