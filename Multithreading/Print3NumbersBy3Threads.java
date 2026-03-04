/*
 Print three numbers sequentially from below array by using three threads.
 {7,8,6,9,2,11,0,0,7}
*/

class PrintNumber {
	public synchronized void print(int[] numbers, int index) {
		System.out.print(numbers[index] + ",");
		System.out.print(numbers[index + 1] + ",");
		System.out.println(numbers[index + 2]);
	}
}

class PrintNumberThread extends Thread {
	int[] numbers;
	int index;
	PrintNumber printNumber = null;
		
	public PrintNumberThread(int[] numbers, int index, PrintNumber printNumber) {
		this.numbers = numbers;
		this.index = index;
		this.printNumber = printNumber;
	}
	
	@Override
	public void run() {
		printNumber.print(numbers, index);
		
	}
}

public class Print3NumbersBy3Threads {
	public static void main(String[] args) throws Exception {
		int[] numbers = {7,8,6,9,2,11,0,0,7};
		PrintNumber printNumber = new PrintNumber();
		
		PrintNumberThread thread1 = new PrintNumberThread(numbers, 0, printNumber);
		PrintNumberThread thread2 = new PrintNumberThread(numbers, 3, printNumber);
		PrintNumberThread thread3 = new PrintNumberThread(numbers, 6, printNumber);
		
		thread1.start();
		thread1.join();
		thread2.start();
		thread2.join();
		thread3.start();		
	}
}

/*
7,8,6
9,2,11
0,0,7
*/