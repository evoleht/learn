package com.evoleht.spring.aop.DynamicProxy;

public class Business implements IBusiness1,IBusiness2 {

	@Override
	public void doBusiness1() throws Exception {
		System.out.println("开始处理业务1............");

	}

	@Override
	public void doBusiness2() throws Exception {
		System.out.println("开始处理业务2............");
		
	}


}
