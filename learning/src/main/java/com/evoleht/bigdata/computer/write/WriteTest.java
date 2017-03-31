package com.evoleht.bigdata.computer.write;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.evoleht.util.StopWatchUtil;
import com.evoleht.util.StopWatchUtil.TimeUnit;

/**
 * 数据写入
 * 
 */
public class WriteTest {
	
	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
		String filePath = "d://bigdata//bigdata.txt";
		String  chars = "abcdefghijklmnopqrstuvwxyz";
		
		StringBuilder sb = new StringBuilder();
		
		StopWatchUtil stopWatch = new StopWatchUtil();
		stopWatch.start();
		File file = new File(filePath);
		FileWriter writer = new FileWriter(file, true);
		BufferedWriter bWriter = new BufferedWriter(writer);
		for (int k = 0; k < 100000000; k++) {
			for (int i = 0; i < 10; i++) {
				sb.append(chars.charAt((int)(Math.random() * 26)));
			}
			String str = sb.toString();
			bWriter.newLine();
			bWriter.write(str);
			sb.setLength(0);
		}
		stopWatch.end();
		stopWatch.printEclapseDetail(TimeUnit.SECOND);
		bWriter.close();
		writer.close();
	}
}
