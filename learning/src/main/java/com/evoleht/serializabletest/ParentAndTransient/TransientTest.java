package com.evoleht.serializabletest.ParentAndTransient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class TransientTest implements Serializable{
	
	/**  **/
	private static final long serialVersionUID = 6080618427459444851L;
	
	private String name = "wang";
	private transient String password ="password";
	public static void main(String[] args) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("TransinentTest.obj"));
			out.writeObject(new TransientTest());
			out.flush();
			out.close();
			
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("TransinentTest.obj"));
			
			TransientTest test = (TransientTest) in.readObject();
			in.close();
			System.out.println(test.name);
			System.out.println(test.password);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
