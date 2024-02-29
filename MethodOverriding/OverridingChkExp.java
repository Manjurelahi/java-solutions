class OceA{
    int a = 10;
    public void getColor() throws Exception {
        System.out.println("Parent");
    }
}

class OceB extends OceA{
    int a = 20;
	
	@Override
    public void getColor() throws java.io.IOException {
        System.out.println("Child");
    }
}

public class OverridingChkExp{
    public static void main(String args[]) throws Exception{
        OceA a = new OceB();
        OceB b = new OceB();
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