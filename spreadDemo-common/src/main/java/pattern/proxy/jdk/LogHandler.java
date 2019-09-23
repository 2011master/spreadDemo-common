package pattern.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
* @desc   调用处理类
* @author kanggw
* @datetime 2019-08-15,15:46
*/
public class LogHandler implements InvocationHandler {

    private Object object;

    public LogHandler() {
    }

    public LogHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        beforeInvoke();
        //转发调用
        Object invoke = method.invoke(object, args);
        afterInvoke();
        return null;
    }

    /**
     * 记录调用前时间
     */
    private void beforeInvoke() {
        System.out.println("调用前时间："+System.currentTimeMillis());
    }

    /**
     * 记录调用后时间
     */
    private void afterInvoke() throws InterruptedException {
        Thread.sleep(3000L);
        System.out.println("调用后时间："+System.currentTimeMillis());
    }
}
