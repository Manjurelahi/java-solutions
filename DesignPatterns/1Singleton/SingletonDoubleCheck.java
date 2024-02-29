class SingletonDoubleCheckClass {
    private static SingletonDoubleCheckClass singletonClass;

    private SingletonDoubleCheckClass() {}

    public static SingletonDoubleCheckClass getInstance() {
        if (singletonClass == null) {
            synchronized (SingletonDoubleCheckClass.class) {
                if (singletonClass == null) {
                    singletonClass = new SingletonDoubleCheckClass();
                }
            }
        }
        return singletonClass;
    }

}

public class SingletonDoubleCheck {	
    static SingletonDoubleCheckClass singleOne;
    static SingletonDoubleCheckClass singleTwo;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> singleOne = SingletonDoubleCheckClass.getInstance());
        Thread t2 = new Thread(() -> singleTwo = SingletonDoubleCheckClass.getInstance());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        //Comaparing above objects
        if (singleOne==singleTwo && singleOne.equals(singleTwo)) {
            System.out.println("Objects are same and unique: Single One "+singleOne);
            System.out.println("Objects are same and unique: Single Two "+singleTwo);
        }
    }
}

/*
Output:
Objects are same and unique: Single One SingletonDoubleCheckClass@87aac27
Objects are same and unique: Single Two SingletonDoubleCheckClass@87aac27
 */