package concurrent.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
* @desc   参考java并发编程的艺术 5.2.2
* @author kanggw
 * @see concurrent.aqs.TwinsLockTest
* @datetime 2020/7/29,8:03 下午
*/
public class TwinsLock implements Lock {

    private final Sync sync = new Sync(2);

    @Override
    public void lock() {
        sync.acquireShared(1);
    }

    @Override
    public void unlock() {
        sync.releaseShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    /**
     * 自定义同步器,通常通过静态内部类实现
     */
    private static final class Sync extends AbstractQueuedSynchronizer {

        Sync(int count) {
            if (count <= 0) {
                throw new IllegalArgumentException("count must large than zero.");
            }
            //这个state是volatile的
            setState(count);
        }

        @Override
        protected int tryAcquireShared(int arg) {

            for (; ; ) {
                System.out.println("get lock:"+Thread.currentThread().getName());

                int current = getState();
                int newState = current - arg;
                if (newState < 0 || compareAndSetState(current, newState)) {
                    return newState;
                }
            }
        }


        @Override
        protected boolean tryReleaseShared(int arg) {

            for (; ; ) {
                int state = getState();
                int newState = state + arg;
                if (compareAndSetState(state, newState)) {
                    return true;
                }
            }
        }
    }
}
