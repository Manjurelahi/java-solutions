enum Week {
	SUN, MON, TUE, WED, THU, FRI, SAT
}

public class EnumUseClass {
	public static void main(String[] args) {
		System.out.println("Length of Week is "+Week.values().length);
		for(int i=0; i<Week.values().length; i++) {
			System.out.println(Week.values()[i]);
		}
	}
}

/*
Output:
Length of Week is 7
SUN
MON
TUE
WED
THU
FRI
SAT
 */