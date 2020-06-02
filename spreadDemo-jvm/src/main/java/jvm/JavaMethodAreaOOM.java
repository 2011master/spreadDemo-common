package jvm;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
* @desc
 * 方法区内存溢出 jdk7
 *
 * jdk8以后：永久代完全退出了历史舞台，元空间做为替代者登场。在默认设置下，动态创建新类型的测试用例已经很难迫使虚拟机产生方法区内存溢出了。
 *
 * 通过 cglib 直接操作字节码运行时生成大量的动态类
* @author kanggw
* @datetime 2020/5/28,7:40 下午
*/
public class JavaMethodAreaOOM {

    public static void main(String[] args) {
        while (true) {

            Enhancer enhancer = new Enhancer();

            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);

            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

                    return methodProxy.invokeSuper(o,args);
                }
            });

        }
    }

    static class OOMObject{}
}
