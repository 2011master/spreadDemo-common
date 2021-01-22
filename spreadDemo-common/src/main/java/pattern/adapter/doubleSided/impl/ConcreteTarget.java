package pattern.adapter.doubleSided.impl;

import pattern.adapter.doubleSided.Target;

public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("具体目标请求");
    }
}
