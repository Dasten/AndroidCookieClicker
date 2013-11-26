package com.es.androidcookieclicker;

public class LogicPowerUps {
	private int id;
	private String name;
	private int boostType;
	private double boost;
	private long price;
	private int lvlRequired;
	
	
	public LogicPowerUps(int id, String name, int boostType, double boost,
			long price, int lvlRequired) {
		super();
		this.id = id;
		this.name = name;
		this.boostType = boostType;
		this.boost = boost;
		this.price = price;
		this.lvlRequired = lvlRequired;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
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
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public int getLvlRequired() {
		return lvlRequired;
	}
	public void setLvlRequired(int lvlRequired) {
		this.lvlRequired = lvlRequired;
	}
	

	
}
