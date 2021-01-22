package pattern.decorator.practice;

/**
* @desc   求模加密
* @author kanggw
* @datetime 2019-05-16,10:26
*/
public class ModEncryptionDecorator extends  DecoratorComponent {

    public ModEncryptionDecorator(Component component) {
        super(component);
    }

    @Override
    public void output() {
        super.output();
        modEncryption();
    }

    public void modEncryption() {
        System.out.println("求模加密");
    }
}
