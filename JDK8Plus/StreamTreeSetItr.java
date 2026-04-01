/*
Find the repeating and smallest positive missing number from below array:
{9, 8, 10, 1, 4, 6, 2, 3, 3, 5}
Output:
Repeating number is 3
Smallest positive missing number is 7.
 */

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class StreamTreeSetItr {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        int[] numArray = {9, 8, 10, 1, 4, 6, 2, 3, 3, 5};

        Arrays.stream(numArray).forEach(integer -> {
            if (!set.add(integer)) {
                System.out.println("Repeating number is " + integer);
            }
        });

        Iterator<Integer> itr = set.iterator();
        int min = itr.next();
        while (itr.hasNext()) {
            min++;
            if (itr.next() != min) {
                System.out.println("Smallest positive missing number is " + min);
                break;
            }
        }
    }
}

/* 
Output:
Repeating number is 3
Smallest positive missing number is 7
 */