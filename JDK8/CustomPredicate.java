import java.util.function.Predicate;

class CustomPredicate {
	public static void main(String[] args) {
		Predicate<Integer> ifPositive = value -> value > 0;
		System.out.println(ifPositive.test(1)?"Postive":"Negative or Zero");
		System.out.println(ifPositive.test(-1)?"Postive":"Negative or Zero");
	}
}
/*
Output:
Postive
Negative or Zero
*/