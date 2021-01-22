package pattern.mediator;

public class ConcreteMediator implements Mediator{

    public Button button;
    public ComboBox comboBox;
    public ListInfo list;
    public TextBox textBox;

    @Override
    public void componentChanged(Component component) {

        if (button == component) {
            System.out.println("单击增加按钮");
            comboBox.update();
            list.update();
            textBox.update();
        } else if (comboBox == component) {
            System.out.println("从组合框选择客户");
            comboBox.select();
            textBox.setText();
        } else if (list == component) {
            System.out.println("从列表框选择客户");
            comboBox.select();
            textBox.setText();
        }
    }
}
