package com.evoleht.spring.aop.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class LoginIntercept implements MethodInterceptor {

	@Override
	public Object intercept(Object target, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		//执行原有逻辑，注意这里是invokeSuper 
		proxy.invokeSuper(target, args);
        //执行织入的日志   
		if (method.getName().equals("doBusiness2")) {
			System.out.println("记录日志。。。。。。。");
		}
		return null;
	}

}
