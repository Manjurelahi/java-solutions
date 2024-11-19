// Print Number and Alphabet Character sequence by using two threads, such as 1A 2B 3C ... 26Z 

public class PrintNumberCharByTwoThreads {	
    private static boolean printNumber = true;
    private static final Object lock = new Object();
    
	public static void main(String[] args) {
        Runnable numberRunnable = () -> {
            for (int i=1; i<=26; i++) {
                synchronized (lock) {
                    if (!printNumber) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.print(i);
                    printNumber = false;
                    lock.notify();
                }
            }
        };

        Runnable charRunnable = () -> {
            for (char ch='A'; ch<='Z'; ch++) {
                synchronized (lock) {
                    if (printNumber) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(ch);
                    printNumber = true;
                    lock.notify();
                }
            }
        };

        Thread numberThread = new Thread(numberRunnable);
        Thread charThread = new Thread(charRunnable);
        numberThread.start();
        charThread.start();
    }
}
/*
Output:
1A
2B
3C
4D
5E
6F
7G
8H
9I
10J
11K
12L
13M
14N
15O
16P
17Q
18R
19S
20T
21U
22V
23W
24X
25Y
26Z
 */
