import java.io.*;

class SingletonSerClass implements Serializable {
	public static final SingletonSerClass singletonClass = new SingletonSerClass();
	private SingletonSerClass(){}
	protected Object readResolve() {
		return singletonClass;
	}
}

public class SingletonSer {
	public static void main(String[] args) {
		try {
            SingletonSerClass singleOne = SingletonSerClass.singletonClass;
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("SSC.text"));           
            out.writeObject(singleOne);
            out.close();
 
            // deserialize from file to object
            ObjectInput in = new ObjectInputStream(new FileInputStream("SSC.text"));
            SingletonSerClass singleTwo = (SingletonSerClass)in.readObject();
            in.close();
 
            System.out.println("singleOne hashCode = "+ singleOne.hashCode());
            System.out.println("singleTwo hashCode = "+ singleTwo.hashCode());
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
	}
}

/*
Output:
singleOne hashCode = 1550089733
singleTwo hashCode = 1550089733
 */