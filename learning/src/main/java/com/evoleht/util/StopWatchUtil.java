package com.evoleht.util;

import com.evoleht.util.exception.IllegalOperationException;

public class StopWatchUtil {
	private static final String DEFAULT_TASK_NAME = "defaultTask";
	private String taskName;
	private long start, end;
	private boolean hasStarted, hasEnded;
	
	//枚举：毫秒、秒、分钟
	public enum TimeUnit{MILLI, SECOND, MITNUTE}
	
	public StopWatchUtil(){
		this(DEFAULT_TASK_NAME);
	}
	
	public StopWatchUtil(String taskName) {
		this.taskName = StringUtil.isEmpty(taskName) ? DEFAULT_TASK_NAME : taskName;
	}
	
	public void start() {
		start = System.currentTimeMillis();
		hasEnded = true;
	}
	
	public void end() throws IllegalOperationException {
		if(!hasStarted) {
			throw new IllegalOperationException("调用StopWatch的end()方法之前请先调用start()方法");
		}
		end = System.currentTimeMillis();
		hasEnded = true;
		hasStarted = false;
	}
	
	public void clear() {
		start = 0;
		end = 0;
		hasStarted = false;
		hasEnded = false;
	}
	
	/**
	 * 
	 * 获取总耗时,单位为毫秒
	 * @param 
	 * @return 耗时总毫秒数
	 * @throws  
	 */
	public long getEclapsedMillis() throws IllegalOperationException {
		if(!hasEnded) {
			throw new IllegalOperationException("请先调用end()方法");
		}
		return (end - start);
	}
	
	/**
	 *  获取总耗时，单位为秒
	 * @return 消耗的时间，单位为秒
	 * @throws 
	 */
	public long getEclapsedSeconds() throws IllegalOperationException {
		return this.getEclapsedMillis() / 1000; 
	}
	
	/**
	 * 获取总耗时，单位为分钟 
	 * @return 消耗的时间，单位为分钟
	 */
	public long getEclapsedMinutes() throws IllegalOperationException {
		return this.getEclapsedMillis() / (1000 * 60);
	}
	
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	public String getTaskName() {
		return this.taskName;
	}
	
	/**
	 * 输入任务耗时情况,默认时间单位为毫秒
	 */
	public void printEclapseDetai() throws IllegalOperationException {
		this.printEclapseDetail(TimeUnit.MILLI);
	}
	
	/**
	 *  输入任务耗时情况,可以指定毫秒、秒、分钟三种时间单位
	 * @param timeUnit 时间单位
	 */
	public void printEclapseDetail(TimeUnit timeUnit) throws IllegalOperationException {
		switch (timeUnit) {
		case MILLI:
			System.out.println(this.getTaskName() + "任务耗时(毫秒) : " + this.getEclapsedMillis());
			break;
		case SECOND:
			System.out.println(this.getTaskName() + "任务耗时(秒) : " + this.getEclapsedSeconds());
			break;
		case MITNUTE:
			System.out.println(this.getTaskName() + "任务耗时(分) : " + this.getEclapsedMinutes());
			break;
		default:
			System.out.println(this.getTaskName() + "任务耗时(毫秒) : " + this.getEclapsedMillis());
			break;
		}
	}
	
}
