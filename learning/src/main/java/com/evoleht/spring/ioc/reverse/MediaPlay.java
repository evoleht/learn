package com.evoleht.spring.ioc.reverse;


/**
 * 媒体播放功能。
 * 
 * @author wangzs
 * @version v1.0.0
 * <p><B>last update </B> by wangzs @ 2014-5-15</p>
 * @since v1.0.0
 */
public class MediaPlay {

	public void PlayMedia() {
		IMediaFile imediaFile = new MediaFile();
		IPlayer player = new Player();
		player.play(imediaFile);
	}

}
