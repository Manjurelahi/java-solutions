/*
Input = "aaabccccdd"
Output = "a3b1c4d2"
*/

import java.util.*;

public class CompressedString {
    public static void main(String[] args) {
        String input = "aaabccccdd";
        String[] strArray = input.split("");
        Map<String, Integer> map = new HashMap<>();
        for (String str: strArray) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        map.forEach((s, integer) -> System.out.print(s+integer));
	}
}