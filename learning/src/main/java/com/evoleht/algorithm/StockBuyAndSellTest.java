package com.evoleht.algorithm;

/**
 * double数组存储的是每天股票的价格，计算哪天买入
 * 哪天卖出获益最大
 */
public class StockBuyAndSellTest {

	public void computer(double[] stocks) {
		if (stocks== null || stocks.length <=1) {
			System.out.println("数据不足,无法计算出收益");
		}
	
		double min_price = stocks[0];
		double max_profit = 0;
		int buy_index = 0;
		int sell_index = 0;
		for (int i = 1; i < stocks.length; i++) {
			if ((stocks[i] - min_price) > max_profit) {
				max_profit = stocks[i] - min_price;
				sell_index = i;
			}
			if (stocks[i] < min_price) {
				min_price = stocks[i];
				buy_index = i;
			}
		}
		System.out.println("最大利润是:"+max_profit+"第"+(buy_index+1)+"天买入,第"+(sell_index+1)+"天卖出");
	}
	
	public static void main(String[] args) {
		StockBuyAndSellTest test = new StockBuyAndSellTest();
		double[] stocks = {10.55,10.23,10.78,11.23,10.78,11.97,10.85};
		test.computer(stocks);
	}
}
