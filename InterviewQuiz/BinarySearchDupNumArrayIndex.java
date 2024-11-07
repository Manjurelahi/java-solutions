/*
    Binary Search Algorithm Example
    Print all indexes of given repeating number from given sorted integer array without using for loop
*/

public class BinarySearchDupNumArrayIndex {
    public static void printRepeatingNumberIndexByBinarySearch(int[] numbers, int startIndex, int endIndex, int target) {
        if (startIndex > endIndex ) {
            return;
        }
        int middleIndex = startIndex + ((endIndex - startIndex) / 2);
        if (numbers[middleIndex] == target) {
            System.out.print(middleIndex + " ");
            printRepeatingNumberIndexByBinarySearch(numbers, startIndex , middleIndex - 1, target);
            printRepeatingNumberIndexByBinarySearch(numbers, middleIndex + 1 , endIndex, target);
        } else if (numbers[middleIndex] > target ) {
            printRepeatingNumberIndexByBinarySearch(numbers, startIndex, middleIndex - 1, target);
        } else if (numbers[middleIndex] < target) {
            printRepeatingNumberIndexByBinarySearch(numbers, middleIndex + 1, endIndex, target);
        }
    }
    public static void main(String[] args) {
        int[] numbers = {5,7,7,8,8,8,10};
        printRepeatingNumberIndexByBinarySearch(numbers, 0, numbers.length - 1, 8);
    }
}
//Output: 3 5 4