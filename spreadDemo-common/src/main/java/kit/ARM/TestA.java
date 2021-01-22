package kit.ARM;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/**
 * @author Administrator * @date 2019/2/14
 */
interface TestA {
    void testA();
}

class InnerClass {
    public void test1(TestA a) {
        a.toString();
    }
}

class TestMain {
    public static void main(String[] args) {
        InnerClass innerClass = new InnerClass();
        List<String> testStrings = new ArrayList<>();
        //只在内部类里面使用可以省略final（但其实它是final类型的）

        int a = 1;
        Integer[] b = {1};
        AtomicInteger c = new AtomicInteger(1);
        innerClass.test1(new TestA() {
            @Override
            public void testA() {
                b[0] = 3;
                b[0] = a;
            }
        });
        testStrings.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                b[0] = 3;
                c.set(2);
                c.set(a);
            }
        });
    }
}