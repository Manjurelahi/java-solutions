class OacpA{
    int a = 10;
    public void getColor() throws NullPointerException {
        System.out.println("Parent");
    }
}

class OacpB extends OacpA{
    int a = 20;
    public void getColor() throws RuntimeException {
        System.out.println("Child");
    }
}

public class OverridingAssignChildToParent{
    public static void main(String args[]) throws Exception{
        OacpA a = new OacpB();
        OacpB b = new OacpB();
        System.out.println("Value of a.a = "+a.a);
        System.out.println("Value of b.a = "+b.a);
        a.getColor();
        b.getColor();
        
        OacpA oacpA = b;
        System.out.println("Value of oacpA.a = "+oacpA.a);
        oacpA.getColor();
        
        a=b;
        System.out.println("a=b, Value of a.a = "+a.a);
        a.getColor();
    }
}

/*
Output:
Value of a.a = 10
Value of b.a = 20
Child
Child
Value of oacpA.a = 10
Child
a=b, Value of a.a = 10
Child
*/