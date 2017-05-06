package com.evoleht.base.baseclass.map.test;

import java.util.HashMap;
import java.util.Map;

/**
 * hashmap 多线程下 容易引起死循环
 * 
 * 多个线程同时扩容
 *
 * 多个线程同时操作一个数据链引起死循环
 * 
 * http://coolshell.cn/articles/9606.html/comment-page-1#comments
 * 
 * 比如：两个线程同时取得一个map的数据链 3--》7--》null
 *  
 *  线程1 已经将数据链存放在新table中，并将链转换为 7-->3-->null
 *  线程2 此时还是 e=3 e.next = 7
 * 
 * 
 */
public class MapTest {
	static Map<String,String> map = new HashMap<String, String>(8);
	
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					System.out.println("线程："+Thread.currentThread().getName()+" put value start");
					for (int j = 0; j < 800; j++) {
						map.put(Thread.currentThread()+"j"+j, "j"+j);
						//System.out.println("线程："+Thread.currentThread().getName()+" put value \"j"+j+"\"");
					}
					System.out.println("线程："+Thread.currentThread().getName()+" put value end");
				}
			}).start();
		}
	}
}
