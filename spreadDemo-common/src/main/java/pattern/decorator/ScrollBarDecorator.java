package pattern.decorator;

public class ScrollBarDecorator extends DeracotorComponent {

    public ScrollBarDecorator(Component component) {
        super(component);
    }

    public void setScrollBar() {
        System.out.println("增加滚动");
    }

    @Override
    public void display() {
        super.display();
        setScrollBar();
    }
}
