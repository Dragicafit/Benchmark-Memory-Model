public class ThreadTest extends Thread {
    static long i;

    @Override
    public void run() {
        for (long j = 0; j < 100_000_000; j++) {
            i++;
        }
    }

    public static void main(String[] arg) throws InterruptedException {
        ThreadTest th1 = new ThreadTest();
        th1.start();
        ThreadTest th2 = new ThreadTest();
        th2.start();
        ThreadTest th3 = new ThreadTest();
        th3.start();

        th1.join();
        th2.join();
        th3.join();

        System.out.println(i);
    }
}
