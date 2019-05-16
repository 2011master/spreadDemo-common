package pattern.decorator;

public class BorderDecorator extends DeracotorComponent {

    public BorderDecorator(Component component) {
        super(component);
    }

    public void setScrollBar() {
        System.out.println("增加边框");
    }

    @Override
    public void display() {
        super.display();
        setScrollBar();
    }
}
