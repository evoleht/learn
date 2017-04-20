package com.evoleht.serializabletest.ParentAndTransient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {
	
	public static void main(String[] args) {
		try {
			Sub sub_s = new Sub();
			sub_s.setAge(22);//年龄set 22岁
			sub_s.setUsername("li");
			sub_s.setDec("li is a man");
			
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("sub.obj"));
			out.writeObject(sub_s);
			out.close();
			
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("sub.obj"));
			Sub sub = (Sub) in.readObject();
			in.close();
			System.out.println(sub.getDec());
			System.out.println(sub.getUsername());
			System.out.println(sub.getAge());
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
