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

public class Test {
	public static void main(String[] args) {
		
		try {
			compare(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void compare(int num) throws IOException {
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
		
	}
}
