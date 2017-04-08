package com.evoleht.jvm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class JVMTest {
	
	private static final String[] jvm_command = {
			"-Xms50M",
			"-Xmx1024M",
			"-Xss10M",
			"-XX:PermSize=10M",
			"-XX:MaxPermSize=200M",
			"-verbose:gc",
			"-Xnoclassgc",
			"-XX:+TraceClassLoading",
			"-XX:+TraceClassUnLoading",
			"-XX:NewRatio=4",
			"-XX:SurvivorRatio=8",
			"-Xmn20M",
			"-XX:+HeadpDumpOnOutOfMemoryError",
			"-XX:+UseG1GC",
			"-XX:+PrintGC",
			"-XX:PrintGCDetails",
			"-XX:PretenureSizeThreshold=3145728",
			"-XX:MaxTenuringThreshold=1",
			"-XX:CompileThreshold=1000",
			"-XX:+PrintHeapAtGC",
			"-XX:+PrintTLAB",
			"-XX:+UseSpining",
			"-XX:PreBlockSpin"};
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		Collections.addAll(list, jvm_command);
		Collections.shuffle(list);
		System.out.println("请写出以下JVM命令表示的意思：");
		int size = list.size();
		for (int i = 0; i < size; i++) {
			System.out.println(list.get(i));
			System.out.println();
		}
	}
	
	
}
