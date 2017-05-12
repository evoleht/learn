package com.evoleht.designpatterns.decorator.beverage;

public class Mocha extends CondimentDecorator {
	
	Beverage beverage;
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() {
		return "Mocha" + beverage.getDescription();
	}

	@Override
	public double cost() {
		return 2.5 + beverage.cost();
	}

}
