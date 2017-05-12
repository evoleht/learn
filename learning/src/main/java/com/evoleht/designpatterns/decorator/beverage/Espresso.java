package com.evoleht.designpatterns.decorator.beverage;

public class Espresso extends Beverage {
	
	public Espresso() {
		description = "Espresso";
	}

	@Override
	public double cost() {
		return 5.0;
	}

}
