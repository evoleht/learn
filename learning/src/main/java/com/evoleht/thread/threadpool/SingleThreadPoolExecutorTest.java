package com.evoleht.thread.threadpool;

public class SingleThreadPoolExecutorTest {
	
	/**
	 * 	使用单线程池与自己创建线程的区别
	 * 
	 *  理解：
	 *  1.明确执行的任务 （线程池）
	 *  2.线程不需要频繁的创建修改
	 *  3.线程不需要重用
	 *  如果满足这几个条件可以不用线程池，因为线程池里会创建一些额外的对象，需要有维护线程的地方
	 *  处理异常的方式，反而造成额外的浪费
	 *  反之则需要使用单线程池。
	 *
	 *	示例：记录在线用户数量的功能，记录操作异步独立运行，
	 */
	public void recordNum() {
		int userNum = 20;
		new Threa
	}
	main
}
