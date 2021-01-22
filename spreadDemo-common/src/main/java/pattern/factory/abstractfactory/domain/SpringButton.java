package pattern.factory.abstractfactory.domain;

public class SpringButton implements Button {
    @Override
    public void display() {
        System.out.println("春天样式按钮");
    }
}
