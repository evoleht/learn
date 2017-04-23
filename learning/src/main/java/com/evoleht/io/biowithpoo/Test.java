package com.evoleht.io.biowithpoo;

import java.io.IOException;
import java.util.Random;

public class Test {
	
	public static void main(String[] args) throws InterruptedException {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					ServerNormal.start();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		Thread.sleep(100);
		
		final char oprators[] = {'+','-','*','/'};
		final Random random = new Random(System.currentTimeMillis());
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					String expression = random.nextInt(10) + "" + oprators[random.nextInt(4)] + (random.nextInt(10) + 1);
					Client.send(expression);
				}
			}
		}).start();
	}
}
























