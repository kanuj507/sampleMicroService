
public class LruCache extends Thread {


    // Hashtable
    // Hashtable<Sttring, String> hashable = new Hashtable<>();
    public static void main(String[] args) throws InterruptedException {
        LruCache lu = new LruCache();
        lu.setName("test thread");
        // u.run();
        lu.start();
        Thread.sleep(1);
        // Thread t = Thread.currentThread();
        // t.setName("MainThread");
        System.out.println("Test test");
    }

    public void run() {
        // TODO Auto-generated method stub
        System.out.println("Thread started " + Thread.currentThread().getName());
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}

// Doubly link list
class Node {
    int data;
    Node tail;
    Node head;

    Node() {

    }
}