class OeucA{
    int a = 10;
    public void getColor() throws RuntimeException {
        System.out.println("Parent");
    }
}

class OeucB extends OeucA{
    int a = 20;
    public void getColor() throws Exception {
        System.out.println("Child");
    }
}

public class OverridingExpUnChk{
    public static void main(String args[]) throws Exception{
        OeucA a = new OeucB();
        OeucB b = new OeucB();
        System.out.println("Value of a.a = "+a.a);
        System.out.println("Value of b.a = "+b.a);
        a.getColor();
        b.getColor();
    }
}

/*
Compile Error:
OverridingExpUnChk.java:10: error: getColor() in OeucB cannot override getColor() in OeucA
    public void getColor() throws Exception {
                ^
  overridden method does not throw Exception
1 error
*/