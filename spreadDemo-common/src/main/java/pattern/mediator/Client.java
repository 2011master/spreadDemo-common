package pattern.mediator;

public class Client {

    public static void main(String[] args) {

        ConcreteMediator mediator = new ConcreteMediator();

        Button button = new Button();
        ListInfo list = new ListInfo();
        TextBox textBox = new TextBox();
        ComboBox comboBox = new ComboBox();

        mediator.button = button;
        mediator.list = list;
        mediator.textBox = textBox;
        mediator.comboBox = comboBox;

        button.setMediator(mediator);
        button.changed();
        System.out.println("----------");

        list.setMediator(mediator);
        list.changed();


    }
}
