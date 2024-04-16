/* Write a program which finds maximum difference between two values stored in below array:
{20, 10, 30, 40, 60, 50}
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ArrayQuiz {
    public static void main (String args[]) {
        int[] temp = {20, 10, 30, 40, 60, 50};
		Map<Integer, String> diffMap = new TreeMap<>();
        for (int i=0; i<temp.length; i++) {
            for (int j=i+1; j<temp.length; j++) {
                int diff = temp[j] - temp[i];
                if (diff > 0) {
                    diffMap.put(diff, temp[i]+","+temp[j]);
                }
            }
        }
        if (diffMap.size() == 0) {
            System.out.println("Max Difference: "+0);
        } else {
            System.out.println("Max Difference: "+diffMap.keySet().stream().max(Integer::compareTo).get());
        }
    }
}

// Output: Max Difference: 50