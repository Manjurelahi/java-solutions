public class StaticBlockVar {
	int i = 0;
	static {
		i = 10;
		System.out.println("Hello " + i + " times");
	}
	public static void main(String args[]) {
	}
}

/*
Compile Error: 
StaticBlockVar.java:4: error: non-static variable i cannot be referenced from a static context
                i = 10;
                ^
StaticBlockVar.java:5: error: non-static variable i cannot be referenced from a static context
                System.out.println("Hello " + i + " times");
                                              ^
2 errors
*/