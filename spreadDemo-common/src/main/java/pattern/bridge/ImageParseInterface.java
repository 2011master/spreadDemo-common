package pattern.bridge;

public abstract class ImageParseInterface {

    protected ImagePaintInterface imagePaintInterface;

    public void setImagePaintInterface(ImagePaintInterface imagePaintInterface) {
        this.imagePaintInterface = imagePaintInterface;
    }

    public abstract void parseFile(String fileName);
}
