public class UpperLowerString {
	public static void main(String args[]) {
		String str = new String("News");
		str.toUpperCase();
		System.out.println(str);
		String string = str;
		System.out.println(string);
		string = str.toUpperCase();
		System.out.println(string);
		System.out.println(string.toLowerCase());
	}
}

/*
Output:
News
News
NEWS
news
 */