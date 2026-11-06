import java.util.HashMap;
import java.util.Map;

/**
 * Finds the shortest substring containing every character in the target,
 * including repeated characters. Returns an empty string when no window exists.
 */
public class MinWindowSubstr {
    public static String getMinWindowStr(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty() || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> remaining = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char character = t.charAt(i);
            remaining.put(character, remaining.getOrDefault(character, 0) + 1);
        }

        int missing = t.length();
        int left = 0;
        int bestStart = 0;
        int bestLength = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            char rightCharacter = s.charAt(right);
            if (remaining.containsKey(rightCharacter)) {
                // Negative counts represent target characters already covered more than once.
                int count = remaining.get(rightCharacter) - 1;
                remaining.put(rightCharacter, count);
                if (count >= 0) {
                    missing--;
                }
            }

            while (missing == 0) {
                int windowLength = right - left + 1;
                if (windowLength < bestLength) {
                    bestStart = left;
                    bestLength = windowLength;
                }

                char leftCharacter = s.charAt(left++);
                if (remaining.containsKey(leftCharacter)) {
                    int count = remaining.get(leftCharacter) + 1;
                    remaining.put(leftCharacter, count);
                    if (count > 0) {
                        missing++;
                    }
                }
            }
        }

        return bestLength == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLength);
    }

    public static void main(String[] args) {
        System.out.println(getMinWindowStr("ADOBECODEBANC", "ABC"));
    }
}
