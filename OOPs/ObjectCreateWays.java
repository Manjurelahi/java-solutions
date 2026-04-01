import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class ObjClass implements Cloneable, Serializable{
	private static final long serialVersionUID = 786L;
	private String str = "Hello World";
	
	public ObjClass(){}
	
	public void show() {
		System.out.println(str);
	}	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}	
}

public class ObjectCreateWays {
	public static void main(String[] args) {
		//1. Using New Operator
		ObjClass obj = new ObjClass();
		obj.show();
		
		//2. Using Class.forName and newInstance() Method of Class
		try {
			Class clazz = Class.forName("ObjClass");
			ObjClass clazzObj = (ObjClass)clazz.newInstance();
			clazzObj.show();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		//3. Using Cloneable Interface and Object.clone() method
		try {
			ObjClass cloneObj = (ObjClass) obj.clone();
			cloneObj.show();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		//4. Using Serialization and Deserialization of Object
		//Serialization Process
		try {
			ObjClass objToSer = new ObjClass();
			OutputStream outputStream = new FileOutputStream("ObjClassSer.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(objToSer);
			outputStream.close();
			objectOutputStream.close();			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Deserialization Process
		try {
			InputStream inputStream = new FileInputStream("ObjClassSer.txt");
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			ObjClass serObj = (ObjClass) objectInputStream.readObject();
			serObj.show();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//5. Using Reflection and newInstance Method of Constructor class
		try {
			Constructor<ObjClass> objClassConstrctor = ObjClass.class.getConstructor();
			ObjClass reflectionClass = objClassConstrctor.newInstance();
			reflectionClass.show();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}		
		
		//6. Using newInstance() Method of Class
		Class<ObjClass> clazz = ObjClass.class;
		try {
			ObjClass randomObj = (ObjClass) clazz.newInstance();
			randomObj.show();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}		
	}		
}
