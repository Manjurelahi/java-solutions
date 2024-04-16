public class StringReverse {
    private String reversedString = "";
    
	public String getReversedString() {
        return reversedString;
    }

    public void setReversedString(String reversedString) {
        this.reversedString = reversedString;
    }

    public String reverseStringUsingRecursion(String str) {
        if (null == str) {
            System.out.println("String is null");
        } else if (!str.isEmpty() && str.length() == 1) {
            setReversedString(getReversedString() + str);
        } else {
            setReversedString(getReversedString() + str.charAt(str.length() - 1));
            reverseStringUsingRecursion(str.substring(0, str.length() - 1));
        }
        return getReversedString();
    }

    public static void main (String[] args) {
        StringReverse sr = new StringReverse();
		String str = null;
        sr.reverseStringUsingRecursion(str);
        sr.setReversedString("");
        str = "a";
        System.out.println(sr.reverseStringUsingRecursion(str));
        sr.setReversedString("");
        str = "ab";
        System.out.println(sr.reverseStringUsingRecursion(str));
        sr.setReversedString("");
        str = "abc";
        System.out.println(sr.reverseStringUsingRecursion(str));
        sr.setReversedString("");
        str = "abcdef";
        System.out.println(sr.reverseStringUsingRecursion(str));
        sr.setReversedString("");
        str = "123abc";
        System.out.println(sr.reverseStringUsingRecursion(str));
        sr.setReversedString("");
        str = "cba321";
        System.out.println(sr.reverseStringUsingRecursion(str));
    }
}

/*
Output:
String is null
a
ba
cba
fedcba
cba321
123abc
 */