package com.evoleht.serializabletest.ParentAndTransient;

import java.io.Serializable;

public class Sub extends Super implements Serializable{
	
	/**  **/
	private static final long serialVersionUID = 1L;
	private String dec;
	
	public String getDec() {
		return dec;
	}
	public void setDec(String dec) {
		this.dec = dec;
	}
	
	
}
