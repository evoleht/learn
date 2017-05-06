package test.ioc.general;

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
		MediaFile mediaFile = new MediaFile();//获得播放文件
		Player player = new Player();//获得播放器
		player.play(mediaFile);//播放
	}
}
