class MainOverload {
	public void main(Character[] args){
		System.out.println("Overloaded Non-Static Main Method");
	}
	
	public static void main(Object[] args){
		System.out.println("Overloaded Main Method");
	}
	
	public static void main(String[] args) {
		System.out.println("Main Method");
		Character[] charArray = new Character[] {'A','B','C'};
		main((Object[])charArray);
		MainOverload mainOverload = new MainOverload();						
		mainOverload.main(charArray);		
	}
}

/*
Output
Main Method
Overloaded Main Method
Overloaded Non-Static Main Method
*/