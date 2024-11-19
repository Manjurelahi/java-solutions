//Reverse the given string array without for loop, Collection API and any in-build methods

public class StringArrayReverseByRecursion {
    public static void print(String[] strArray, int endIndex, int length) {
        if (length > 0) {
            if (length == 1) {
                System.out.print(strArray[0] + " ");
            } else if (endIndex > -1) {
                System.out.print(strArray[endIndex] + " ");
                endIndex = endIndex - 1;
                print(strArray, endIndex, length);
            }
        }
    }

    public static void main(String[] args) {
        String str = "today is holiday";
        String[] strArray = str.split(" ");
        int length = strArray.length;
        int endIndex = length - 1;
        print(strArray, endIndex, length);
    }
}

//Output: holiday is today