package pattern.mediator;

public class ListInfo extends Component {


    @Override
    public void update() {
        System.out.println("列表增加一项：张无忌");
    }

    public void select() {
        System.out.println("列表搜索：小龙女");
    }
}
