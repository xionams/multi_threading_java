/*
* Zion HamSalem
* Thread and multiprocessing
* more than sandbox for testing and
* implements heavy multitasking jobs
* */

public class ThreadExample {
    public static void main(String[] args) {
        // Thread implementation
        new MyThreadTest("Background").start();

        // main act as a thread. for testing
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " thread!");
        }
    }
}
class MyThreadTest extends Thread{
    // Thread implementation
    public MyThreadTest(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
                /*
                 * sleep function throws InterruptedException
                 * when the OS ask to end the thread life because
                 * end-user is close the pc or something,
                 * so this block of code will be in case of
                 * the thread is a demon we could save our progress.
                 */
            } catch (InterruptedException e) {
                /*
                 * end of the thread life!
                 * we can log here for example
                 * */
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " thread!");
        }
    }
}