/*
Input List = [10, 20, 30, 40, 50]
Rotate Index = 2
Output List = [30, 40, 50, 10, 20]
Rotate Index = 3
Output List = [40, 50, 10, 20, 30]
 */

import java.util.*;

public class RotateListByIndex {
    public static List<Integer> rotateList(int rotate, List<Integer> numbersList) {
        Map<Integer, Integer> targetMap = new LinkedHashMap<>();
        for(int index=0; index<numbersList.size(); index++) {
            if (rotate >= (numbersList.size())) {
                targetMap.put(index, numbersList.get(rotate - (numbersList.size())));
            } else {
                targetMap.put(index, numbersList.get(rotate));
            }
            rotate++;
        }
        return targetMap.values().stream().toList();
    }
    public static void main(String[] args) {
        List<Integer> numbersList = List.of(10, 20, 30, 40, 50);
        System.out.println(rotateList(2, numbersList));
        System.out.println(rotateList(3, numbersList));
    }
}

/*
Output
[30, 40, 50, 10, 20]
[40, 50, 10, 20, 30]
*/
