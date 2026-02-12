// JDK8+ Code Test: Find first non-repeating character from String = ADBBCCCEEACGBGXHHS 

import java.util.*;
import java.util.stream.*;
import java.util.function.Function;

public class CollectorLinkedHashMap {
	public static void main(String[] args) {
		String str = "ADBBCCCEEACGBGXHHS";
		System.out.println(Arrays.stream(str.split(""))
			.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
			.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst().get().getKey());
	}
}

// Output: D

