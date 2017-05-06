package com.evoleht.base.baseclass.concurrents.blockingqueue;

import java.util.NoSuchElementException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import com.evoleht.util.StopWatchUtil;

public class LinkedBlockingQueueTest {
	/**
	 * 阻塞队列：
	 * 		抛出异常		特殊值		阻塞		超时
	 * 插入：	add			offer		put		offer(long time, TimeUnit unit)
	 * 删除：	remove		poll		take	poll(long time, TimeUnit unit)
	 * 检查：	element		peek		--
	 * 
	 * 
	 * add : 队列添加一个元素，如果队列满了，则抛出异常 java.lang.IllegalStateException: Queue full
	 * remove : 删除并返回队列的头部元素  如果队列为空则抛出 java.util.NoSuchElementException
	 * 
	 * element: 返回队列头部元素,如果队列为空，则抛出java.util.NoSuchElementException
	 * 
	 * offer : 添加元素并返回true,如果队列满了,则添加失败返回false
	 * offer(long time, TimeUnit unit): 添加元素并返回true, 如果队列满了，则阻塞等待time时间
	 * 
	 * poll: 移除并返回队列头部元素，如果队列为空，则返回null
	 * poll(long time, TimeUnit unit): 移除并返回队列头部元素，如果队列为空，则阻塞等待time时间
	 * 
	 * peek: 返回队列头部元素，如果队列为空的话，返回null
	 * 
	 * put: 队列添加一个元素，如果队列满了,则阻塞
	 * take: 移除并返回头部元素，如果队列为空，则阻塞
	 * 
	 * 
	 * 阻塞队列的实现原理 是采用了AtomicInteger ReentrantLock
	 * 
	 *  AtomicInteger 记录了队列里的个数， 取数据时，循环查看AtomicInteger，如果AtomicInteger 为0 则休眠
	 *  否则取出数据
	 */
	
	static LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>(2);
	public static void main(String[] args) {
		try {
			add();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		try {
			remove();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		try {
			element();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		offer();
		off(1000, TimeUnit.MILLISECONDS);
		poll();
		poll(1000,TimeUnit.MILLISECONDS);
		peek();
		put();
		take();
	}
	
	public static void add() {
		for (int i = 0; i < 4; i++) {
			System.out.println("add() 方法添加元素");
			queue.add("add"+i);
		}
	}
	
	public static void remove() {
		for (int i = 0; i < 4; i++) {
			String str = queue.remove();
			System.out.println("remove() 获取头元素 "+str);
		}
	}
	
	public static void element() {
//		queue.add("element");
		for (int i = 0; i < 5; i++) {
			String str = queue.element();
			System.out.println("element():"+str);
		}
	}
	
	public static void offer() {
		boolean flag = false;
		for (int i = 0; i < 4; i++) {
			flag = queue.offer("offer"+i);
			System.out.println("offer()-添加元素\"offer"+i+"\""+(flag?"成功！":"失败！"));
		}
	}
	
	public static void off(long timeout, TimeUnit unit) {
		boolean flag = false;
		StopWatchUtil stopWatch = new StopWatchUtil();
		try {
			for (int i = 0; i < 4; i++) {
				stopWatch.start();
				flag = queue.offer("off(time, unit)", timeout, unit);
				stopWatch.end();
				System.out.println("off(time, unit)--添加元素："+(flag?"成功！":"失败!"));
				stopWatch.printEclapseDetai();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void poll() {
		for (int i = 0; i < 4; i++) {
			String str = queue.poll();
			System.out.println("poll()-取出元素："+str);
		}
	}
	
	public static void poll(long timeout, TimeUnit unit) {
		try {
			StopWatchUtil stopWatch = new StopWatchUtil();
			for (int i = 0; i < 4; i++) {
				stopWatch.start();
				String str = queue.poll(timeout, unit);
				stopWatch.end();
				System.out.println("poll(timeout,unit)-取出元素："+str);
				stopWatch.printEclapseDetai();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void peek() {
//		queue.add("peek");
		for (int i = 0; i < 4; i++) {
			String str = queue.peek();
			System.out.println("peek()--"+str);
		}
		
	}
	
	public static void put() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					for (int i = 0; i < 20; i++) {
						queue.put("k"+i);
						System.out.println("队列添加元素:k"+i);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	public static void take() {
		int count =0;
		try {
			for(;;) {
				count++;
				String str = queue.take();
				System.out.println("第"+count+"次从队列取出元素:"+str);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
