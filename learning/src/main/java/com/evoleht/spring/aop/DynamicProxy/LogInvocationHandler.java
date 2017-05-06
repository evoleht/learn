package com.evoleht.spring.aop.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogInvocationHandler implements InvocationHandler{
	
	Object target;//目标对象
	
	LogInvocationHandler(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//执行原有逻辑
		if (!method.isAccessible()) {
			method.setAccessible(true);
		}
		Object rev = method.invoke(target, args);
		//执行织入的日志，你可以控制哪些方法执行切入逻辑   
		if(method.getName().equals("doBusiness2")) {
			System.out.println("记录操作日志.....");
		}
		return rev;
	}

}
