/*
Merge and sort below two integer arrays into single integer array without repeated integers
int[] a = {8,9,7,4,2,5,6,7,1,0,3,5,7,6,4,6};
int[] b = {5,6,8,9,7,5,4,7,2,3,1,0,0,4,5,7};
 */

import java.util.Arrays;
import java.util.stream.IntStream;

public class IntStreamDistinctSorted {
    public static void main(String[] args) {
        int[] a = {8,9,7,4,2,5,6,7,1,0,3,5,7,6,4,6};
        int[] b = {5,6,8,9,7,5,4,7,2,3,1,0,0,4,5,7};
        int[] mergedDistinctSorted = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).distinct().sorted().toArray();
        Arrays.stream(mergedDistinctSorted).forEach(System.out::print);
    }
}

// Output: 0123456789

