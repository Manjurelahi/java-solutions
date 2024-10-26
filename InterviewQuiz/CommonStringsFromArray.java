/*
Find longest common substring in an array of strings

1. Test Case
Input: ["armania", "arora", "area"]
Output: ar

2. Test Case
Input: ""
Output: No common string found

3. Test Case
Input: ["graceful", "disgraceful", "grace", "gracefully"]
Output: grace

4. Test Case
Input: ["sadness", "sad", "sadly"]
Output: sad 
*/

public class CommonStringsFromArray {
	private static String getCommonStrings(String[] strings) {
		String anyString = strings[0];
		int strArrayLength = strings.length;
		String longCommonString = "";

		// Create Substrings and check in other strings of array
		for (int i=0; i < anyString.length(); i++) {
			for (int j = i+1; j <= anyString.length(); j++) {
				String subStr = anyString.substring(i, j);
				int k = 0;
				for (k = 0; k < strArrayLength; k++) {
					if (!strings[k].contains(subStr)) {
						break;
					}
				}
				if (k == strArrayLength && longCommonString.length() < subStr.length()) {
					longCommonString = subStr;
				}
			}
		}
		return longCommonString;
	}
	
	public static void main(String[] args) {
		String[] strArray = {"graceful", "disgraceful", "grace", "gracefully"};
		String longCommonString = getCommonStrings(strArray);
		if (!longCommonString.isEmpty()) {
			System.out.println(longCommonString);
		} else {
			System.out.println("No longest common string found");
		}
	}
}