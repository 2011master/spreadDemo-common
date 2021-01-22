package pattern.decorator.practice;

public class Client {

    public static void main(String[] args) {
        encryption();
    }

    /**
     * 文本加密
     */
    public static void encryption() {
        Component text, moveEncryption, reverseEncryption, modEncryption;
        text = new Text();
        modEncryption = new ModEncryptionDecorator(text);
        reverseEncryption = new ReverseEncryptionDecorator(modEncryption);
        moveEncryption = new MoveEncryptionDecorator(reverseEncryption);
        moveEncryption.output();
    }
}
