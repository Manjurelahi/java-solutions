enum SingletonEnumClass {
	INSTANCE;
	
	int value;
	
	public void show() {
		System.out.println("Value is "+value);
	}
}

public class SingletonEnum {
	public static void main(String[] args) {
		SingletonEnumClass singleOne = SingletonEnumClass.INSTANCE;
		singleOne.value = 1;
		singleOne.show();
		
		SingletonEnumClass singleTwo = SingletonEnumClass.INSTANCE;
		singleTwo.value = 2;
		singleOne.show();
		
		System.out.println("singleOne.hashCode = "+singleOne.hashCode());
		System.out.println("singleTwo.hashCode = "+singleTwo.hashCode());
	}
}

/*
Output:
Value is 1
Value is 2
singleOne.hashCode = 366712642
singleTwo.hashCode = 366712642
 */
