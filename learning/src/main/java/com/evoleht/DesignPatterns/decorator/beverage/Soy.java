package com.evoleht.DesignPatterns.decorator.beverage;

public class Soy extends CondimentDecorator {

	Beverage beverage;
	
	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}
	@Override
	public String getDescription() {
		return "soy" + beverage.getDescription();
	}

	@Override
	public double cost() {
		return 2.5 + beverage.cost();
	}

}
