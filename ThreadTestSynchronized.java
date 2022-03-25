public class ThreadTestSynchronized extends Thread {
    static long i;

    @Override
    public void run() {
        for (long j = 0; j < 100_000_000; j++) {
            synchronized (ThreadTestSynchronized.class) {
                i++;
            }
        }
    }

    public static void main(String[] arg) throws InterruptedException {
        ThreadTestSynchronized th1 = new ThreadTestSynchronized();
        th1.start();
        ThreadTestSynchronized th2 = new ThreadTestSynchronized();
        th2.start();
        ThreadTestSynchronized th3 = new ThreadTestSynchronized();
        th3.start();

        th1.join();
        th2.join();
        th3.join();

        System.out.println(i);
    }
}
