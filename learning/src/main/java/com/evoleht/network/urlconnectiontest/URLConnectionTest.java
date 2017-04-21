package com.evoleht.network.urlconnectiontest;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionTest {
	
	public static void main(String[] args) {
		InputStream in = null;
		InputStreamReader reader = null;
		try {
			URL url = new URL("http://www.baidu.com");
			URLConnection con = url.openConnection();
			
			String ctype =con.getContentType();
			System.out.println(ctype);
			
			int len = con.getContentLength();
			System.out.println(len);
			
			
			in = con.getInputStream();
			reader = new InputStreamReader(new BufferedInputStream(in));
			int c;
			while ((c=reader.read())!=-1) {
				System.out.print((char)c);
			}
			
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
