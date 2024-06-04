/* Find array-index of two numbers from given integer array which has sum as given below target value.
Input Integer Array: {2,7,11,15}
Target = 9 
Output: [0,1]
*/

import java.util.*;

class ArrayIndexToTargetSum {
	public static void main(String args[]) {
		int numberArray[] = {2, 7, 11, 8, 15, 7, 0, 1};
		int target = 9;		
		List<Integer> list = new ArrayList<>();
		
		for (int i=0; i<numberArray.length; i++) {
			int diff = target - numberArray[i];
			if (list.contains(diff)) {
				System.out.println("Array-Index of two numbers = "+list.indexOf(diff) + ", "+i);
			} 
			list.add(numberArray[i]);
		}
	}
}

/*
Output:
Array-Index of two numbers = 0, 1
Array-Index of two numbers = 0, 5
Array-Index of two numbers = 3, 7
*/