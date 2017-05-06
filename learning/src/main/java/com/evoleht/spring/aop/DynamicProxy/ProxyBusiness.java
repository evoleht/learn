package com.evoleht.spring.aop.DynamicProxy;

import java.lang.reflect.Method;


public class ProxyBusiness implements IBusiness1, IBusiness2 { 

private LogInvocationHandler h; 

@Override 
public void doBusiness1() {
    try { 
        Method m = (h.target).getClass().getMethod("doBusiness1", null); 
        h.invoke(this, m, null); 
    } catch (Throwable e) { 
        // 异常处理（略） 
    } 
} 

@Override 
public void doBusiness2() { 
    try { 
       Method m = (h.target).getClass().getMethod("doBusiness2", null); 
       h.invoke(this, m, null); 
    } catch (Throwable e) { 
        // 异常处理（略） 
    } 
} 

public ProxyBusiness(LogInvocationHandler h) { 
    this.h = h; 
} 

//测试用 
public static void main(String[] args) {
    //构建AOP的Advice 
    LogInvocationHandler handler = new LogInvocationHandler(new Business()); 
    new ProxyBusiness(handler).doBusiness1(); 
    new ProxyBusiness(handler).doBusiness2(); 
} 
} 

