package com.evoleht.designpatterns.decorator.beverage;

public class Decaf extends Beverage {
	
	public Decaf() {
		description = "Decaf";
	}
	@Override
	public double cost() {
		return 4.5;
	}

}
