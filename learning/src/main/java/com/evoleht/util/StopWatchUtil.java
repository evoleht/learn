package com.evoleht.util;

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
	
	public void end() {
		if(!hasStarted) {
			//throw new Exception("");
		}
	}
	//https://maimai.cn/article/detail?fid=91810981&from=headline&share_user=http%3A%2F%2Fi9.taou.com%2Fmaimai%2Fp%2F875%2F3787_26_1IPARmWB1LOHr4-a160
	
}
