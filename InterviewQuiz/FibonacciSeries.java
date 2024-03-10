// Fibonacci Series: The Fibonacci series is the sequence where each number is the sum of the previous two numbers of the sequence.

import java.util.Scanner;

class FibonacciSeries
{
	private static void generateFibonacciSeries(int term, int prevSecond, int prevFirst) {
		if (term < 3) {
			return;
		}
		//5 = 2+3
		//8 = 3+5
		int current = prevSecond + prevFirst;
		System.out.print(current + " ");
		prevSecond = prevFirst;
		prevFirst = current;
		generateFibonacciSeries(term-1, prevSecond, prevFirst);
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter term number upto which Fibonacci Series should generate numbers");
		int term = scanner.nextInt();
		if (term == 0 || term < 0) {
			System.out.println("Invalid Term Number");
		} else if (term == 1) {
			System.out.print("0");
		} else if (term == 2) {
			System.out.print("0 1");
		} else {
			System.out.print("0 1 ");
			generateFibonacciSeries(term, 0, 1);
		}
	}
}

/*
Output:
Enter term number upto which Fibonacci Series should generate numbers
10
0 1 1 2 3 5 8 13 21 34
 */