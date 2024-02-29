class OctuA{
    int a = 10;
    public void getColor() throws java.io.IOException {
        System.out.println("Parent");
    }
}

class OctuB extends OctuA{
    int a = 20;
    public void getColor() throws RuntimeException {
        System.out.println("Child");
    }
}

public class OverridingChkToUnChk{
    public static void main(String args[]) throws Exception{
        OctuA a = new OctuB();
        OctuB b = new OctuB();
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