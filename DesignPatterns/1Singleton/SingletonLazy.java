class SingletonLazyClass {
	private static SingletonLazyClass singletonClass;
	
	private SingletonLazyClass() {}
	
	public static SingletonLazyClass getInstance() {
		if (singletonClass == null) {
			singletonClass = new SingletonLazyClass();
		}
		return singletonClass;
	}		
}

public class SingletonLazy {
	public static void main(String[] args) {
		SingletonLazyClass singleOne = SingletonLazyClass.getInstance();
		SingletonLazyClass singleTwo = SingletonLazyClass.getInstance();		
		//Comaparing above objects
		if(singleOne==singleTwo && singleOne.equals(singleTwo)) {
			System.out.println("Objects are same and unique: Single One "+singleOne);
			System.out.println("Objects are same and unique: Single Two "+singleTwo);
		}
	}
}

/*
Output:
Objects are same and unique: Single One SingletonLazyClass@15db9742
Objects are same and unique: Single Two SingletonLazyClass@15db9742
 */