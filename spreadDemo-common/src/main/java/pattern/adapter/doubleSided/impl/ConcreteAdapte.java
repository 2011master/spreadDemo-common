package pattern.adapter.doubleSided.impl;

import pattern.adapter.doubleSided.Adapte;

public class ConcreteAdapte implements Adapte {
    @Override
    public void specificRequest() {
        System.out.println("具体请求处理");
    }
}
