package com.evoleht.spring.aop.javassist;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.Translator;

public class MyTranslator implements Translator {
	
	
	//类加载到JVM之前进行代码织入
	@Override
	public void onLoad(ClassPool pool, String classname) throws NotFoundException,
			CannotCompileException {
		System.out.println("......");
		 if (!"com.fenghuoyun.webaction.aop.javassist$Business".equals(classname)) {   
             return;   
         }   
		 //通过获取类文件
		 CtClass cc = pool.getCtClass(classname);
		 
		 CtMethod method  = cc.getDeclaredMethod("doBusiness");
		 
		 method.insertBefore("{ System.out.println(\"记录日志\")}");
		 
	}

	@Override
	public void start(ClassPool arg0) throws NotFoundException,
			CannotCompileException {
		
	}
	
	public static void main(String[] args) {   
        Business b = new Business();   
        b.doBusiness1();
        b.doBusiness2();
    }   
}
