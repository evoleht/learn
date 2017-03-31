package com.evoleht.bigdata.computer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Queue;

public class Writer {
	
	public static volatile boolean flag = true;
	
	private Queue<String> queue;
	private int num;
	
	public Writer(int num, Queue<String> queue) {
		this.num = num;
		this.queue = queue;
	}
	
	
	public void write() throws IOException, InterruptedException {
		System.out.println(Thread.currentThread().getName() + " 开始准备从queue 中取数据");
		String path = "d://bigdata//smalldata//"+num+".txt";
		File file = new File(path);
		BufferedWriter bWriter = new BufferedWriter(new FileWriter(file,true));
		long len = 0;
		while (flag || queue.size() > 0) {
			if (queue.size() == 0) {
				Thread.sleep(1000);
			}else {
				len ++;
				String str = queue.poll();
				bWriter.newLine();
				bWriter.write(str);
			}
		}
		System.out.println(Thread.currentThread().getName() + " 写入 "+ len +" 条数据");
		bWriter.close();
	} 
}
