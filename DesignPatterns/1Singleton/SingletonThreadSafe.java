class SingletonThreadSafeClass {
    private static SingletonThreadSafeClass singletonClass;

    private SingletonThreadSafeClass() {}

    public synchronized static SingletonThreadSafeClass getInstance() {
        if (singletonClass == null) {
            singletonClass = new SingletonThreadSafeClass();
        }
        return singletonClass;
    }
}
public class SingletonThreadSafe {

    static SingletonThreadSafeClass singleOne;
    static SingletonThreadSafeClass singleTwo;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> singleOne = SingletonThreadSafeClass.getInstance());
        Thread t2 = new Thread(() -> singleTwo = SingletonThreadSafeClass.getInstance());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        //Comaparing above objects
        if(singleOne==singleTwo && singleOne.equals(singleTwo)) {
            System.out.println("Objects are same and unique: Single One "+singleOne);
            System.out.println("Objects are same and unique: Single Two "+singleTwo);
        }
    }
}

/*
Output:
Objects are same and unique: Single One SingletonThreadSafeClass@87aac27
Objects are same and unique: Single Two SingletonThreadSafeClass@87aac27
 */