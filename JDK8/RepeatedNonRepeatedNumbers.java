import java.util.*;
import java.util.stream.*;

public class RepeatedNonRepeatedNumbers {
	public static void main(String[] args) {
		int[] numbers = {3,1,2,5,2,3,2,4,1,2,3,3};
		Map<Integer, Integer> map = new TreeMap<>();
		
		Arrays.stream(numbers).forEach( num -> {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		});
		
		System.out.print("Repeated Numbers: ");
		map.forEach((key, value) -> {
			if (map.get(key) > 1) {
				System.out.print(key + " ");
			}
		});
		
		System.out.print("\nNon-Repeated Numbers: ");
		map.forEach((key, value) -> {
			if (map.get(key) == 1) {
				System.out.print(key + " ");
			}
		});		
	}
}
/*
Output:
Repeated Numbers: 1 2 3
Non-Repeated Numbers: 4 5
*/