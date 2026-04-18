import java.util.*;
import java.time.*;

public class FinalFieldParamConstructor {
    private String nonFinalString;
    private final String finalString;
    private final long longNumber = new Long(786L);
    private final double doubleNumber = new Double(-1d);
    private final List<Integer> numberList = Arrays.asList(1, 2, 3);
	private final static List<Integer> numberArrayList = new ArrayList<>();
    private final LocalDateTime localDateTime = LocalDateTime.now();

    public FinalFieldParamConstructor() {
		this.finalString = "Final String - Default Constructor";
		numberArrayList.add(4);
    }

    public FinalFieldParamConstructor(final String finalString, final List<Integer> numberArrayList) {
		this.finalString = finalString;
		numberArrayList.add(5);
    }

    @Override
    public String toString() {
        return "FinalFieldParamConstructor{" +
                "nonFinalString='" + nonFinalString + '\'' +
                ", finalString='" + finalString + '\'' +
                ", longNumber=" + longNumber +
                ", doubleNumber=" + doubleNumber +
                ", numberList=" + numberList +
				", numberArrayList=" + numberArrayList +
                ", localDateTime=" + localDateTime +
                '}';
    }

    public static void main(String args[]) {
		System.out.println(new FinalFieldParamConstructor());
        System.out.println(new FinalFieldParamConstructor("Final String - Parameter Based Constructor",
			numberArrayList));
    }
}

/*
Output
FinalFieldParamConstructor{nonFinalString='null', finalString='Final String - Default Constructor', longNumber=786, doubleNumber=-1.0, numberList=[1, 2, 3], numberArrayList=[4], localDateTime=2026-04-18T21:55:45.427}
FinalFieldParamConstructor{nonFinalString='null', finalString='Final String - Parameter Based Constructor', longNumber=786, doubleNumber=-1.0, numberList=[1, 2, 3], numberArrayList=[4, 5], localDateTime=2026-04-18T21:55:45.442}
*/