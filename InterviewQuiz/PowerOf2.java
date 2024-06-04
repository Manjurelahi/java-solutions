//Write a Java class method to check given input number is of power of 2 or not.

import java.util.*;

public class PowerOf2 {
	public static boolean isPowerOf2ByWhile(int number) {
		while (number != 1) {
			if (number%2 != 0) {
				return false;
			}
			number = number / 2;
		}
		return true;
	}
	
    public static boolean isPowerOf2ByRecursion(int number) {
		boolean powerOf2 = false;
		int answer = number / 2;
		int reminder = (number % 2);
		if (reminder != 0) {
			return false;
		} else if (answer == 1) {
			return true;
		} else {
			powerOf2 = isPowerOf2ByRecursion(answer);
		}		
        return powerOf2;
    }	

    public static void main(String[] args) {
        Arrays.asList(0, 1, 2, 4, 8, 16, 32, 64, 128, 130, 256, 260, 266, 275).stream().forEach(number -> {
			if (number != 0 && isPowerOf2ByWhile(number) && isPowerOf2ByRecursion(number)) {
				System.out.println(number+" is power of 2");
			} else {
				System.out.println(number+" is not power of 2");
			}
		});
	}
}

/*
Output:
0 is not power of 2
1 is not power of 2
2 is power of 2
4 is power of 2
8 is power of 2
16 is power of 2
32 is power of 2
64 is power of 2
128 is power of 2
130 is not power of 2
256 is power of 2
260 is not power of 2
266 is not power of 2
275 is not power of 2
*/