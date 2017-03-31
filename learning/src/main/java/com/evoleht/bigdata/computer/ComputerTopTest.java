package com.evoleht.bigdata.computer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

import com.evoleht.util.StopWatchUtil;
import com.evoleht.util.StopWatchUtil.TimeUnit;

public class ComputerTopTest {
	
	public static void main(String[] args) {
		StopWatchUtil stopWatch = new StopWatchUtil();
		StopWatchUtil stopWatch2 = new StopWatchUtil("统计计时");
		
		stopWatch.start();
		String path = "d://bigdata//bigdata.txt";
		File file = new File(path);
		System.out.println(file.length());
		int num = (int) (file.length()/(100*1024*1024));
		
		ArrayList<LinkedBlockingQueue<String>> queues = new ArrayList<LinkedBlockingQueue<String>>(num);
		for (int i = 0; i < num; i++) {
			queues.add(new LinkedBlockingQueue<String>());
			
		}
		//映射
		try {
			for (int i = 0; i < num; i++) {
				System.out.println("创建第" + i + "个线程");
				Writer writer = new Writer(i, queues.get(i));
				new WriteThread(writer).start();
			}
			read(file, num, queues);
			while(Thread.activeCount() > 1) {
				Thread.yield();
			}
			stopWatch2.start();
			//统计
			HashMap<String, Long> result = new HashMap<String, Long>();
			for (int i = 0; i < num; i++) {
				compare(i, result);
				if (result.size() > 100) {
					System.out.println("数据量过大");
					break;
				}
			}
			stopWatch2.end();
			stopWatch2.printEclapseDetail(TimeUnit.SECOND);
		} catch (Exception e) {
			e.printStackTrace();
		}
		stopWatch.end();
		stopWatch.printEclapseDetail(TimeUnit.SECOND);
	}
	
	public static void read(File file, int num, ArrayList<LinkedBlockingQueue<String>> queues) throws IOException {
		FileReader reader = new FileReader(file);
		BufferedReader bReader = new BufferedReader(reader);
		bReader.readLine();
		long len = 0;
		String str = null;
		while( (str = bReader.readLine()) != null) {
			len++;
			int index = mapping(str, num);
			queues.get(index).offer(str);
		}
		System.out.println("总共读取" + len + "条数据");
		Writer.flag = false;
		bReader.close();
		reader.close();
	}
	
	public static int mapping(String str, int num) {
		int mapping_num = (int) (abs(str.hashCode())%num);
		return mapping_num;
	}
	
	public static void compare(int num, HashMap<String, Long> result) throws IOException {
		StopWatchUtil stopWatch = new StopWatchUtil(num+"文件");
		stopWatch.start();
		System.out.println("统计第"+num+"个文件,结果 result.size = "+result.size());
		String path = "d://bigdata//smalldata//"+num+".txt";
		File file = new File(path);
		BufferedReader bReader = new BufferedReader(new FileReader(file));
		bReader.readLine();
		String str = null;
		HashMap<String, Long> map = new HashMap<String, Long>();
		while ((str = bReader.readLine()) != null) {
			if (map.containsKey(str)) {
				map.put(str, map.get(str) + 1);
			}else {
				map.put(str, 1L);
			}
		}
		bReader.close();
		ArrayList<Map.Entry<String,Long>> list = new ArrayList<Map.Entry<String,Long>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Long>>() {
			@Override
			public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).getValue() > 1) {
				result.put(list.get(i).getKey(), list.get(i).getValue());
			}
			else {
				break;
			}
		}
		stopWatch.end();
		stopWatch.printEclapseDetail(TimeUnit.SECOND);
	}
	
	public static long abs(long a) {
		return (a<0) ? -a : a;
	}
}
