public class FinallyReturn {
	public static int method() {
		try {
			return 2;
		}
		finally {
			return 1;
		}
	}	
	public static void main(String args[]) {
		System.out.println(method());
	}
}
// Output is 1
