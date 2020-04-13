package common.roundRobin;

import java.util.concurrent.atomic.AtomicInteger;

public class RoundRobin2 {

    /** * 线程安全的 */
    private final static AtomicInteger next = new AtomicInteger(0);

    private int select(int S[]) throws Exception {
        if (S == null || S.length == 0) {
            throw new Exception("exception");
        } else {
            return S[next.getAndIncrement() % S.length];
        }
    }

    public static void main(String args[]) throws Exception {
        int S[] = {0, 1, 2, 3, 4};
        RoundRobin2 roundRobin2 = new RoundRobin2();
        for (int i = 0; i < 10; i++) {
            System.out.println(roundRobin2.select(S));
        }
    }
}