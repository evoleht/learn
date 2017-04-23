package com.evoleht.io.nio;

import java.io.IOException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws InterruptedException, IOException {
		Server.start();
		Thread.sleep(1000);
		Client.start();
		
//		while(Client.sendMsg(new Scanner(System.in).nextLine()));
		while(Client.sendMsg("1+2"));
	}
}
