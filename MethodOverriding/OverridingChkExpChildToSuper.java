class OcecsA{
    int a = 10;
    public void getColor() throws java.io.FileNotFoundException {
        System.out.println("Parent");
    }
}

class OcecsB extends OcecsA{
    int a = 20;
    public void getColor() throws java.io.IOException{
        System.out.println("Child");
    }
}

public class OverridingChkExpChildToSuper{
    public static void main(String args[]) throws Exception{
        OcecsA a = new OcecsB();
        OcecsB b = new OcecsB();
        System.out.println("Value of a.a = "+a.a);
        System.out.println("Value of b.a = "+b.a);
        a.getColor();
        b.getColor();
    }
}

/*
Compile Error:
OverridingChkExpChildToSuper.java:10: error: getColor() in OcecsB cannot override getColor() in OcecsA
    public void getColor() throws java.io.IOException{
                ^
  overridden method does not throw IOException
1 error
*/