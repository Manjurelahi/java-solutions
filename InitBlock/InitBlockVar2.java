public class InitBlockVar2 {
	int i = 0;
	{
		i = 10;
		System.out.println("Init Block Var = " +i);
	}
	public static void main(String[] args) {
		InitBlockVar2 ibv = new InitBlockVar2();
	}
}

/*
Output:
Init Block Var = 10
*/