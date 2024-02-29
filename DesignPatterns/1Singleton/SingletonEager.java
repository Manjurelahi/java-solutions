class SingletonEagerClass{
	private static final SingletonEagerClass singletonClass = new SingletonEagerClass();
	private SingletonEagerClass() {}
	public static SingletonEagerClass getInstance() {
		return singletonClass;
	}
}

public class SingletonEager {
	public static void main(String args[]) {
		SingletonEagerClass singleOne = SingletonEagerClass.getInstance();
		SingletonEagerClass singleTwo = SingletonEagerClass.getInstance();		
		//Comaparing above objects
		if(singleOne==singleTwo && singleOne.equals(singleTwo)) {
			System.out.println("Objects are same and unique: Single One "+singleOne);
			System.out.println("Objects are same and unique: Single Two "+singleTwo);
		}
	}
}
/*
Output:
Objects are same and unique: Single One SingletonEagerClass@15db9742
Objects are same and unique: Single Two SingletonEagerClass@15db9742
 */