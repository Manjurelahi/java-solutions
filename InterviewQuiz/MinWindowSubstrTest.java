public class MinWindowSubstrTest {
    public static void main(String[] args) {
        assertResult("BANC", MinWindowSubstr.getMinWindowStr("ADOBECODEBANC", "ABC"), "example window");
        assertResult("AABBC", MinWindowSubstr.getMinWindowStr("AAABBC", "AABC"), "duplicate target characters");
        assertResult("aa", MinWindowSubstr.getMinWindowStr("aaab", "aa"), "shortest repeated-character window");
        assertResult("", MinWindowSubstr.getMinWindowStr("a", "aa"), "insufficient repeated characters");
        assertResult("", MinWindowSubstr.getMinWindowStr("abc", "z"), "missing target character");
        assertResult("abc", MinWindowSubstr.getMinWindowStr("abc", "abc"), "exact match");
        assertResult("", MinWindowSubstr.getMinWindowStr("abc", ""), "empty target");
        assertResult("", MinWindowSubstr.getMinWindowStr(null, "a"), "null source");
        assertResult("a", MinWindowSubstr.getMinWindowStr("a", "a"), "independent repeated call");
        System.out.println("All MinWindowSubstr tests passed.");
    }

    private static void assertResult(String expected, String actual, String testName) {
        if (!expected.equals(actual)) {
            throw new AssertionError(testName + ": expected <" + expected + "> but was <" + actual + ">");
        }
    }
}
