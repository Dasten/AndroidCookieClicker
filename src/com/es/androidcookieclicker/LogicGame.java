/*
 * 
 */
package com.es.androidcookieclicker;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import android.util.Log;

/**
 * @author pfranco
 * @author Carlos B
 *
 */
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
	

	/**
	 * Gets the cps.
	 *
	 * @return the cps
	 */
	public static Double getCps() {
		return cps;
	}

	/**
	 * Sets the cps.
	 *
	 * @param cps the new cps
	 */
	public static void setCps(Double cps) {
		LogicGame.cps = cps;
	}
	
	/**
	 * Gets the cpc.
	 *
	 * @return the cpc
	 */
	public static Double getCpc() {
		return cpc;
	}

	/**
	 * Sets the cpc.
	 *
	 * @param cpc the cpc to set
	 */
	public static void setCpc(Double cpc) {
		LogicGame.cpc = cpc;
	}
	
	/**
	 * Gets the items.
	 *
	 * @return the items
	 */
	public static List<LogicItems> getItems() {
		return items;
	}

	/**
	 * Sets the items.
	 *
	 * @param items the items to set
	 */
	public static void setItems(List<LogicItems> items) {
		LogicGame.items = items;
	}

	/**
	 * Gets the pups.
	 *
	 * @return the pups
	 */
	public static List<LogicPowerUps> getPups() {
		return pups;
	}

	/**
	 * Sets the pups.
	 *
	 * @param pups the pups to set
	 */
	public static void setPups(List<LogicPowerUps> pups) {
		LogicGame.pups = pups;
	}

	/**
	 * Gets the pups available.
	 *
	 * @return the pupsAvailable
	 */
	public static List<LogicPowerUps> getPupsAvailable() {
		return pupsAvailable;
	}
	
	/**
	 * Inits the cookies.
	 */
	static void init() {
		cookies = 0.0;
	}

	/**
	 * Gets the cookies.
	 *
	 * @return the cookies
	 */
	public static Double getCookies() {
		return cookies;
	}
	
	/**
	 * Increment cookies.
	 */
	public static void incrementCookies() {
		cookies += cpc;
	}
	
	/**
	 * Increment cookies.
	 *
	 * @param cExtras the cookies extras
	 */
	public static void incrementCookies(double cExtras) {
		cookies += cExtras;
	}

	/**
	 * Increment cookies per second.
	 */
	public static void incrementCookiesPerSecond() {
		cookies += cps/10;
	}
	
	/**
	 * Increment cookies per second.
	 *
	 * @param cps the cps
	 */
	public static void incrementCookiesPerSecond(double cps) {
		LogicGame.cps += cps;
	}
	
	/**
	 * Increment cookies per click.
	 *
	 * @param cpc the cpc
	 */
	public static void incrementCookiesPerClick(double cpc){
		LogicGame.cpc += cpc;
	}
		
	/**
	 * Format number.
	 *
	 * @param number the number
	 * @return the string
	 */
	public static String formatNumber(Object number) {
		return formatter.format(number);
	}
	
	/**
	 * Llama a las funciona a actualizar por tick.
	 */
	public static void tick() {
		incrementCookiesPerSecond();
		checkIfHasCookiesForBuyItem();
		checkIfHasCookiesForBuyPowerUps();
		checkIfThePowerUpIsAvailable();
		checkIfHasCookiesForBuyPowerUps();
	}
	
	/**
	 * Decrement cookies.
	 *
	 * @param cookies the cookies
	 */
	public static void decrementCookies(double cookies) {
		double cookiesAux = LogicGame.cookies - cookies;
		
		if(cookiesAux < 0) {
			LogicGame.cookies = 0.0;
		} else {
			LogicGame.cookies = cookiesAux;
		}
		
	}
	
	/**
	 * Check if has cookies for buy item.
	 */
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
	
	/**
	 * Check if has cookies for buy power ups.
	 */
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
	
	
	/**
	 * Check if the power up is available.
	 */
	private static void checkIfThePowerUpIsAvailable(){
		
		int countPowerUps = pups.size();
						
		for(int i = 0; i < countPowerUps; i++) {
			LogicPowerUps powerUp = pups.get(i);
			
			//if(LogicGame.cookies >= powerUp.getPrice()) {
			try{
				LogicItems itemToUpgrade = items.get(powerUp.getItemIdToBoost()-1);
				
				if(powerUp.getItemIdToBoost() == -1){
					if(LogicGame.getCookies() >= powerUp.getLvlRequired()){
						pupsAvailable.add(powerUp);
					}
				}else{
					if(itemToUpgrade.getLevel() >= powerUp.getLvlRequired()){
						pupsAvailable.add(powerUp);
					}
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
