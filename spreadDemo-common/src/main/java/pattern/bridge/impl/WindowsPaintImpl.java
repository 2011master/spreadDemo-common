package pattern.bridge.impl;

import pattern.bridge.ImagePaintInterface;
import pattern.bridge.Matrix;

public class WindowsPaintImpl implements ImagePaintInterface {

    @Override
    public void doPaint(Matrix matrix) {
        System.out.println("在windows系统中显示图象");
    }
}
