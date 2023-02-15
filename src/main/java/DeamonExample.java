// minor additional stuff to push!!!!
public class DeamonExample {
    public static void main(String[] args) {
        Thread trd = new Thread("Demon"){
            @Override
            public void run(){
                super.run();
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " thread " + i);
                }
            }
        };
        trd.setDaemon(true);
        trd.start();
        /*
        *  the end expression is go to 5 and stop other than the demon that should be called 10 times
        *  @ setDaemon is just like you said to your os, don't wait until this thread is done, just close.
        * */

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " thread " + i);
        }
    }
}
