// JDK8+ Code Test: Sort string array based on length - {"java", "spring", "hibernate", "angular", "docker", "react", "vue"}  

import java.util.*;
import java.util.Comparator;
import java.util.stream.*;

public class ComparatorComparingStringLength {
	public static void main(String[] args) {
		String[] strArr = {"java", "spring", "hibernate", "angular", "docker", "react", "vue"};
		Arrays.stream(strArr).sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);
	}
}

/* Output
hibernate
angular
spring
docker
react
java
vue
*/