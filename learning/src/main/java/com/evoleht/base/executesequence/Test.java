package com.evoleht.base.executesequence;

public class Test {
	public static void main(String[] args) {
		SuperClass subper = new SubClass();
		subper.test();
	}
}
/**
 *  类代码执行顺序:
 *  1.父类的静态变量、常量、静态代码块(先声明先执行)
 *  2.子类的静态变量、常量、静态代码块(先声明先执行)
 *  3.父类的非静态变量、代码块(先声明先执行)
 *  4.父类的构造方法
 *  5.子类的非静态变量、代码块(先声明先执行)
 *  6.子类的构造方法
 *  
 *  
 *  子类声明为父类对象，在调用重写方法时，调用的是自身的重写方法。
 *  
 *  
 */