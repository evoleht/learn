package com.evoleht.DesignPatterns.decorator.beverage;

public class DarkRoast extends Beverage {

	public DarkRoast() {
		description = "DarkRoast";
	}
	@Override
	public double cost() {
		return 7.5;
	}

}
