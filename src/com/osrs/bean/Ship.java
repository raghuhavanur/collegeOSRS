package com.osrs.bean;

public class Ship {

	private String shipId;
	private String shipName;
	private String source;
	private String destination;
	private String travelDuration;
	private int seatingCapacity;
	private String shipType;
	private int economyCapacity;
	private int businessCapacity;
	private int firstclassCapacity;
	private int fareEconomy;
	private int fareBusiness;
	private int fareFirstclass;

	public int getEconomyCapacity() {
		return economyCapacity;
	}
	public void setEconomyCapacity(int economyCapacity) {
		this.economyCapacity = economyCapacity;
	}
	public int getBusinessCapacity() {
		return businessCapacity;
	}
	public void setBusinessCapacity(int businessCapacity) {
		this.businessCapacity = businessCapacity;
	}
	public int getFirstclassCapacity() {
		return firstclassCapacity;
	}
	public void setFirstclassCapacity(int firstclassCapacity) {
		this.firstclassCapacity = firstclassCapacity;
	}
	public int getFareEconomy() {
		return fareEconomy;
	}
	public void setFareEconomy(int fareEconomy) {
		this.fareEconomy = fareEconomy;
	}
	public int getFareBusiness() {
		return fareBusiness;
	}
	public void setFareBusiness(int fareBusiness) {
		this.fareBusiness = fareBusiness;
	}
	
	public String getTravelDuration() {
		return travelDuration;
	}
	public void setTravelDuration(String travelDuration) {
		this.travelDuration = travelDuration;
	}
	public int getFareFirstclass() {
		return fareFirstclass;
	}
	public void setFareFirstclass(int fareFirstclass) {
		this.fareFirstclass = fareFirstclass;
	}
	public int getSeatingCapacity() {
		return seatingCapacity;
	}
	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
	
	public String getShipId() {
		return shipId;
	}
	public void setShipId(String shipId) {
		this.shipId = shipId;
	}
	public String getShipName() {
		return shipName;
	}
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	
	
	
	public String getShipType() {
		return shipType;
	}
	public void setShipType(String shipType) {
		this.shipType = shipType;
	}
	

}
