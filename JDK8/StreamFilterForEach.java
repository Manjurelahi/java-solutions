import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Find the duplicate elements using streams 1,2,4,5,4,3,2 Answer : 2,4
 */

public class StreamFilterForEach {
    public static void main(String args[]) {
        int[] num = {1, 2, 4, 5, 4, 3, 2};
        Set<Integer> set = new HashSet<>();

        System.out.println("Using JDK 8 Approach 1 : Arrays Stream and ForEach : Duplicate Elements =>");
        Arrays.stream(num).forEach(i -> {
            if (!set.add(i)) {
                System.out.print(i + " ");
            }
        });
        set.clear();

        System.out.println("\nUsing JDK 8 Approach 2 : Arrays Stream, Filter & Method Reference : Duplicate Elements => ");
        Arrays.stream(num).filter(value -> !set.add(value)).forEach(System.out::println);
        set.clear();

        System.out.println("Using JDK 7 : Duplicate Elements => ");
        for (int i=0; i<num.length; i++) {
            if (!set.add(num[i])) {
                System.out.print(num[i] + " ");
            }
        }
        set.clear();
    }
}

/*
Output:
Using JDK 8 Approach 1 : Arrays Stream and ForEach : Duplicate Elements =>
4 2
Using JDK 8 Approach 2 : Arrays Stream, Filter & Method Reference : Duplicate Elements =>
4
2
Using JDK 7 : Duplicate Elements =>
4 2 
 */