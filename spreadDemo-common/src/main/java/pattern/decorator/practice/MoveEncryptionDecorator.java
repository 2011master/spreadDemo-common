package pattern.decorator.practice;

/**
* @desc   移位加密
* @author kanggw
* @datetime 2019-05-16,10:26
*/
public class MoveEncryptionDecorator extends  DecoratorComponent {

    public MoveEncryptionDecorator(Component component) {
        super(component);
    }

    @Override
    public void output() {
        super.output();
        moveEncryption();
    }

    public void moveEncryption() {
        System.out.println("移位加密");
    }
}
