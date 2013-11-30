/*
 * 
 */
package com.es.androidcookieclicker;

/**
 * @author pfranco
 * @author Carlos B
 *
 */
public class LogicPowerUps extends Item
{
	private int boostType;
	private double boost;
	private int lvlRequired;
	private int itemIdToBoost;
	private boolean purchasable;
	private boolean removed;
	
	
	/**
	 * Instantiates a new logic power ups.
	 *
	 * @param id the id
	 * @param name the name
	 * @param boostType the boost type
	 * @param boost the boost
	 * @param price the price
	 * @param lvlRequired the lvl required
	 * @param itemIdToBoost the item id to boost
	 */
	public LogicPowerUps(int id, String name, int boostType, double boost,
			long price, int lvlRequired, int itemIdToBoost) {
		super();
		this.id = id;
		this.name = name;
		this.boostType = boostType;
		this.boost = boost;
		this.price = price;
		this.lvlRequired = lvlRequired;
		this.itemIdToBoost = itemIdToBoost;
		this.purchasable = false;
		this.removed = false;
	}
	
	
	/* (non-Javadoc)
	 * @see com.es.androidcookieclicker.Item#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the boost type.
	 *
	 * @return the boost type
	 */
	public int getBoostType() {
		return boostType;
	}
	
	/**
	 * Sets the boost type.
	 *
	 * @param boostType the new boost type
	 */
	public void setBoostType(int boostType) {
		this.boostType = boostType;
	}
	
	/**
	 * Gets the boost.
	 *
	 * @return the boost
	 */
	public double getBoost() {
		return boost;
	}
	
	/**
	 * Sets the boost.
	 *
	 * @param boost the new boost
	 */
	public void setBoost(double boost) {
		this.boost = boost;
	}
	
	/**
	 * Gets the lvl required.
	 *
	 * @return the lvl required
	 */
	public int getLvlRequired() {
		return lvlRequired;
	}
	
	/**
	 * Sets the lvl required.
	 *
	 * @param lvlRequired the new lvl required
	 */
	public void setLvlRequired(int lvlRequired) {
		this.lvlRequired = lvlRequired;
	}
	
	/**
	 * Gets the item id to boost.
	 *
	 * @return the item id to boost
	 */
	public int getItemIdToBoost() {
		return itemIdToBoost;
	}
	
	/**
	 * Sets the item id to boost.
	 *
	 * @param itemIdToBoost the new item id to boost
	 */
	public void setItemIdToBoost(int itemIdToBoost) {
		this.itemIdToBoost = itemIdToBoost;
	}
	
	/**
	 * Checks if is purchasable.
	 *
	 * @return true, if is purchasable
	 */
	public boolean isPurchasable() {
		return purchasable;
	}
	
	/**
	 * Sets the purchasable.
	 *
	 * @param purchasable the new purchasable
	 */
	public void setPurchasable(boolean purchasable) {
		this.purchasable = purchasable;
	}
	
	/**
	 * @return the removed
	 */
	public boolean isRemoved() {
		return removed;
	}
	
	/**
	 * @param removed the removed to set
	 */
	public void setRemoved(boolean removed) {
		this.removed = removed;
	}	
}
