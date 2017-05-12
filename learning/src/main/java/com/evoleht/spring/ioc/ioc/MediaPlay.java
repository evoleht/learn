package com.evoleht.spring.ioc.ioc;



/**
 * 媒体播放功能 
 * 
 * @author wangzs
 * @version v1.0.0
 * <p><B>last update </B> by wangzs @ 2014-5-15</p>
 * @since v1.0.0
 */
public class MediaPlay {

	public void PlayMedia() {
		//读取配置文件
		 String args[] = {"classpath*:/configs/spring/applicationContext.xml",
				 "classpath*:/configs/spring/applicationContext*.xml"
		 };
		 ApplicationContext context = new ClassPathXmlApplicationContext(args);
		 
		 //读取spring 生成的bean
		IMediaFile imediaFile  = (IMediaFile) context.getBean("imediaFile");
		IPlayer iPlayer = (IPlayer) context.getBean("iPlayer");
		
		iPlayer.play(imediaFile);
	}

}
