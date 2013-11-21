package com.es.androidcookieclicker;

import android.app.ListActivity;

public class LogicItems extends ListActivity {
	
	/*
	 * private static final String[] items={"Cursor", "Grandma", 
		"Farm", "Factory", "Mine", "Shipment", "Alchemy lab", 
		"Portal", "Time Machine", "Antimatter condenser"};
	*/
	
	private int id;
	private String name;
	private double cps;

	private int basePrice;
	private int price;
	private int level;
	
	LogicItems(int id, String name, double cps, int price) {
		this.id = id;
		this.name = name;
		this.cps = cps;
		this.price = price;
		this.basePrice = price;
		this.level = 1;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * @return the factor
	 */

	
	/**
	 * @return the cps
	 */
	public double getCps() {
		return cps;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @param cps the cps to set
	 */
	public void setCps(double cps) {
		this.cps = cps;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name + "| Price: " + price;
	}
	
	public int updatePrice() {
		price *= (this.basePrice * (Math.pow(1.15, level) - 1)) / 0.15;
		this.level++;
		return price;
	}
}
