/*
Write a java program method which takes string array and returns that string array sorted by string length in ascending or descending order.
Do not use any in-build util or collection classes or API from Java JDK.
This is also an example of Insertion Sorting Algorithm.
*/

public class StringArrayInsertionSort {
    public static void sortByStringLengthAscOrder(String[] strArr) {
        sortByStringLength(strArr, false);
    }

    public static void sortByStringLengthDescOrder(String[] strArr) {
        sortByStringLength(strArr, true);
    }

    private static void sortByStringLength(String[] strArr, boolean descOrder) {
        for (int i=1; i<strArr.length; i++) {
            String str = strArr[i];
            int j = i-1;
            while (j >= 0
                    && (descOrder ? str.length() > strArr[j].length()
                    : str.length() < strArr[j].length())) {
                strArr[j+1] = strArr[j];
                j--;
            }
            strArr[j+1] = str;
        }
    }
    public static void main(String[] args) {
        String[] fruitArray = {"banana", "apple", "orange", "grape", "pineapple", "kiwi", "mango"};
        System.out.println("Ascending Order");
        sortByStringLengthAscOrder(fruitArray);
        for (int i=0; i<fruitArray.length; i++) {
            System.out.println(fruitArray[i]);
        }
        System.out.println("\nDescending Order");
        sortByStringLengthDescOrder(fruitArray);
        for (int i=0; i<fruitArray.length; i++) {
            System.out.println(fruitArray[i]);
        }
    }
}

/*
Output:
Ascending Order
kiwi
apple
grape
mango
banana
orange
pineapple

Descending Order
pineapple
banana
orange
apple
grape
mango
kiwi
 */