class OsA{
	public static int calculate(int a, int b) {
		return a + b;
	}
}
class OsB extends OsA{
	@Override
	public static int calculate(int a, int b) {
		return a + b + 100;
	}
}
public class OverridingStatic {
	public static void main(String args[]) {
		System.out.println(OsB.calculate(50, 50));
	}
}

/*
Compile Error:
OverridingStatic.java:7: error: method does not override or implement a method from a supertype
        @Override
        ^
1 error
 */

