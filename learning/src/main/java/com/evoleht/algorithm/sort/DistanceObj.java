package com.evoleht.algorithm.sort;


public class DistanceObj implements Comparable<DistanceObj> {
	
	private String name;
	
	private long distance;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getDistance() {
		return distance;
	}

	public void setDistance(long distance) {
		this.distance = distance;
	}

	@Override
	public int compareTo(DistanceObj o) {
		return this.getDistance() >= o.getDistance() ? 1 : -1;
	}
	
}
