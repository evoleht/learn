package com.evoleht.geohashtest;

import ch.hsr.geohash.GeoHash;
import ch.hsr.geohash.WGS84Point;
import ch.hsr.geohash.queries.GeoHashCircleQuery;

public class GeoHashTest {

	public static void main(String[] args) {
		// 39.999884, 116.471747
		// 39.990084, 116.486464

		double lat5 = 39.999884;
		double lon5 = 116.471747;

		double lat6 = 39.990084;
		double lon6 = 116.486464;
		double dist;
		dist = Test.GetDistance(lat5, lon5, lat6, lon6);
		System.out.println("两点相距：" + dist + " 米");
		dist = getDistance(lat5, lon5, lat6, lon6);
		System.out.println("两点相距：" + dist + " 米");

		System.out.println("--------------");
		//geoHashTest();
		print();

	}

	public static void geoHashTest() {

		String lat_lon1 = "39.997409, 116.467996";

		double lon1 = 116.467949;
		double lat1 = 39.997435;

		double lon6 = 116.483055;
		double lat6 = 39.992569;

		double lat5 = 39.994599;
		double lon5 = 116.472479;

		double lat4 = 39.995706;
		double lon4 = 116.470469;

		double lat3 = 39.996073;
		double lon3 = 116.469930;

		double lat2 = 39.996282;
		double lon2 = 116.469401;

		double lat7 = 39.991622;
		double lon7 = 116.449085;

		// 39.953155, 116.513046
		double lat8 = 39.953155;

		double lon8 = 116.513046;

		GeoHash geoHash1 = GeoHash.withCharacterPrecision(lat1, lon1, 8);
		GeoHash geoHash2 = GeoHash.withCharacterPrecision(lat2, lon2, 8);
		GeoHash geoHash3 = GeoHash.withCharacterPrecision(lat3, lon3, 8);
		GeoHash geoHash4 = GeoHash.withCharacterPrecision(lat4, lon4, 8);
		GeoHash geoHash5 = GeoHash.withCharacterPrecision(lat5, lon5, 8);
		GeoHash geoHash6 = GeoHash.withCharacterPrecision(lat6, lon6, 8);
		GeoHash geoHash7 = GeoHash.withCharacterPrecision(lat7, lon7, 8);

		GeoHash geoHash8 = GeoHash.withCharacterPrecision(lat8, lon8, 8);

		// GeoHash hash=GeoHash.fromGeohashString("wx4g");
		// WGS84Point point=hash.getPoint();
		//

		System.out.println("第一个点(" + lon1 + "," + lat1 + "): " + geoHash1.toBase32());
		System.out.println("第二个点(" + lon2 + "," + lat2 + "): " + geoHash2.toBase32());
		System.out.println("第三个点(" + lon3 + "," + lat3 + "): " + geoHash3.toBase32());
		System.out.println("第四个点(" + lon4 + "," + lat4 + "): " + geoHash4.toBase32());
		System.out.println("第五个点(" + lon5 + "," + lat5 + "): " + geoHash5.toBase32());
		System.out.println("第六个点(" + lon6 + "," + lat6 + "): " + geoHash6.toBase32());
		System.out.println("第六个点(" + lon7 + "," + lat7 + "): " + geoHash7.toBase32());

		System.out.println("第8个点(" + lon8 + "," + lat8 + "): " + geoHash8.toBase32());

		System.out.println("第一个点距离第二个点：" + getDistance(lat1, lon1, lat2, lon2));
		System.out.println("第一个点距离第三个点：" + getDistance(lat1, lon1, lat3, lon3));
		System.out.println("第一个点距离第四个点：" + getDistance(lat1, lon1, lat4, lon4));
		System.out.println("第一个点距离第五个点：" + getDistance(lat1, lon1, lat5, lon5));
		System.out.println("第一个点距离第六个点：" + getDistance(lat1, lon1, lat6, lon6));
		System.out.println("第一个点距离第七个点：" + getDistance(lat1, lon1, lat7, lon7));

		// System.out.println("第一个点距离第10个点：" + getDistance(lat1, lon1,
		// point.getLatitude(),
		// point.getLongitude())+";la="+point.getLatitude()+";lon="+point.getLongitude());

		System.out.println("============");
		GeoHash hash = GeoHash.fromGeohashString("wx4g734p");
		WGS84Point point = hash.getPoint();
		GeoHashCircleQuery query = new GeoHashCircleQuery(point, 5000);
		for (GeoHash h : query.getSearchHashes()) {

			System.err.println(h.getPoint().getLatitude() + ";" + h.getPoint().getLongitude());
			System.err.println(h.toBase32());

		}

//		System.out.println("经纬度：" + getDistance(lat1, lon1, lat8, lon8));
	}
	
	public static void print()  {
		double lat1 = 39.00;
		double lg1 = 116.00;
		
		double lat2 = 40.00;
		double lg2 = 116.00;
		
		GeoHash geoHash1 = GeoHash.withCharacterPrecision(lat1, lg1, 8);
		GeoHash geoHash2 = GeoHash.withCharacterPrecision(lat2, lg2, 8);
		
		System.out.println("第一个点：" + geoHash1.toBase32());
		
		System.out.println("第二个点：" + geoHash2.toBase32());
	}
	
	public static double getDistance(double lat1, double lon1, double lat2, double lon2) {
		if (Math.abs(lat1) > 90 || Math.abs(lon1) > 180 || Math.abs(lat2) > 90 || Math.abs(lon2) > 180) {
			throw new IllegalArgumentException("The supplied coordinates are out of range.");
		}
		int R = 6378137;
		double latRad1 = Math.toRadians(lat1);
		double lonRad1 = Math.toRadians(lon1);
		double latRad2 = Math.toRadians(lat2);
		double lonRad2 = Math.toRadians(lon2);
		// 结果
		double distance = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin((latRad1 - latRad2) / 2), 2)
				+ Math.cos(latRad1) * Math.cos(latRad2) * Math.pow(Math.sin((lonRad1 - lonRad2) / 2), 2))) * R;
		distance = Math.round(distance * 10000) / 10000;
		return Math.round(distance);
	}
}
