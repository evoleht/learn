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
			sub_s.setAge(11);
			sub_s.setUsername("li");
			sub_s.setDec("aaa");
			
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("sub.obj"));
			out.writeObject(sub_s);
			out.close();
			
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("sub.obj"));
			Sub sub = (Sub) in.readObject();
			in.close();
			System.out.println(sub.getDec());//子类实现了序列化，可以正常获取字段值
			System.out.println(sub.getUsername());//父类未实现序列化，字段值为类初始值
			System.out.println(sub.getAge());//父类未实现序列化，字段值为类初始值
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
