package com.evoleht.spring.aop.invoke.demo2;


public class User {
	
	public String name;
	public String age;
	
	public User() {
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	public static String getInfo(String name,String age) {
		return "姓名：" + name + "-----" + "年龄：" +age;
	}
	
}
