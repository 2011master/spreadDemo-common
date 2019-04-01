package pattern.mediator;

public class TextBox extends Component {


    @Override
    public void update() {
        System.out.println("客户信息增加成功后，文本框清空");
    }

    public void setText() {
        System.out.println("文本框显示：小龙女");
    }
}
