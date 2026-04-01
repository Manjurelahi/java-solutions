public class NullStaticDemo {
	public static void method() {
		System.out.println("Static Method Called");
	}	
	public static void main(String args[]) {
		NullStaticDemo nullStaticDemo = null;
		nullStaticDemo.method();
	}
}
//Output: Static Method Called