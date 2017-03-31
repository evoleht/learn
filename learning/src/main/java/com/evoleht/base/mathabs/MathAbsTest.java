package com.evoleht.base.mathabs;

/**  
 * 数值类型自动提升
 * 
 * Math类的abs方法
 * 有这样一段注释
 * 
 * Note that if the argument is equal to the value of Integer.MIN_VALUE, 
 * the most negative representableint value, 
 * the result is that same value, which is negative.
 * 
 * 注意：如果参数等于integer.min_value价值，最负representableint值，结果是相同的值，这是消极的
 * 
 * 就是最小的负整形书，abs还是最小的负整形数
 * 
 * 
 */
public class MathAbsTest {
	
	//http://blog.csdn.net/arkblue/article/details/18008981
	public static void main(String[] args) {
		//byte short 自动提刑
		Byte b = Byte.MIN_VALUE;
		System.out.println(Byte.MIN_VALUE);
		System.out.println(Math.abs(Byte.MIN_VALUE));
		System.out.println(Short.MIN_VALUE);
		System.out.println(Math.abs(Short.MIN_VALUE));
		//int 最小值的 abs 还是最小负数
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Math.abs(Integer.MIN_VALUE));
		System.out.println(abs(Integer.MIN_VALUE));
	}
	
	public static long abs(long a) {
		return a<0 ? -a : a;
	}
}
