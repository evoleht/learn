package com.evoleht.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * Created by IntelliJ IDEA.
 * User: wangzs
 * Date: 2012-1-2
 * Time: 12:08:55
 * To change this template use File | Settings | File Templates.
 */
public class PropertiesUtils {
	
    protected static Properties config = new Properties();
    
    private static final String DBFIGPATH="/configs/config/db.properties";
    
    /**配置文件路径*/
    private static final String CONFIGPATH="/configs/config/project.properties";
    
    /** 菜单权限配置  **/
    private static final String CONFIGPATH_AUTHORIZATION="/configs/config/authorization.properties";
    
    /** 导入样表下载地址配置  **/
    private static final String CONFIGPATH_DOWNLOAD="/configs/config/download.properties";
    
    static {
        try {
        	InputStream dbfigpath = PropertiesUtils.class.getResourceAsStream(DBFIGPATH);
        	if(dbfigpath!=null)
        		config.load(dbfigpath);
        	InputStream configpath = PropertiesUtils.class.getResourceAsStream(CONFIGPATH);
        	if(configpath!=null)
        		config.load(configpath);
        	InputStream configmenu = PropertiesUtils.class.getResourceAsStream(CONFIGPATH_AUTHORIZATION);
        	if(configmenu!=null)
        		config.load(configmenu);
        	InputStream configdownload = PropertiesUtils.class.getResourceAsStream(CONFIGPATH_DOWNLOAD);
        	if(configdownload!=null)
        		config.load(configdownload);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
	/**
	 * add by hushiwang
	 * <P>根据属性的key得到属性value</P>
	 * @param propertyName 属性键
	 * @return
	 */
	public static String getPropValue(String propertyName) {
           return  config.getProperty(propertyName, "");
	}
	
	/**
	 * add by hushiwang
	 * <P>设置配置文件的属性值</P>
	 * @param propertyKey
	 * @param value
	 */
	public static void setPropValue(String propertyKey,String value){
		config.setProperty(propertyKey, value);
	}

}
