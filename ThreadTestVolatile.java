public class ThreadTestVolatile extends Thread {
    static volatile long i;

    @Override
    public void run() {
        for (long j = 0; j < 100_000_000; j++) {
            i++;
        }
    }

    public static void main(String[] arg) throws InterruptedException {
        ThreadTestVolatile th1 = new ThreadTestVolatile();
        th1.start();
        ThreadTestVolatile th2 = new ThreadTestVolatile();
        th2.start();
        ThreadTestVolatile th3 = new ThreadTestVolatile();
        th3.start();

        th1.join();
        th2.join();
        th3.join();

        System.out.println(i);
    }
}
