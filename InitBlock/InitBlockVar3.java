public class InitBlockVar3 {
	int i = 50;
	{
		i = 10;
		System.out.println("Init Block Var = " +i);
	}
	public InitBlockVar3() {
		i = 100;
		System.out.println("Constructor Var = " +i);
	}
	public static void main(String args[]) {
		InitBlockVar3 ibv = new InitBlockVar3();
	}
}

/*
Output:
Init Block Var = 10
Constructor Var = 100
*/