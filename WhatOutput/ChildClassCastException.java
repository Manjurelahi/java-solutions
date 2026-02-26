class Animal {
	public void bark() {
		System.out.println("Animal barks");
	}
}
class Dog extends Animal {
	public void bark() {
		System.out.println("Dog barks");
	}
}
public class ChildClassCastException {
	public static void main(String[] args) {
		Animal animal = new Animal();
		Dog dog = (Dog) animal;
		dog.bark();		
	}
}

/*
Output
Exception in thread "main" java.lang.ClassCastException: class Animal cannot be cast to class Dog (Animal and Dog are in unnamed module of loader 'app')
        at ChildClassCastException.main(ChildClassCastException.java:14)
*/		