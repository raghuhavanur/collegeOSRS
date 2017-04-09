package com.osrs.bean;

import java.util.Date;

public class Reservation {
	
	private String ReserveId;
	private String UserId;
	private String ShipId;

	private Date DateOfJourney;
	
	private int NoOfSheats;
	private String ReservationType;
	private int SeatFare;
	private int TicketFare;
	
	public int getSeatFare() {
		return SeatFare;
	}
	public void setSeatFare(int seatFare) {
		SeatFare = seatFare;
	}
	

	public String getReserveId() {
		return ReserveId;
	}
	public void setReserveId(String reserveId) {
		ReserveId = reserveId;
	}
	public String getUserId() {
		return UserId;
	}
	public Date getDateOfJourney() {
		return DateOfJourney;
	}
	public void setDateOfJourney(Date dateOfJourney) {
		DateOfJourney = dateOfJourney;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getShipId() {
		return ShipId;
	}
	public void setShipId(String shipId) {
		ShipId = shipId;
	}
	
	public int getNoOfSheats() {
		return NoOfSheats;
	}
	public void setNoOfSheats(int noOfSheats) {
		NoOfSheats = noOfSheats;
	}
	public Double getTicketFare() {
		return TicketFare;
	}
	public void setTicketFare(int ticketFare) {
		TicketFare = ticketFare;
	}
	public String getReservationType() {
		return ReservationType;
	}
	public void setReservationType(String reservationType) {
		ReservationType = reservationType;
	}
	
}
