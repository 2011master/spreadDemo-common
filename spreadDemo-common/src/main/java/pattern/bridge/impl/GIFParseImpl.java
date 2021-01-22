package pattern.bridge.impl;

import pattern.bridge.ImageParseInterface;
import pattern.bridge.Matrix;

public class GIFParseImpl extends ImageParseInterface {

    @Override
    public void parseFile(String fileName) {
        Matrix matrix = new Matrix();
        imagePaintInterface.doPaint(matrix);
        System.out.println(fileName + "格式为GIF");
    }
}
