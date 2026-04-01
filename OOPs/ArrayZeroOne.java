public class ArrayZeroOne {
	public static void main(String args[]) {
		int intArray [] = {0,1,0,0,1,0,0,1,1,1,0,0,1,1};
		int zeroCount = 0;
		for(int i=0; i<intArray.length; i++) {
			if(intArray[i]==0) {
				zeroCount++;
			}
		}
		for(int i=0; i<zeroCount; i++) {
			intArray[i] = 0;
		}
		for(int i=zeroCount; i<intArray.length; i++) {
			intArray[i] = 1;
		}
		for(int i=0; i<intArray.length; i++) {
			System.out.print(intArray[i]);
		}		
	}
}

/*
 * Output:
 * 00000001111111
 */