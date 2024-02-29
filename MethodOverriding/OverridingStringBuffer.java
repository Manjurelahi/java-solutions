class OsbA{
	public void show(String str) {
		System.out.println("Called method from OsbA: "+str);		
	}
}

class OsbB extends OsbA{
	@Override
	public void show(StringBuffer str) {
		System.out.println("Called method from OsbB: "+str);	
	}
}

public class OverridingStringBuffer {
	public static void main(String args[]) {
		OsbA a = new OsbB();
		a.show("Hello Word");
		
		OsbB b = new OsbB();
		b.show("Hello Earth");
	}
}

/*
Compile Error:
OverridingStringBuffer.java:8: error: method does not override or implement a method from a supertype
        @Override
        ^
1 error
*/