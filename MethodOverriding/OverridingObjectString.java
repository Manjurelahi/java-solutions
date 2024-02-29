package technotesjava.problemsolution;

class OosA {
	public void show(Object o) {
		System.out.println("Called from OosA: " + o);
	}
}

class OosB extends OosA {
	@Override
	public void show(String o) {
		System.out.println("Called from OosB: " + o);
	}
}

public class OverridingObjectString {
	public static void main(String args[]) {
		OosA a = new OosB();
		a.show("Hello World");

		OosB b = new OosB();
		b.show("Hello Earth");
	}
}

/*
Compile Error:
OverridingObjectString.java:10: error: method does not override or implement a method from a supertype
        @Override
        ^
1 error
*/