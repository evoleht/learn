package com.evoleht.thread.exchangertest;

import java.util.List;
import java.util.concurrent.Exchanger;

public class Consumer extends Thread {
	
	private Exchanger<List<Integer>> exchanger = null;
	private List<Integer> list = null;
	
	public Consumer(Exchanger<List<Integer>> exchanger) {
		super();
		this.exchanger = exchanger;
	}
	
	@Override
	public void run() {
		
		while(! Thread.currentThread().isInterrupted()) {
			try {
				list = exchanger.exchange(list);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(list.size() > 0) {
				System.out.println("==>" + list.get(0));
				System.out.println("==>" + list.get(1));
				System.out.println("==>" + list.get(2));
				System.out.println("==>" + list.get(3));
			}
		}
	}
}
