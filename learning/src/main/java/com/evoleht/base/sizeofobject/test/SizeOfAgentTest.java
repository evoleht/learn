package com.evoleht.base.sizeofobject.test;

import static com.evoleht.base.sizeofobject.SizeOfAgent.*;

public class SizeOfAgentTest {
	
	public static void main(String[] args) {
		System.out.println("------------------空对象----------------------------");  
        // 16 bytes + 0 + 0 = 16  空对象， 只有对象头  
        System.out.println("sizeOf(new Object()) = " + sizeOf(new Object()));  
        System.out.println("fullSizeOf(new Object()) = " + fullSizeOf(new Object())); 
	}
}
