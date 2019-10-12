package pattern.adapter.doubleSided;

import pattern.adapter.doubleSided.impl.ConcreteAdapte;
import pattern.adapter.doubleSided.impl.ConcreteTarget;

public class Client {

    public static void main(String[] args) {
        Target target = new ConcreteTarget();
        Adapte adapte = new ConcreteAdapte();

        Adapter adapter = new Adapter(target, adapte);
        //调用目标请求方法
        adapter.request();
        //调用具体处理方法
        adapter.specificRequest();
    }
}
