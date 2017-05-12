package com.evoleht.designpatterns.decorator.beverage;

public class HouseBlend extends Beverage {
	
	public HouseBlend() {
		description = "HouseBlend";
	}

	@Override
	public double cost() {
		return 6.0;
	}
}
