package com.evoleht.spring.aop.proxy;

public class ProxyDemo {
	
	public static void main(String[] args) {
		Business business = new Business();
		
		BusinessProxy businessProxy = new BusinessProxy(business);
		
		businessProxy.doBusiness2();
	}

}
