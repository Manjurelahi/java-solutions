import java.io.IOException;

class A{
	int i = 1;
	private void show() throws Exception {System.out.println("Value of i from A is "+i);}
}

class B extends A{
	int i = 2;
	
	@Override
	private void show() throws IOException {System.out.println("Value of i from B is "+i);}
}

public class OverridingPrivateMethod {
	public static void main(String args[]) {
		A a = new B();
		System.out.println("i is "+a.i);
		a.show();
	}
}

/*
Compile Error:
OverridingPrivateMethod.java:11: error: method does not override or implement a method from a supertype
        @Override
        ^
OverridingPrivateMethod.java:19: error: show() has private access in A
                a.show();
                 ^
2 errors
 */
