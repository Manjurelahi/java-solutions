public class StaticBlockException {
	static {
		System.out.println("This is a Static Block.");		
		try {
			Class.forName("static.block.checked.exception");
		} catch (ClassNotFoundException exception) {
			System.out.println("Static Block Checked ClassNotFoundException can not be thrown: "+exception.getMessage());
		}		
		System.out.println("1/0 = "+(1/0));
	}	
	public static void main(String[] args) {
		System.out.println("12/3 = "+(12/3));
	}
}

/*
Output
This is a Static Block.
Static Block Checked ClassNotFoundException Can Not Be Thrown: static.block.checked.exception
Exception in thread "main" java.lang.ExceptionInInitializerError
Caused by: java.lang.ArithmeticException: / by zero
        at StaticBlockException.<clinit>(StaticBlockException.java:9)
*/