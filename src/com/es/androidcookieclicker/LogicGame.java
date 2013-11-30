package com.es.androidcookieclicker;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import android.util.Log;


public class LogicGame {
	
	private static Double cookies = 0.0;
	private static Double cps = 0.0;
	private static Double cpc = 1.0;
	
	private static List<LogicItems> items;
	private static List<LogicPowerUps> pups;
	private static List<LogicPowerUps> pupsAvailable = new ArrayList<LogicPowerUps>();
	private static DecimalFormat formatter = new DecimalFormat("#,###,###,###,###,###");
	

	//Const
	//Cookies per second
	public static String cps_string = "CPS";
	
	//Number of cookies
	public static String noc_string = "NOC";
	
	//Coockes per Click
	public static String cpc_string = "CPC";
	

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
	 * @return the items
	 */
	public static List<LogicItems> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public static void setItems(List<LogicItems> items) {
		LogicGame.items = items;
	}

	/**
	 * @return the pups
	 */
	public static List<LogicPowerUps> getPups() {
		return pups;
	}

	/**
	 * @param pups the pups to set
	 */
	public static void setPups(List<LogicPowerUps> pups) {
		LogicGame.pups = pups;
	}

	/**
	 * @return the pupsAvailable
	 */
	public static List<LogicPowerUps> getPupsAvailable() {
		return pupsAvailable;
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
	
	public static void incrementCookies(double cExtras) {
		cookies += cExtras;
	}

	public static void incrementCookiesPerSecond() {
		cookies += cps/10;
	}
	
	public static void incrementCookiesPerSecond(double cps) {
		LogicGame.cps += cps;
	}
	
	public static void incrementCookiesPerClick(double cpc){
		LogicGame.cpc += cpc;
	}
		
	public static String formatNumber(Object number) {
		return formatter.format(number);
	}
	
	public static void tick() {
		incrementCookiesPerSecond();
		checkIfHasCookiesForBuyItem();
		checkIfHasCookiesForBuyPowerUps();
		checkIfThePowerUpIsAvailable();
		checkIfHasCookiesForBuyPowerUps();
	}
	
	public static void decrementCookies(double cookies) {
		double cookiesAux = LogicGame.cookies - cookies;
		
		if(cookiesAux < 0) {
			LogicGame.cookies = 0.0;
		} else {
			LogicGame.cookies = cookiesAux;
		}
		
	}
	
	private static void checkIfHasCookiesForBuyItem() {
		int countItems = items.size();
		
		for(int i = 0; i < countItems; i++) {
			LogicItems item = items.get(i);
			
			if(LogicGame.cookies >= item.getPrice()) {
				item.setPurchasable(true);
			} else {
				item.setPurchasable(false);
			}
		}
	}
	
	private static void checkIfHasCookiesForBuyPowerUps() {
		int countItems = pupsAvailable.size();
				
		for(int i = 0; i < countItems; i++) {
			LogicPowerUps powerUp = pupsAvailable.get(i);
			
			if(pups.contains(powerUp)) {
				pups.remove(powerUp);
			}
			
			if(LogicGame.cookies >= powerUp.getPrice()) {
				powerUp.setPurchasable(true);
			} else {
				powerUp.setPurchasable(false);
			}
		}
	}
	
	
	private static void checkIfThePowerUpIsAvailable(){
		
		int countPowerUps = pups.size();
						
		for(int i = 0; i < countPowerUps; i++) {
			LogicPowerUps powerUp = pups.get(i);
			
			//if(LogicGame.cookies >= powerUp.getPrice()) {
			try{
				LogicItems itemToUpgrade = items.get(powerUp.getItemIdToBoost()-1);
				
				if(itemToUpgrade.getLevel() >= powerUp.getLvlRequired()){
					pupsAvailable.add(powerUp);
				}
				
			}catch(Exception ex) {
				Log.println(0, null, ex.getMessage());
			}
				/*else{
					powerUp.setPurchasable(false);
				}*/				
				
			/*} else {
				powerUp.setPurchasable(false);
			}*/
		}
	}
}
