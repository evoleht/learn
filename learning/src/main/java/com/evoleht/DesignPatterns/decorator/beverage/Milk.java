package com.evoleht.DesignPatterns.decorator.beverage;

public class Milk extends CondimentDecorator {
	
	Beverage beverage;
	
	public Milk(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() {
		return "Milk" + beverage.getDescription();
	}

	@Override
	public double cost() {
		return 2.5 + beverage.cost();
	}
}
