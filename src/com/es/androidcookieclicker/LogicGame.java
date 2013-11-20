package com.es.androidcookieclicker;

public class LogicGame {
	
	private static Double cookies = 0.0;
	private static double cps = 0.0;
	
	public static double getCps() {
		return cps;
	}

	public static void setCps(double cps) {
		LogicGame.cps = cps;
	}

	static void init() {
		cookies = 0.0;
	}

	public static Double getCookies() {
		return cookies;
	}

	public static void incrementCookies() {
		cookies++;
	}
	
	public static void incrementCookies(double numOfCookies) {
		cookies += numOfCookies;
	}
	
}
