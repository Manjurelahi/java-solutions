public class ThrowExpInRunExpCatch {
  public static void main(String[] args) throws Exception {
    try{
      String a = null;
      System.out.println(a.length());      
    } catch (NullPointerException e){
      e.printStackTrace();
      System.out.println("Null Pointer Exception Handled");
      throw new Exception("New Custom Exception thrown");
    }
  }
}

/*
Runtime Exception Output:
java.lang.NullPointerException
        at ThrowExpInRunExpCatch.main(ThrowExpInRunExpCatch.java:5)
Null Pointer Exception Handled
Exception in thread "main" java.lang.Exception: New Custom Exception thrown
        at ThrowExpInRunExpCatch.main(ThrowExpInRunExpCatch.java:9)

*/