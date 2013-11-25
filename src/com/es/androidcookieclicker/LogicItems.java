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

	private long basePrice;
	private long price;
	private int level;
	
	LogicItems(int id, String name, double cps, long basePrice) {
		this.id = id;
		this.name = name;
		this.cps = cps;
		this.price = basePrice;
		this.basePrice = basePrice;
		this.level = 0;
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
	public long getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(long price) {
		this.price = price;
	}
	
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

	
	public long getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(long basePrice) {
		this.basePrice = basePrice;
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
		return name + "\nCoste: " + price;
	}
	
	public long updatePrice() {
		this.level++;
		price =  (long) (this.basePrice * Math.pow(1.15, level));
		return price;
	}


}
