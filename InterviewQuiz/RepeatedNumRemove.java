import java.util.*;

public class RepeatedNumRemove {
    public static Integer getMaxNumAfterRemovalRepeatedOneChar(String numStr) {
        String[] numStrArr = numStr.split(" ");
        String num = numStrArr[0];
        String repeatedNum = numStrArr[1];
        char[] numChars = num.toCharArray();
        TreeSet<Integer> afterRemoveSet = new TreeSet<>();
        if (num.length() > 1 && num.contains(repeatedNum)) {
            for (int i = 0; i < numChars.length; i++) {
                if (String.valueOf(numChars[i]).equals(repeatedNum) && i!=0) {
                    String newStr = "";
                    afterRemoveSet.add(Integer.parseInt(newStr + num.substring(0, i-1) + num.substring(i)));
                }
            }
        }
        return afterRemoveSet.last();
    }
    public static void main(String[] args) {
        System.out.println("Please enter any space separated number string and repeated number");
        Scanner sc = new Scanner(System.in);
        String numStr = sc.nextLine();
        System.out.println(getMaxNumAfterRemovalRepeatedOneChar(numStr));
    }
}
