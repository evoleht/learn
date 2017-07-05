package com.evoleht.thread.exchangertest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Exchanger;

public class Producer extends Thread {
	
	private Exchanger<List<Integer>> exchanger = null;
	private List<Integer> list = new ArrayList<Integer>();
	
	public Producer(Exchanger<List<Integer>> exchanger) {
		super();
		this.exchanger = exchanger;
	}
	
	@Override
	public void run() {
		Random random = new Random();
		
		while(!Thread.currentThread().isInterrupted()) {
			list.clear();
			list.add(random.nextInt(1000));
			list.add(random.nextInt(1000));
			list.add(random.nextInt(1000));
			list.add(random.nextInt(1000));
			
			try {
				list = exchanger.exchange(list);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
