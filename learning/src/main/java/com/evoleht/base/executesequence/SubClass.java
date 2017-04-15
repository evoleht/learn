package com.evoleht.base.executesequence;

public class SubClass extends SuperClass {
	public static int sub_num;
	public static int sub_num_v = 10;
	public int sub_field;
	public int sub_field_v = 3;
	
	static {
		System.out.println("子类静态代码块执行!");
		System.out.println("静态未初始化sub_num="+sub_num);
		System.out.println("静态初始化sub_num_v="+sub_num_v);
		System.out.println("静态代码块中无法调用非静态的属性");
	}
	
	
	
	public SubClass() {
		System.out.println("子类无参构造方法执行!");
		System.out.println("静态未初始化sub_num="+sub_num);
		System.out.println("静态初始化sub_num_v="+sub_num_v);
		System.out.println("非静态未初始化化sub_field="+sub_field);
		System.out.println("非静态未初始化化sub_field_v="+sub_field_v);
	}
	
	{
		System.out.println("子类非静态代码块执行!");
		System.out.println("静态未初始化sub_num="+sub_num);
		System.out.println("静态初始化sub_num_v="+sub_num_v);
		System.out.println("非静态未初始化化sub_field="+sub_field);
		System.out.println("非静态未初始化化sub_field_v="+sub_field_v);
	}
	
	@Override
	public void test() {
//		super.test();
		System.out.println("子类test()方法执行！");
		System.out.println("静态未初始化sub_num="+sub_num);
		System.out.println("静态初始化sub_num_v="+sub_num_v);
		System.out.println("非静态未初始化化sub_field="+sub_field);
		System.out.println("非静态未初始化化sub_field_v="+sub_field_v);
	}
}
