package com.es.androidcookieclicker;

public class LogicPowerUps extends Item
{
	private int boostType;
	private double boost;
	private int lvlRequired;
	private int itemIdToBoost;
	private boolean purchasable;
	private boolean removed;
	
	
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
	
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getBoostType() {
		return boostType;
	}
	
	public void setBoostType(int boostType) {
		this.boostType = boostType;
	}
	
	public double getBoost() {
		return boost;
	}
	
	public void setBoost(double boost) {
		this.boost = boost;
	}
	
	public int getLvlRequired() {
		return lvlRequired;
	}
	
	public void setLvlRequired(int lvlRequired) {
		this.lvlRequired = lvlRequired;
	}
	
	public int getItemIdToBoost() {
		return itemIdToBoost;
	}
	
	public void setItemIdToBoost(int itemIdToBoost) {
		this.itemIdToBoost = itemIdToBoost;
	}
	public boolean isPurchasable() {
		return purchasable;
	}
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
