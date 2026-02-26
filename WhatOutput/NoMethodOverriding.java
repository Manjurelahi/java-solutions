class A {
	public void show(Object object) {
		System.out.println("Class A");
	}
}

class B extends A {
	public void show(String string) {
		System.out.println("Class B");
	}
}

public class NoMethodOverriding {
	public static void main(String[] args) {
		A a = new B();
		a.show("Test");
	}
}

// Output: Class A
// Explanation: The show method is not overridden method in class B.