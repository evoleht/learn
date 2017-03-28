package com.evoleht.algorithm;

public class ReplaceTest {
	
	public String replaceSpace(StringBuffer str) {
		int i = 0;
		do {
			i = -1;
			i = str.lastIndexOf(" ");
			if (i> -1) {
				str = str.replace(i, i+1, "%20");
			}
		} while (i> -1);
		return str.toString();
	}
	
	public static void main(String[] args) {
		StringBuffer str = new StringBuffer();
		str.append("we").append(" ").append("are")
		.append(" ").append("firends");
		
		System.out.println(str.toString());
		
		ReplaceTest rt = new ReplaceTest();

		System.out.println(rt.replaceSpace(str));
	}
}
