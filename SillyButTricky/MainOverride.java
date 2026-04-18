class A {
	public static void main(String[] args) {
		System.out.println("Class A - Main Method");
	}
}

class B extends A {
	public static void main(String[] args) {
		System.out.println("Class B - Main Method");
	}
}

class MainOverride {
	public static void main(String[] args) {
		String[] strArray = {"A", "B", "MainOverride"};
		A.main(strArray);
		B.main(strArray);
		A a = new B();
		a.main(strArray);
		B b = new B();
		b.main(strArray);
		a = b;
		a.main(strArray);
		((A)b).main(strArray);
		((B)a).main(strArray);
	}
}

/*
Output
Class A - Main Method
Class B - Main Method
Class A - Main Method
Class B - Main Method
Class A - Main Method
Class A - Main Method
Class B - Main Method
*/