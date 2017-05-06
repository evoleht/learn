package com.evoleht.spring.aop.invoke.demo;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;


public class Demo {

	/**
	 * java反射测试学习demo。
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws NoSuchFieldException 
	 * @throws SecurityException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SecurityException, NoSuchFieldException, InstantiationException, IllegalAccessException {
//		Demo demo = new Demo();
//		System.out.println(demo.getClass().getName());
		
		//获取对象的所有属性 
		//获取整个类
		Class<?> pClass = Class.forName("test.aop.invoke.demo.Person");
		//获取所有的属性
		Field[] fs = pClass.getDeclaredFields();//
		
		StringBuffer sBuffer = new StringBuffer();
		
		//获取装饰符
		sBuffer.append(Modifier.toString(pClass.getModifiers()));
		//获取类名 简称
		sBuffer.append(" class " + pClass.getSimpleName() +"{\n");//回车
//		System.out.println(sBuffer.toString());
		//循环类属性
		for (int i = 0; i < fs.length; i++) {
			Field s = fs[i];
			sBuffer.append("\t"); //空格
			sBuffer.append(Modifier.toString(s.getModifiers()) + " " );//装饰符
			sBuffer.append(s.getType().getSimpleName() + " ");//属性类型
			sBuffer.append(s.getName() + ";\n");//属性名称
		}
		sBuffer.append("}");
		
		System.out.println(sBuffer.toString());
		
		
		//获取特定的属性
		//以前的方式
		Person person = new Person();
		person.setAge(12);
		System.out.println(person.getAge());
		
		
		//反射的方式
		//获取类
		Class<?> pc = Class.forName("test.aop.invoke.demo.Person"); 
		//获取age field
		Field fd = pc.getDeclaredField("age");
		
		//实例化这个类 给 object
		Object object  = pc.newInstance();
		//打破封装，使用 反射机制可以打破封装性，导致了java对象属性的不安全
		fd.setAccessible(true);
		//赋值
		fd.set(object, 20);
		//get
		System.out.println(fd.get(object));
		
	}

}
