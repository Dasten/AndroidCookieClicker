package com.es.androidcookieclicker;

import java.text.DecimalFormat;


public class LogicGame {
	
	private static Double cookies = 0.0;
	private static Double cps = 0.0;
	private static Double cpc = 1.0;
	
	private static ArrayAdapterCookie<LogicItems> adapterItems;
	private static ArrayAdapterPowerUp<LogicPowerUps> adapterPUps;
	private static DecimalFormat formatter = new DecimalFormat("#,###,###,###,###,###");
	

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
	
	/**
	 * @return the cpc
	 */
	public static Double getCpc() {
		return cpc;
	}

	/**
	 * @param cpc the cpc to set
	 */
	public static void setCpc(Double cpc) {
		LogicGame.cpc = cpc;
	}
	
	

	/**
	 * @return the adapter
	 */
	public static ArrayAdapterCookie<LogicItems> getAdapter() {
		return adapterItems;
	}

	/**
	 * @param adapter the adapter to set
	 */
	public static void setAdapter(ArrayAdapterCookie<LogicItems> adapter) {
		LogicGame.adapterItems = adapter;
	}
	
	public static ArrayAdapterPowerUp<LogicPowerUps> getAdapterPUps() {
		return adapterPUps;
	}

	public static void setAdapterPUps(ArrayAdapterPowerUp<LogicPowerUps> adapterPUps) {
		LogicGame.adapterPUps = adapterPUps;
	}

	static void init() {
		cookies = 0.0;
	}

	public static Double getCookies() {
		return cookies;
	}
	
	public static void incrementCookies() {
		cookies += cpc;
	}

	public static void incrementCookiesPerSecond() {
		cookies += cps/10;
	}
	
	public static void incrementCookiesPerSecond(double cps) {
		LogicGame.cps += cps;
	}
	
	public static String formatNumber(Object number) {
		return formatter.format(number);
	}
	
	public static void tick() {
		incrementCookiesPerSecond();
		checkIfHasCookiesForBuyItem(adapterItems);
		checkIfThePowerUpIsPurchasable(adapterPUps, adapterItems);
	}
	
	public static void decrementCookies(double cookies) {
		double cookiesAux = LogicGame.cookies - cookies;
		
		if(cookiesAux < 0) {
			LogicGame.cookies = 0.0;
		} else {
			LogicGame.cookies = cookiesAux;
		}
		
	}
	
	private static void checkIfHasCookiesForBuyItem(ArrayAdapterCookie<LogicItems> adapter) {
		int countItems = adapter.getCount();
		
		for(int i = 0; i < countItems; i++) {
			LogicItems item = adapter.getItem(i);
			
			if(LogicGame.cookies >= item.getPrice()) {
				item.setPurchasable(true);
			} else {
				item.setPurchasable(false);
			}
		}
	}
	
	private static void checkIfThePowerUpIsPurchasable(ArrayAdapterPowerUp<LogicPowerUps> adapterPUps, ArrayAdapterCookie<LogicItems> adapterItems){
		
		int countPowerUps = adapterPUps.getCount();
				
		for(int i = 0; i < countPowerUps; i++) {
			LogicPowerUps powerUp = adapterPUps.getItem(i);
			
			if(LogicGame.cookies >= powerUp.getPrice()) {
				LogicItems itemToUpgrade = adapterItems.getItem(powerUp.getItemIdToBoost()-1);
				
				if(itemToUpgrade.getLevel() >= powerUp.getLvlRequired()){
					powerUp.setPurchasable(true);
				}else{
					powerUp.setPurchasable(false);
				}				
				
			} else {
				powerUp.setPurchasable(false);
			}
		}
	}
}
