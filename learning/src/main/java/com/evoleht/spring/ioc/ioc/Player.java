package com.evoleht.spring.ioc.ioc;


/**
 * 百度影音播放器。
 * 
 * @author wangzs
 * @version v1.0.0
 * <p><B>last update </B> by wangzs @ 2014-5-15</p>
 * @since v1.0.0
 */
public class Player implements IPlayer{

	@Override
	public void play(IMediaFile mFile) {
		System.out.println("现在开始播放媒体文件.....");
	}
}
