package com.technocrats.service;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialize {
	public static void serialize(Object obj) throws IOException {
		FileOutputStream fos = new FileOutputStream("Customer-List");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(obj);
		oos.close();
	}
	
	public static Object deserialize() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("Customer-List");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Object obj = ois.readObject();
		ois.close();
		
		return obj;
	}
}