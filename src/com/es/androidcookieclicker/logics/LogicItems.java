package com.es.androidcookieclicker.logics;


/**
 * @author pfranco
 * @author Carlos B
 *
 */
public class LogicItems extends Item
{
	private double cps;

	private long basePrice;
	private int level;
	private boolean purchasable;
	
	/**
	 * Instantiates a new logic items.
	 *
	 * @param id the id
	 * @param name the name
	 * @param cps the cps
	 * @param basePrice the base price
	 * @param description the description
	 */
	public LogicItems(int id, String name, double cps, long basePrice, String description) {
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
	 * Gets the cps.
	 *
	 * @return the cps
	 */
	public double getCps() {
		return cps;
	}

	/**
	 * Gets the level.
	 *
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Sets the level.
	 *
	 * @param level the new level
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	
	/**
	 * Gets the base price.
	 *
	 * @return the base price
	 */
	public long getBasePrice() {
		return basePrice;
	}

	/**
	 * Sets the base price.
	 *
	 * @param basePrice the new base price
	 */
	public void setBasePrice(long basePrice) {
		this.basePrice = basePrice;
	}
	
	/**
	 * Sets the cps.
	 *
	 * @param cps the cps to set
	 */
	public void setCps(double cps) {
		this.cps = cps;
	}
	
	/**
	 * Checks if is purchasable.
	 *
	 * @return the purchasable
	 */
	public boolean isPurchasable() {
		return purchasable;
	}

	/**
	 * Sets the purchasable.
	 *
	 * @param purchasable the purchasable to set
	 */
	public void setPurchasable(boolean purchasable) {
		this.purchasable = purchasable;
	}
	
	/**
	 * Increment level.
	 */
	public void incrementLevel() {
		level++;
	}
	
	/**
	 * Decrement level.
	 */
	public void decrementLevel() {
		level--;
	}
	
	/**
	 * Update price.
	 *
	 * @return the long
	 */
	public long updatePrice() {
		price =  (long) (this.basePrice * Math.pow(1.15, level));
		return price;
	}
}
