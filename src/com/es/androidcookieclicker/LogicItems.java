package com.es.androidcookieclicker;


public class LogicItems extends Item
{
	private double cps;

	private long basePrice;
	private int level;
	private boolean purchasable;
	
	LogicItems(int id, String name, double cps, long basePrice, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.cps = cps;
		this.price = basePrice;
		this.basePrice = basePrice;
		this.level = 0;
		this.purchasable = false;
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
	
	/**
	 * @return the purchasable
	 */
	public boolean isPurchasable() {
		return purchasable;
	}

	/**
	 * @param purchasable the purchasable to set
	 */
	public void setPurchasable(boolean purchasable) {
		this.purchasable = purchasable;
	}
	
	public void incrementLevel() {
		level++;
	}
	
	public void decrementLevel() {
		level--;
	}
	
	public long updatePrice() {
		price =  (long) (this.basePrice * Math.pow(1.15, level));
		return price;
	}


}
