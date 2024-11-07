/*
Anagram of a String Interview Question
An anagram of a string is another string that contains the same characters, only the order of characters can be different.
Input: {"eat","tea","tan","ate","nat","bat"}
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class AnagramStringByMap {
    public static void main(String[] args) {
        String[] orgStrList = {"eat","tea","tan","ate","nat","bat"};
        List<String> sortedCharStrList = new ArrayList<>();
        Arrays.stream(orgStrList).forEach(s -> {
            char[] chArray = s.toCharArray();
            Arrays.sort(chArray);
            sortedCharStrList.add(String.valueOf(chArray));
        });
        Map<String, Set<String>> orgStrMap = new TreeMap<>();
        for (int i=0; i<orgStrList.length; i++) {
            if (orgStrMap.containsKey(sortedCharStrList.get(i))) {
                orgStrMap.get(sortedCharStrList.get(i)).add(orgStrList[i]);
            } else {
                Set<String> anagramStrSet = new TreeSet<>();
                anagramStrSet.add(orgStrList[i]);
                orgStrMap.put(sortedCharStrList.get(i), anagramStrSet);
            }
        }
        orgStrMap.forEach((key, value) -> {
            System.out.println("\nSorted Character String: "+key);
            System.out.println("Anagram String Set");
            value.forEach(System.out::println);
        });
    }
}
/*
Output:

Sorted Character String: abt
Anagram String Set
bat

Sorted Character String: aet
Anagram String Set
ate
eat
tea

Sorted Character String: ant
Anagram String Set
nat
tan
 */