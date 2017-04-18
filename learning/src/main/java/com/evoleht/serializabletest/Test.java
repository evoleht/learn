package com.evoleht.serializabletest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Test implements Serializable{

	/**  **/
	private static final long serialVersionUID = 1L;
	
	public static int staticVar = 5;
	
	public static void main(String[] args) {
		try {
			//初始化时，staticVar的值为5
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test.class"));
			out.writeObject(new Test());
			out.close();
			
			//序列化之后值改为10
			Test.staticVar = 10;
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("test.class"));
		
			Test t = (Test) in.readObject();
			//再次读取后通打印staticVar的值
			System.out.println(t.staticVar);
			
			/**
			 * 之所以打印出10的原因在于序列化时，并不保存静态变量。
			 * 这其实比较容易理解，序列化保存的是对象的状态，而静态变量属于类状态，因此序列化并不保存静态变量。
			 * 
			 */
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
