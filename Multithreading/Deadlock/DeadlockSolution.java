public class DeadlockSolution {
    private String a = "A";
    private String b = "B";

    Thread t1 = new Thread(() -> {
        synchronized (a) {
            System.out.println("Thread 1 Locked: "+a);
            synchronized(b) {
                System.out.println("Thread 1 Locked: "+b);
            }
        }
    });

    Thread t2 = new Thread(() -> {
        // Reordering lock of shared resources
        synchronized (a) {
            System.out.println("Thread 2 Locked: "+a);
            synchronized (b) {
                System.out.println("Thread 2 Locked: "+b);
            }
        }
    });

    public static void main(String[] args) {
        DeadlockSolution deadLockSolution = new DeadlockSolution();
        deadLockSolution.t1.start();
        deadLockSolution.t2.start();
    }
}
