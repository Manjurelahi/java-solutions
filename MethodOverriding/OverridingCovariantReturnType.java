class OcrtA {
	public Object method() {
		System.out.println("Return Type is Object");
		return new Object();
	}
}

class OcrtB extends OcrtA {
	@Override
	public String method() {
		System.out.println("Return Type is String");
		return "";
	}		
}

public class OverridingCovariantReturnType {
	public static void main(String[] args) {
		OcrtA a = new OcrtA();
		OcrtB b = new OcrtB();
		a.method();
		b.method();
	}
}

/*
Output:
Return Type is Object
Return Type is String
*/