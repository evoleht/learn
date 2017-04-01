package com.evoleht.DesignPatterns.decorator.beverage;

public class Test {
	
	public static void main(String[] args) {
		Beverage darkRoast = new DarkRoast();
		darkRoast = new Milk(darkRoast);
		darkRoast = new Whip(darkRoast);
		
		System.out.println(darkRoast.getDescription() + "--" + darkRoast.cost());
		
		Beverage espresso = new Espresso();
		espresso = new Soy(espresso);
		espresso = new Mocha(espresso);
		espresso = new Mocha(espresso);
		System.out.println(espresso.getDescription() + "--" + espresso.cost());
	}
}
