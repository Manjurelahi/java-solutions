class OapcA{
    int a = 10;
    public void getColor() throws NullPointerException {
        System.out.println("Parent");
    }
}

class OapcB extends OapcA{
    int a = 20;
    public void getColor() throws RuntimeException {
        System.out.println("Child");
    }
}

public class OverridingAssignParentToChild{
    public static void main(String args[]) throws Exception{
        OapcA a = new OapcB();
        OapcB b = new OapcB();
        System.out.println("Value of a.a = "+a.a);
        System.out.println("Value of b.a = "+b.a);
        a.getColor();
        b.getColor();
        
        OapcB oapcB = a;
        System.out.println("Value of oapcB.a = "+oapcB.a);
        oapcB.getColor();
        
        b=a;
        System.out.println("Value of b.a = "+b.a);
        b.getColor();
    }
}

/*
Compile Error:
OverridingAssignParentToChild.java:24: error: incompatible types: OapcA cannot be converted to OapcB
        OapcB oapcB = a;
                      ^
OverridingAssignParentToChild.java:28: error: incompatible types: OapcA cannot be converted to OapcB
        b=a;
          ^
2 errors
*/