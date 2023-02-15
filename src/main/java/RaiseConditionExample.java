public class RaiseConditionExample {
    static int counter = 0; // shared resource
    static final Object handleCounter = new Object(); // shared resource lock

    public static void main(String[] args) {

        Object handle = new Object();

        Thread counter1 = new updateCounter(handle);
        Thread counter2 = new updateCounter(handle);

        counter1.start();
        counter2.start();

        try {
            counter1.join();
            counter2.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(counter);
    }
}

class updateCounter extends Thread {
    private final Object syncObj;

    public updateCounter(Object syncObj) {
        this.syncObj = syncObj;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10000000; i++) {
            synchronized (syncObj) {
                RaiseConditionExample.counter++;
            }
        }
    }
}
