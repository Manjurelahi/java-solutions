public class CharIntASCII {
    public static void main(String[] args) {
        Integer number = new Integer(10);
        int value = number;
        System.out.println(value);

        Character A = new Character('A');
        char a = A;
        System.out.println(A);
        int intA = A;
        System.out.println(intA);
        int inta = a;
        System.out.println(inta);
    }
}

/*
Output:
10
A
65
65
 */