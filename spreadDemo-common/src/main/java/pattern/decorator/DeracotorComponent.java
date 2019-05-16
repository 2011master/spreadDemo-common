package pattern.decorator;

public class DeracotorComponent extends Component {

    private Component component;


    public DeracotorComponent(Component component) {
        this.component = component;
    }

    @Override
    public void display() {
        component.display();
    }


}
