package pattern.decorator.practice;

/**
* @desc   逆向加密
* @author kanggw
* @datetime 2019-05-16,10:26
*/
public class ReverseEncryptionDecorator extends  DecoratorComponent {

    public ReverseEncryptionDecorator(Component component) {
        super(component);
    }

    @Override
    public void output() {
        super.output();
        reverseEncryption();
    }

    public void reverseEncryption() {
        System.out.println("逆向加密");
    }
}
