package com.evoleht.spring.aop.invoke.demo2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokeTest {
	
	public static void main(String[] args) {
		try {
			
			Class c = Class.forName("test.aop.invoke.demo2.User");
			Object o = c.newInstance();
			Method m =  c.getDeclaredMethod("getName", null);
			
			Method m1 = c.getMethod("setName",new Class[]{String.class});
			
			System.out.println(m.toString());
			
			Object ret = m1.invoke(o, new Object[]{"反射"});
			
			System.out.println("test.aop.invoke.demo2.User.setName() = " + ret);
			
			ret = m.invoke(o, null);
			
			System.out.println("test.aop.invoke.demo2.User.getName() = " + ret);
			
			Field f[] = c.getFields();
			
			for (int i = 0; i < f.length; i++) {
				System.out.println(f[i].toString());
			}
			
			Method m2 = c.getMethod("getInfo", new Class[]{String.class,String.class});
			
			ret = m2.invoke(c, new Object[]{"王小一","28"});
			
			System.out.println(ret);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
