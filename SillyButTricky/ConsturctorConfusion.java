/*
Java Class Constructor Rules
1. Java class constructor name must match the Java class name.
2. Java class constructor has no return type.
3. Java class constructor implicitly return the type of the object that it creates.
*/



class ConstructorConfusion {
	private void ConstructorConfusion() {
		System.out.println("Method called with return type.");
	}
	
	private ConstructorConfusion() {
		System.out.println("Constructor called.");
	}
	
	public static void main(String args[]) {
			ConstructorConfusion cc = new ConstructorConfusion();
			cc.ConstructorConfusion();
	}	
}

/*
Output:
Constructor called.
Method called with return type.
*/