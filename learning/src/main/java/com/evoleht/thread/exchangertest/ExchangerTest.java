package com.evoleht.thread.exchangertest;

import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerTest {
	
	public static void main(String[] args) {
		Exchanger<List<Integer>> exchanger = new Exchanger<List<Integer>>();
		Producer producer = new Producer(exchanger);
		Consumer consumer = new Consumer(exchanger);
		
		consumer.start();
		
		producer.start();
	}
}
