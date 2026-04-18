import java.time.LocalDateTime;

// The default, no-argument constructor will simply set all members to their default values.

class DefaultConstructorFields {
	String strLiteral;
	String strObject = new String();
	long longNum;
	double doubleNum;
    Long longNumber;
	Double doubleNumber;
	LocalDateTime date;

	@Override
	public String toString() {
		return "DefaultConstructorFields{" +
				"strLiteral='" + strLiteral + '\'' +
				", strObject='" + strObject + '\'' +
				", longNum=" + longNum +
				", doubleNum=" + doubleNum +
				", longNumber=" + longNumber +
				", doubleNumber=" + doubleNumber +
				", date=" + date +
				'}';
	}

	public static void main(String args[]) {
		System.out.println(new DefaultConstructorFields());	
	}	
}

/*
Output
DefaultConstructorFields{strLiteral='null', strObject='', longNum=0, doubleNum=0.0, longNumber=null, doubleNumber=null, date=null}
*/