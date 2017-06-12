package com.evoleht.geohashtest;

import ch.hsr.geohash.GeoHash;

public class Test{   
    private static final  double EARTH_RADIUS = 6371000;//赤道半径(单位m)  
      
    /** 
     * 转化为弧度(rad) 
     * */  
    private static double rad(double d)  
    {  
       return d * Math.PI / 180.0;  
    }  
    /** 
     * 基于googleMap中的算法得到两经纬度之间的距离,计算精度与谷歌地图的距离精度差不多，相差范围在0.2米以下 
     * @param lon1 第一点的精度 
     * @param lat1 第一点的纬度 
     * @param lon2 第二点的精度 
     * @param lat3 第二点的纬度 
     * @return 返回的距离，单位m 
     * */  
    public static double GetDistance(double lon1,double lat1,double lon2, double lat2)  
    {  
       double radLat1 = rad(lat1);  
       double radLat2 = rad(lat2);  
       double a = radLat1 - radLat2;  
       double b = rad(lon1) - rad(lon2);  
       double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2)+Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));  
       s = s * EARTH_RADIUS;  
       s = Math.round(s * 10000) / 10000;  
       return s;  
    }  
       
    public static void main(String []args){  
//          double lon1=109.0145193757;    
//          double lat1=34.236080797698;  
//          double lon2=108.9644583556;  
//          double lat2=34.286439088548;  
    		// 39.984950, 116.465179


    		//39.986439, 116.463563
    	
          double lat1=39.984950;
          double lon1=116.465179;
          
          double lat2=39.986439;
          double lon2=116.463563;
          
          double dist;  
            
          dist=Test.GetDistance(lon1, lat1, lon2, lat2);   
          System.out.println("两点相距：" + dist + " 米");  
            
            
          GeoHash geohash = GeoHash.withCharacterPrecision(lat1, lon1, 8);
          System.out.println("当前位置编码：" + geohash);  
           
          GeoHash geohash2 = GeoHash.withCharacterPrecision(lat2, lon2, 8);
          System.out.println("远方位置编码：" + geohash2);  
  
       }  
    //wqj7j37sfu03h2xb2q97  
    /* 
永相逢超市 
108.83457500177 
34.256981052624 
wqj6us6cmkj5bbfj6qdg 
s6q08ubhhuq7 
*/  
}  