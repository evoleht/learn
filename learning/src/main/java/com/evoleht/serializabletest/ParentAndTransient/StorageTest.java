package com.evoleht.serializabletest.ParentAndTransient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class StorageTest implements Serializable{
	/**  **/
	private static final long serialVersionUID = 1L;
	public String name = "wang";
	public static void main(String[] args) {
		methodA();
		System.out.println("-------------------------------");
		methodB();
	}
	
	public static void methodA() {
		ObjectOutputStream out;
		try {
			out = new ObjectOutputStream(new FileOutputStream("result.obj"));
			StorageTest test = new StorageTest();
			StorageTest test2 = new StorageTest();
			//试图将对象两次写入文件
			out.writeObject(test);
			out.flush();
			System.out.println(new File("result.obj").length());
			out.writeObject(test);
			out.flush();
			System.out.println(new File("result.obj").length());
			out.writeObject(test2);
			out.close();
			System.out.println(new File("result.obj").length());
			
			ObjectInputStream oin = new ObjectInputStream(new FileInputStream(
					"result.obj"));
			//从文件依次读出两个文件
			StorageTest t1 = (StorageTest) oin.readObject();
			StorageTest t2 = (StorageTest) oin.readObject();
			StorageTest t3 = (StorageTest) oin.readObject();
			oin.close();
					
			//判断两个引用是否指向同一个对象
			System.out.println(t1 == t2);
			System.out.println(t2 == t3);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void methodB() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("result.obj"));
			StorageTest test = new StorageTest();
			test.name = "li";
			out.writeObject(test);
			out.flush();
			test.name = "liu";
			out.writeObject(test);
			out.close();
			ObjectInputStream oin = new ObjectInputStream(new FileInputStream(
								"result.obj"));
			StorageTest t1 = (StorageTest) oin.readObject();
			StorageTest t2 = (StorageTest) oin.readObject();
			System.out.println(t1.name);
			System.out.println(t2.name);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
