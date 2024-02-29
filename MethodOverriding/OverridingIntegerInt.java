class OiiA {
	public void show(Integer i) {
		System.out.println("Called show method of OiiA: " + i);
	}
}

class OiiB extends OiiA {
	@Override
	public void show(int i) {
		System.out.println("Called show method of OiiB: " + i);
	}
}

public class OverridingIntegerInt {
	public static void main(String args[]) {
		OiiA a = new OiiB();
		a.show(5);

		OiiB b = new OiiB();
		b.show(10);
	}
}

/*
Compile Error:
OverridingIntegerInt.java:8: error: method does not override or implement a method from a supertype
        @Override
        ^
1 error
*/
