package com.evoleht.spring.aop.cglib;

import net.sf.cglib.proxy.Enhancer;

public class CglibDemo {
	
	public static void main(String[] args) {
//		
		//创建一个织入器
		Enhancer enhancer = new Enhancer();
		//设置父类
		enhancer.setSuperclass(Business.class);
		//设置需要织入的逻辑
		enhancer.setCallback(new LoginIntercept());
		//使用织入器创建子类
		Business businessProxy = (Business) enhancer.create();
		businessProxy.doBusiness1();
		businessProxy.doBusiness2();
	}
}
