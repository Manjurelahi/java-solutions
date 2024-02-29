class OutcA{
    int a = 10;
    public void getColor() throws RuntimeException {
        System.out.println("Parent");
    }
}

class OutcB extends OutcA{
    int a = 20;
    public void getColor() throws java.io.IOException {
        System.out.println("Child");
    }
}

public class OverridingUnChkToChk{
    public static void main(String args[]) throws Exception{
        OutcA a = new OutcB();
        OutcB b = new OutcB();
        System.out.println("Value of a.a = "+a.a);
        System.out.println("Value of b.a = "+b.a);
        a.getColor();
        b.getColor();
    }
}

/*
Compile Error:
OverridingUnChkToChk.java:10: error: getColor() in OutcB cannot override getColor() in OutcA
    public void getColor() throws java.io.IOException {
                ^
  overridden method does not throw IOException
1 error
*/