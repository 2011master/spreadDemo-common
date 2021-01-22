package pattern.factory.abstractfactory.domain;

public class SummerText implements Text {
    @Override
    public void display() {
        System.out.println("夏天样式文本");
    }
}
