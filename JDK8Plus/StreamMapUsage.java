import java.util.*;
import java.util.stream.*;

class StreamMapUsage {
	public static void main(String[] args) {
		String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		Arrays.stream(days).map(day -> day.toUpperCase()).forEach(System.out::println);
	}
}
/*
Output:
SUNDAY
MONDAY
TUESDAY
WEDNESDAY
THURSDAY
FRIDAY
SATURDAY
*/