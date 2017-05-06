package com.evoleht.spring.aop.proxy;

public class BusinessProxy implements IBusiness1, IBusiness2 {
	
	public Business  business= null;
	
	BusinessProxy(Business business){
		this.business = business;
	}
	
	@Override
	public void doBusiness2() {
		System.out.println("处理业务2之前进行操作。。。");
		business.doBusiness2();
	}

	@Override
	public void doBusiness1() {
		business.doBusiness1();
	}

}
