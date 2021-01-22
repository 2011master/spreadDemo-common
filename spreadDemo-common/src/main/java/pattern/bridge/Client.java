package pattern.bridge;

import pattern.bridge.impl.JPGParseImpl;
import pattern.bridge.impl.WindowsPaintImpl;

public class Client {

    public static void main(String[] args) {
        ImageParseInterface imageParseInterface;
        ImagePaintInterface imagePaintInterface;

        imageParseInterface = new JPGParseImpl();
        imagePaintInterface = new WindowsPaintImpl();

        imageParseInterface.setImagePaintInterface(imagePaintInterface);
        imageParseInterface.parseFile("富春山居图");
    }
}
