package pattern.decorator.practice;

/**
 * 装饰组件类
 */
public class DecoratorComponent implements Component {

    private Component component;

    public DecoratorComponent(Component component) {
        this.component = component;
    }

    @Override
    public void output() {
        component.output();
    }


}
