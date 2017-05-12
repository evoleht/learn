package com.evoleht.designpatterns.decorator.beverage;

/**
 * 装饰类接口
 * 首先需要CondimentDecorator能取代 Beverage
 * 所以CondimentDecorator 扩展自Beverage
 */
public abstract class CondimentDecorator extends Beverage{
	//所有的调料装饰者都必须重新实现getDescription
	public abstract String getDescription();
}
