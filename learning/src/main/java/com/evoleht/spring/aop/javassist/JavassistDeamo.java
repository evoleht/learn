package com.evoleht.spring.aop.javassist;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.Loader;
import javassist.NotFoundException;

public class JavassistDeamo {

	/**
	 * %方法的一句话概述（注：句号不能删除，本注应删除）%。
	 * <p>%方法详述（简单方法可不必详述）%。</p>
	 * @param args
	 * @throws Throwable 
	 */
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		//获取存放CtClass的容器ClassPool   
		ClassPool cp = ClassPool.getDefault();   
		//创建一个类加载器   
		Loader cl = new Loader();   
		//增加一个转换器   
		cl.addTranslator(cp, new MyTranslator());   
		//启动MyTranslator的main函数   
		cl.run("com.fenghuoyun.webaction.aop.javassist.MyTranslator", args);  
	}

}
