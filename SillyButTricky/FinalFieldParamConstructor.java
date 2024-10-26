import java.util.*;
import java.time.*;

public class FinalFieldParamConstructor {
	private final String name = null;
	private final long longNumber = new Long(null);
	private final double doubleNumber = new Double(-1);
	private final List<Integer> numberList = Arrays.asList(1,2,3);
	private final LocalDateTime localDateTime = LocalDateTime.now();
	
	public FinalFieldParamConstructor (){};
	
	public FinalFieldParamConstructor (String name, long longNumber, double doubleNumber, 
										List<Integer> numberList, LocalDateTime localDateTime) {
		this.name = "";
		numberList.add(4);
		this.numberList.add(4);
	}
	
	public static void main(String args[]) {
		new FinalFieldParamConstructor();
	}	
}