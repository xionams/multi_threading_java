import java.lang.Thread;

public class JoinExample {
    public static void main(String[] args) {
        Thread trd = new Thread(){
            @Override
            public void run(){
                super.run();
                for (int i = 0; i < 5; i++) {
                    System.out.println("Welcome!");
                    try {
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        // start the thread
        trd.start();

        try {
            // told the thread, run, and told the other to wait until you done!
            trd.join();
            System.out.println("trd is done his job, you can go forward and do other things!");
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("Goodbye!");
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}
