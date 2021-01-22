package pattern.decorator;

public class Client {

    public static void main(String[] args) {
        getScorllWindow();
        System.out.println("-------");
        getBorderlWindow();
        System.out.println("-------");
        getScrollAndBorderlWindow();

    }

    /**
     * 得到带滚动条的窗口
     */
    public static void getScorllWindow() {
        Component window,decorator;

        window = new Window();
        decorator = new ScrollBarDecorator(window);
        decorator.display();
    }

    /**
     * 得到带边框的窗口
     */
    public static void getBorderlWindow() {
        Component window,decorator;

        window = new Window();
        decorator = new BorderDecorator(window);
        decorator.display();
    }

    /**
     * 得到带滚动条及边框的窗口
     */
    public static void getScrollAndBorderlWindow() {
        Component window,decoratorScroll,decoratorBorder;

        window = new Window();
        decoratorScroll = new ScrollBarDecorator(window);
        decoratorBorder = new BorderDecorator(decoratorScroll);
        decoratorBorder.display();
    }
}
