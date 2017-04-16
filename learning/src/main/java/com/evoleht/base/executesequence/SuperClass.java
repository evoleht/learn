package com.evoleht.base.executesequence;

public class SuperClass {
	public static int super_num;
	public static int super_num_v = 11;
	public int super_field;
	public int super_field_v = 3;
	
	static {
		System.out.println("父类静态块执行!");
		System.out.println("静态未初始化sub_num="+super_num);
		System.out.println("静态初始化sub_num_v="+super_num_v);
		System.out.println("静态代码块中无法调用非静态的属性");
	}
	
	{
		System.out.println("父类非静态块执行！");
		System.out.println("静态未初始化sub_num="+super_num);
		System.out.println("静态初始化sub_num_v="+super_num_v);
		System.out.println("非静态未初始化化sub_field="+super_field);
		System.out.println("非静态未初始化化sub_field_v="+super_field_v);
	}
	
	public SuperClass() {
		System.out.println("父类构造方法执行！");
		System.out.println("静态未初始化sub_num="+super_num);
		System.out.println("静态初始化sub_num_v="+super_num_v);
		System.out.println("非静态未初始化化sub_field="+super_field);
		System.out.println("非静态未初始化化sub_field_v="+super_field_v);
	}
	
	public void test() {
		System.out.println("父类test() 方法执行！");
	}
}
