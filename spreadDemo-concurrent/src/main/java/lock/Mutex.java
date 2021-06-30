package lock;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;

/**
 * 独占锁Mutex是一个自定义同步组件，它在同一时刻只允许一个线程占有锁。Mutex中定义了一个静态内部类，该内部类继承了同步器并实现了独占式获取和释放同步状态。在tryAcquire(int acquires)方法中，如果经过CAS设置成功（同步状态设置为1），则代表获取了同步状态，而在tryRelease(intreleases)方法中只是将同步状态重置为0。用户使用Mutex时并不会直接和内部同步器的实现打交道，而是调用Mutex提供的方法，在Mutex的实现中，以获取锁的lock()方法为例，只需要在方法实现中调用同步器的模板方法acquire(intargs)即可，当前线程调用该方法获取同步状态失败后会被加入到同步队列中等待，这样就大大降低了实现一个可靠自定义同步组件的门槛。
 */
public class Mutex {

    private static class Sync extends AbstractQueuedSynchronizer{
        //当状态为0时获取锁
        @Override
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        //释放锁
        @Override
        protected boolean tryRelease(int arg) {

            if (getState() == 0) {
                throw new IllegalStateException();
            }
            setState(0);
            setExclusiveOwnerThread(null);
            return true;

        }

        //是否处于占用状态
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        //返回一个Condition ,每个condition都包含一个condition 队列
        Condition  newCondition() {return new  ConditionObject();}
    }

    private final Sync sync = new Sync();

    public void lock() {
        sync.acquire(1);
    }

    public void tryLock() {
        sync.tryAcquire(1);
    }

    public void unLock() {
        sync.release(1);
    }

    public Condition newCondition() {
        return sync.newCondition();
    }

    public boolean isLock() {
        return sync.isHeldExclusively();
    }

    public boolean hasQunedThreads() {
        return sync.hasQueuedThreads();
    }

    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    public boolean tryLock(long time,TimeUnit timeUnit) throws InterruptedException {

        return sync.tryAcquireNanos(1, timeUnit.toNanos(time));
    }

}
