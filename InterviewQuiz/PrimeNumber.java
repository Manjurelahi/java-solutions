// Write a java program to check if any number given as input is the sum of 2 prime numbers

import java.util.Scanner;

public class PrimeNumber {
    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i=2; i <= num-1; i++) {
            if (num%i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		System.out.println("Enter any number");
        int input = sc.nextInt();
        boolean sum = false;
        for (int i = 0; i < (input/2); i++) {
            if (isPrime(i) && (isPrime(input - i))) {
                System.out.println(input +" = "+i+" + "+(input - i));
                sum = true;
            }
        }
        if (!sum) {
            System.out.println("Input number "+input+" is not sum of any prime numbers");
        }
    }
}

/*
Output:
Enter any number
7
7 = 2 + 5
 */