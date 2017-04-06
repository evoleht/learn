package com.evoleht.base.baseclass.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * HashMap 的遍历方式有两种
 * 第一种：遍历keyset
 * 第二种：遍历entryset
 * 
 * 区别：keyset遍历 
 * 返回的是key,根据get(key),进行两次hashcode计算 取得value
 * entryset 遍历
 * 返回的是entry对象,entry对象中包含了key,value
 * 
 * @author wangzs
 * @version v1.0.0
 * <p><B>last update </B> by wangzs @ 2017-3-23</p>
 * @since v1.0.0
 */
public class MapIterator {

		public static void main(String[] args) {
			HashMap<String, String> map  =  new HashMap<String, String>();
			for (int i = 0; i < 1000000; i++) {
				map.put("key"+i, "value"+i);
			}
			//keyset遍历
			ergodicByKeySet(map);
			//entryset遍历
			ergodicByEntrySet(map);
		}
		
		public static void ergodicByKeySet(HashMap<String, String> map) {
			long start = System.currentTimeMillis();
			Iterator<String> iterator = map.keySet().iterator();
			while (iterator.hasNext()) {
				String key = (String) iterator.next();
				String  value = map.get(key);
			}
			long end = System.currentTimeMillis();
			
			System.out.println("遍历花费时间："+(end - start));
		}
		public static void ergodicByEntrySet(HashMap<String, String> map) {
			long start = System.currentTimeMillis();
			Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<String, String> entry = iterator.next();
				String key = entry.getKey();
				String value = entry.getValue();
			}
			long end = System.currentTimeMillis();
			System.out.println("遍历花费时间："+(end - start));
		}
}
