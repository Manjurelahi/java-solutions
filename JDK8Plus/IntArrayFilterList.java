// Filter even integers from integer array and collect in list of integers

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntArrayFilterList {
    public static void main(String[] args) {
        int [] arr = {1, 4, 4, 8, 9, 9, 10};
        List<Integer> evenNumList = new ArrayList<>();
        Arrays.stream(arr).filter(value -> value%2 == 0).forEach(evenNumList::add);
        evenNumList.forEach(System.out::println);
    }
}

/*
Output:
4
4
8
10
 */