package com.evoleht.spring.aop.proxy;


public class Business implements IBusiness2, IBusiness1 {

	@Override
	public void doBusiness1() {
		System.out.println("处理业务1.。。。。。。。。。");
		
	}

	@Override
	public void doBusiness2() {
		System.out.println("处理业务2.。。。。。。。。。。。");
	}


}
