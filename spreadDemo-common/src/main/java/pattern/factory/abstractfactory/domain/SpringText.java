package pattern.factory.abstractfactory.domain;

public class SpringText implements Text {
    @Override
    public void display() {
        System.out.println("春天样式文本");
    }
}
