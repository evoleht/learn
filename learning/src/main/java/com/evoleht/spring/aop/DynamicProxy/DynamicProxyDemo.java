package com.evoleht.spring.aop.DynamicProxy;

import java.lang.reflect.Proxy;

public class DynamicProxyDemo {

	/**
	 * 动态代理学习demo。
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		//需要代理的接口，被代理类实现的多个接口再次定义
		Class[] proxyInterface = new Class[] {IBusiness1.class, IBusiness2.class};
		//实例化需要切入的逻辑advice，需要传入业务类的实例
		LogInvocationHandler handler = new LogInvocationHandler(new Business());
		//生成代理类的字节码加载器
		ClassLoader cLoader = DynamicProxyDemo.class.getClassLoader();
		//切入代码，并生成代理类
		IBusiness2 proxyBusiness = (IBusiness2) Proxy.newProxyInstance(cLoader, proxyInterface, handler);
		
		//使用代理类来执行方法
		proxyBusiness.doBusiness2();
		((IBusiness1)proxyBusiness).doBusiness1();
		
	}

}
