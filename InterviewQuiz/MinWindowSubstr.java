/*
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.

Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
*/

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MinWindowSubstr {
    static List<String> targetStringList = new ArrayList<>();
    private static boolean containsAllChars(String str, String t) {
        Map<String, Long> strMap = getCharsCount(str);
        Map<String, Long> tMap = getCharsCount(t);
        if (tMap.size() > strMap.size()) {
            return false;
        } else {
            for (Map.Entry<String, Long> entry : tMap.entrySet()) {
                String key = entry.getKey();
                Long value = entry.getValue();
                if (!strMap.containsKey(key) || !strMap.get(key).equals(value)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static Map<String, Long> getCharsCount(String str) {
        return Arrays.asList(str.split("")).stream().collect(Collectors.groupingBy(Function.identity(),
                LinkedHashMap::new, Collectors.counting()));
    }

    private static boolean checkSingleCharCount(String str, String t) {
        AtomicBoolean returnValue = new AtomicBoolean(true);
        Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()))
                .forEach((strLetter, count) -> {
                    if (t.contains(strLetter) && count > 1) {
                        returnValue.set(false);
                    }
                });
        return returnValue.get();
    }

    private static String getMinimumWindowSubString(String s, String t) {
        if (checkSingleCharCount(s, t)) {
            if (s.length() == t.length()) {
                return s;
            } else if (s.length() > t.length()) {
                if (s.length() == t.length() + 1) {
                    return s;
                } else if (s.length() == t.length() + 2) {
                    if (!List.of(t.split("")).contains(String.valueOf(s.charAt(0)))) {
                        return s.substring(1, s.length());
                    } else if (!List.of(t.split("")).contains(String.valueOf(s.charAt(s.length() - 1)))) {
                        return s.substring(0, s.length() - 1);
                    } else if (List.of(t.split("")).contains(String.valueOf(s.charAt(1)))) {
                        return s.substring(1, s.length());
                    } else if (List.of(t.split("")).contains(String.valueOf(s.charAt(s.length() - 2)))) {
                        return s.substring(0, s.length() - 1);
                    }
                }
            }
        } else {
            if (s.length() == t.length() + 2) {
                Map<String, Long> map = getCharsCount(s);
                String firstLetter = String.valueOf(s.charAt(0));
                String lastLetter = String.valueOf(s.charAt(s.length() - 1));
                if (t.contains(firstLetter) && t.contains(lastLetter)) {
                    if (map.containsKey(firstLetter) && map.get(firstLetter) > 1) {
                        return s.substring(1, s.length());
                    } else if (map.containsKey(lastLetter) && map.get(lastLetter) > 1) {
                        return s.substring(0, s.length() - 1);
                    }
                }
            }
        }
        return s;
    }

    public static String getMinWindowStr(String s, String t) {
        if (s.equals(t)) {
            return s;
        } else if (s.length() < t.length()) {
            return "";
        }

        int firstIndex = 0;
        int lastIndex = s.length();

        String firstString = "";
        String lastString = "";
        String middleString = "";

        for (int i=0; i<s.length(); i++) {
            firstString = s.substring(0, ++firstIndex);
            lastString = s.substring(--lastIndex, s.length());
            if (s.length() == 3) {
                middleString = s.substring(1, 2);
            }
            else if (firstIndex < (s.length()/2)) {
                middleString = s.substring(firstIndex, lastIndex);
            }
            if (firstString.length() >= t.length() && lastString.length() >= t.length()) {
                if (containsAllChars(firstString, t)) {
                    targetStringList.add(getMinimumWindowSubString(firstString, t));
                }
                if (containsAllChars(lastString, t)) {
                    targetStringList.add(getMinimumWindowSubString(lastString, t));
                }
            }
            if (middleString.length() >= t.length()) {
                if (containsAllChars(middleString, t)) {
                    targetStringList.add(getMinimumWindowSubString(middleString, t));
                }
                getMinWindowStr(middleString, t);
            }
        }
        Optional<String> target = targetStringList.stream().min(Comparator.comparing(String::length));
        if (target.isPresent()) {
            return target.get();
        }
        return "";
    }

    public static void main(String[] args) {
        //String s = "a";
        String s = "ADOBECODEBANC";
        //String s = "ADOBECODEBANCA";
        //String s = "ADOBECODEBANCA";
        //String s = "ABANCDOBECODE";
        //String s = "ADOBEBANCCODE";

        //String t = "a";
        //String t = "aa";
        String t = "ABC";

        targetStringList.clear();
        System.out.println(getMinWindowStr(s, t));
    }
}
