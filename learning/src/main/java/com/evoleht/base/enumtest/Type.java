package com.evoleht.base.enumtest;

public enum Type {
	
	TEST("test"),
	ONLINE("online");
	
	private final String desc;
	
	private Type(String desc) {
		this.desc = desc;
	}
	
	public String getDesc() {
		return desc;
	}
	
}
