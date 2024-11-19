public class DeadlockProblem {
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
       synchronized (b) {
           System.out.println("Thread 2 Locked: "+b);
           synchronized (a) {
               System.out.println("Thread 2 Locked: "+a);
           }
       }
    });

    public static void main(String[] args) {
        DeadlockProblem deadLockProblem = new DeadlockProblem();
        deadLockProblem.t1.start();
        deadLockProblem.t2.start();
    }
}
