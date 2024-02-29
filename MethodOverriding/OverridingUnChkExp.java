class OcueA{
    int a = 10;
    public void getColor() throws Exception {
        System.out.println("Parent");
    }
}

class OcueB extends OcueA{
    int a = 20;
    public void getColor() throws RuntimeException {
        System.out.println("Child");
    }
}

public class OverridingUnChkExp{
    public static void main(String args[]) throws Exception{
        OcueA a = new OcueB();
        OcueB b = new OcueB();
        System.out.println("Value of a.a = "+a.a);
        System.out.println("Value of b.a = "+b.a);
        a.getColor();
        b.getColor();
    }
}

/*
Output:
Value of a.a = 10
Value of b.a = 20
Child
Child
*/