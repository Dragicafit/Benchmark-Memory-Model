import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTestLock extends Thread {
    static Lock lock = new ReentrantLock();
    static long i;

    @Override
    public void run() {
        for (long j = 0; j < 100_000_000; j++) {
            lock.lock();
            i++;
            lock.unlock();
        }
    }

    public static void main(String[] arg) throws InterruptedException {
        ThreadTestLock th1 = new ThreadTestLock();
        th1.start();
        ThreadTestLock th2 = new ThreadTestLock();
        th2.start();
        ThreadTestLock th3 = new ThreadTestLock();
        th3.start();

        th1.join();
        th2.join();
        th3.join();

        System.out.println(i);
    }
}
