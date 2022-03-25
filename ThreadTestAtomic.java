import java.util.concurrent.atomic.AtomicLong;

public class ThreadTestAtomic extends Thread {
    static AtomicLong i = new AtomicLong();

    @Override
    public void run() {
        for (long j = 0; j < 100_000_000; j++) {
            i.incrementAndGet();
        }
    }

    public static void main(String[] arg) throws InterruptedException {
        ThreadTestAtomic th1 = new ThreadTestAtomic();
        th1.start();
        ThreadTestAtomic th2 = new ThreadTestAtomic();
        th2.start();
        ThreadTestAtomic th3 = new ThreadTestAtomic();
        th3.start();

        th1.join();
        th2.join();
        th3.join();

        System.out.println(i.get());
    }
}
