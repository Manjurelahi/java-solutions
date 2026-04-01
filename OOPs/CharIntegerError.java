public class CharIntegerError {
	public static void main(String[] args) {
		Character A = new Character('A');
        char a = A;
        System.out.println(A);
        int intA = A;
        System.out.println(intA);
        int inta = a;
        System.out.println(inta);
        Integer integerA = A;
        System.out.println(integerA);
        Integer integera = a;
        System.out.println(integera);
	}
}

/*
Output:
CharIntegerError.java:10: error: incompatible types: Character cannot be converted to Integer
        Integer integerA = A;
                           ^
CharIntegerError.java:12: error: incompatible types: char cannot be converted to Integer
        Integer integera = a;
                           ^
2 errors
*/