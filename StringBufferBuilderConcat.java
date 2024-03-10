public class StringBufferBuilderConcat {
	public static void concatStringLiteralOrStringObject(String s) {
		s = s + " World";		
	}
	public static void concatStringBuffer(StringBuffer s) {
		s = s.append(" World");		
	}
	public static void concatStringBuilder(StringBuilder s) {
		s = s.append(" World");		
	}
	
	public static void main(String args[]){
		String s = "Hello";
		String sObj = new String("Hello");
		StringBuffer sbf = new StringBuffer("Hello");
		StringBuilder sbd = new StringBuilder("Hello");
		
		concatStringLiteralOrStringObject(s);
		concatStringLiteralOrStringObject(sObj);
		concatStringBuffer(sbf);
		concatStringBuilder(sbd);
		
		System.out.println("String Literal: "+s); //Not Changed
		System.out.println("String Object: "+sObj); //Not Changed
		System.out.println("StringBuffer: "+sbf); //Changed
		System.out.println("StringBuilder: "+sbd); //Changed
	}
}

/*
Output:
String Literal: Hello
String Object: Hello
StringBuffer: Hello World
StringBuilder: Hello World
 */