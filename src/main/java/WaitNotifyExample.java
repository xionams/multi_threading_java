
/* ping pong game */
public class WaitNotifyExample {
    public static void main(String[] args) {
        Object pingPongManager = new Object();
        Player player_1 = new Player("Ping", pingPongManager);
        Player player_2 = new Player("Pong", pingPongManager);

        new Thread(player_1, "player 1").start();
        new Thread(player_2, "player 2").start();
    }
}

class Player implements Runnable{
   private final String hit;
    private final Object syncObject;

    public Player(String hit, Object syncObject) {
        this.hit = hit;
        this.syncObject = syncObject;
    }
    @Override
    public void run(){
        while(true) {
            synchronized (syncObject) {
                System.out.println(Thread.currentThread().getName() + " : " + hit);
                syncObject.notify(); // release an object from the queue
                try {
                    syncObject.wait();
                    // sign myself to the object queue
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
