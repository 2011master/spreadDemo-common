package pattern.singleton;

public class IODHSigleton {

    private IODHSigleton() {

    }
    //静态内部类
    private static class Handler {
        private final static IODHSigleton instance = new IODHSigleton();
    }

    public static IODHSigleton getInstance() {

        return Handler.instance;
    }

    public static void main(String[] args) {
        IODHSigleton s1,s2;
        s1 = IODHSigleton.getInstance();
        s2 = IODHSigleton.getInstance();
        System.out.println(s1 == s2);
    }
}
