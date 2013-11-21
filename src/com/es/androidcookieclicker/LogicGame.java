package com.es.androidcookieclicker;


public class LogicGame {
	
	private static Double cookies = 0.0;
	private static Double cps = 0.1;
	
	//Const
	//Cookies per second
	public static String cps_string = "CPS";
	
	//Number of cookies
	public static String noc_string = "NOC";
	

	public static Double getCps() {
		return cps;
	}

	public static void setCps(Double cps) {
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

	public static void incrementCookiesPerSecond() {
		cookies += cps/10;
	}
	
	public static void incrementCookies(double numOfCookies) {
		cookies += numOfCookies;
	}
	
	public static void incrementCookiesPerSecond(double cps) {
		LogicGame.cps += cps;
	}
	
	public static void tick() {
		incrementCookiesPerSecond();
	}
	
	public static void decrementCookies(double cookies) {
		double cookiesAux = LogicGame.cookies - cookies;
		
		if(cookiesAux < 0) {
			LogicGame.cookies = 0.0;
		} else {
			LogicGame.cookies = cookiesAux;
		}
		
	}
	
}
