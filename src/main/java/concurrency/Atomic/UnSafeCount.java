package concurrency.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class UnSafeCount implements Runnable {
    private static int count = 0;

    public void run() {
        count = count + 1;
    }

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        System.out.println(atomicInteger.get());
        atomicInteger.getAndIncrement();
        System.out.println(atomicInteger.get());

    }
}
