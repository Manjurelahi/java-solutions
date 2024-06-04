/*
Write a Java program method to move or shift all zero numbers of below array to the ending of array
without changing insertion sequence of non-zero numbers.

Test Cases
1) Test Case
Input:  [0,0,1,7,9,0]
Output: [1,7,9,0,0,0]

2) Test Case
Input:  [4,3,1,2]
Output: [4,3,1,2]

3) Test Case
Input:  [2,0,6,7,8,1,4,0,9,0,3,2,1,0,5]
Output: [2,6,7,8,1,4,9,3,2,1,5,0,0,0,0]
 */

import java.util.Arrays;

public class MoveZeroToArrayEnd {
    public static void main(String[] args) {
        int[] numbersArray = {0,0,1,7,9,0};
        int nonZeroCount = -1;
        for (int i=0; i<numbersArray.length; i++) {
            int temp = numbersArray[i];
            if (temp != 0) {
                nonZeroCount++;
                numbersArray[i] = numbersArray[nonZeroCount];
                numbersArray[nonZeroCount] = temp;
            } else {
                numbersArray[i] = numbersArray[nonZeroCount + 1];
                numbersArray[nonZeroCount + 1] = temp;
            }
        }
        Arrays.stream(numbersArray).forEach(System.out::print);
    }
}