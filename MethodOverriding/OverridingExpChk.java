class OecA{
    int a = 10;
    public void getColor() throws java.io.IOException {
        System.out.println("Parent");
    }
}

class OecB extends OecA{
    int a = 20;
    public void getColor() throws Exception {
        System.out.println("Child");
    }
}

public class OverridingExpChk{
    public static void main(String args[]) throws Exception{
        OecA a = new OecB();
        OecB b = new OecB();
        System.out.println("Value of a.a = "+a.a);
        System.out.println("Value of b.a = "+b.a);
        a.getColor();
        b.getColor();
    }
}

/*
Compile Error:
OverridingExpChk.java:10: error: getColor() in OecB cannot override getColor() in OecA
    public void getColor() throws Exception {
                ^
  overridden method does not throw Exception
1 error
*/