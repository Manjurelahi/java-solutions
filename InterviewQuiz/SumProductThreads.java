/*
Implement a Java application that demonstrates multithreading. Your application should create two threads:

One for calculating the sum of numbers from 1 to 1000.
Another for calculating the product of numbers from 1 to 10.
Ensure proper synchronization is implemented to avoid data inconsistency when the threads access shared resources. Print the results upon completion.
*/
class Calculator {
	int sum = 0;
	int product = 0;
	public synchronized void calculate(String operation, int end) {
		int result = 1;
		for (int i=1; i<=end; i++) {
			if ("+".equals(operation) & i!=1) {
				result = result + i;
			} else {
				result = result * i;
			}
		}		
		if ("+".equals(operation)) {
			this.sum = result;
		} else {
			this.product = result;
		}
	}
	public void printResults() {
		System.out.println("Sum is "+sum);
		System.out.println("Product is "+product);
	}
}
public class SumProductThreads {
	public static void main(String[] args) throws InterruptedException {
		Calculator calc = new Calculator();
		Thread sumThread = new Thread(()-> calc.calculate("+", 100));
		Thread productThread = new Thread(()-> calc.calculate("*", 10));
		sumThread.start();		
		productThread.start();
		sumThread.join();
		calc.printResults();
	}
}