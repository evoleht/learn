package com.evoleht.spring.ioc.di;


/**
 * 媒体播放功能。
 * 
 * @author wangzs
 * @version v1.0.0
 * <p><B>last update </B> by wangzs @ 2014-5-15</p>
 * @since v1.0.0
 */
public class MediaPlay {
	//1.构造方法注入
	IMediaFile imediaFile;
	IPlayer player;
	
	public MediaPlay(IPlayer player,IMediaFile imediaFile) {
		this.player = player;
		this.imediaFile = imediaFile;
	}
	
	public void PlayMedia() {
		player.play(imediaFile);
	}
	
	//2.setter注入
//	IMediaFile imediaFile;
//	IPlayer player;
//	public IMediaFile getImediaFile() {
//		return imediaFile;
//	}
//	public void setImediaFile(IMediaFile imediaFile) {
//		this.imediaFile = imediaFile;
//	}
//	public IPlayer getPlayer() {
//		return player;
//	}
//	public void setPlayer(IPlayer player) {
//		this.player = player;
//	}
//	public void PlayMedia() {
//		player.play(imediaFile);
//	}
}
