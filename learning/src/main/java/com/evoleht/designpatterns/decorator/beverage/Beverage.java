package com.evoleht.designpatterns.decorator.beverage;

/**
 * 饮料抽象类，
 * 有两个方法
 * getDescription已经实现了
 * cost方法由子类中实现
 */
public abstract class Beverage {
	String description = "unknown Beverage";
	
	public String getDescription() {
		return description;
	}
	
	public abstract double cost();
}
