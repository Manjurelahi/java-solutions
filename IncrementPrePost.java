public class IncrementPrePost {
  public static void main(String[] args) {    
    int i = 0;
    int j = 0;    
   	System.out.println("Value of Post Increment i++ is "+ i++);    
   	System.out.println("Value of i is "+i);
    System.out.println("Value of Pre Increment ++j is "+ ++j);    
   	System.out.println("Value of j is "+j);
  }
}

/*
Output:
Value of Post Increment i++ is 0
Value of i is 1
Value of Pre Increment ++j is 1
Value of j is 1
*/