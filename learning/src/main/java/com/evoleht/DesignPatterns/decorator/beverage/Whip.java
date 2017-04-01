package com.evoleht.DesignPatterns.decorator.beverage;

public class Whip extends CondimentDecorator {
	
	Beverage beverage;
	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() {
		return "whip" + beverage.getDescription();
	}

	@Override
	public double cost() {
		return 1.5 + beverage.cost();
	}

}
