package com.osrs.action;


import java.util.ArrayList;
import org.apache.struts2.interceptor.ServletRequestAware;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.osrs.bean.Reservation;
import com.osrs.bean.Transaction;
import com.osrs.domain.Admin;
import com.osrs.domain.osrsTraveler;
import com.osrs.domain.SiteUser;


public class ReservationAction extends ActionSupport implements ServletRequestAware, Preparable{
	Reservation newReservation;
	ArrayList<String>  ShipIdArrayList;
	Reservation oldReservation;
	ArrayList<String>  ReservationIdArrayList;
	String UserId=SiteUser.UserId;
	
	String ReservationId=null;
	
	
	
	HttpServletRequest request ;
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		reserve= new Reservation();
	}
	@SkipValidation
	public String getInputForm(){
		getShipIdList();
		return SUCCESS;
	}
	
	public String reservationCon(){
		String Response = null;
		int seatfare=0;
		int ticketfare=0;
		if(newReservation.getReservationType().equals("Economy")){
			seatfare=500;
		}else if(newReservation.getReservationType().equals("Business")){
			seatfare=1000;
		}else if(newReservation.getReservationType().equals("First Class")){
			seatfare=1500;
		}
		ticketfare=seatfare*newReservation.getNoOfSheats();
		newReservation.setSeatFare(seatfare);
		newReservation.setTicketFare(ticketfare);
	}
	
	public String getTransaction(){
		return SUCCESS;
	}
	
	public String doReserve(){
		String Response = null;
		osrsTraveler user = new osrsTraveler();
		String DomainResponse = user.reserveTicket(newReservation);
		this.addActionMessage(DomainResponse);
		Response = SUCCESS;
		return Response;
	}
	
	public void getShipIdList(){
		Admin admin=new Admin();
		ShipIdArrayList = admin.getShipId();
	}
	
	@SkipValidation
	public String getReservationIdList(){
		osrsTraveler user = new osrsTraveler();
		ReservationIdArrayList = user.getReservationId(UserId);
		return SUCCESS;
	}
	
	public String getReservation(){
		osrsTraveler user = new osrsTraveler();
		oldReservation = user.getReservation(ReservationId);
		return SUCCESS;
	}
	
	public String cancelReservation()
	{
		String response = null;
		osrsTraveler user = new osrsTraveler();
		String domainResponse = user.removeReservation(ReservationId);
		this.addActionMessage(domainResponse);
		response = SUCCESS;
		return response;
	}
	
	
	/////////////////////////////////////////////////

	public Reservation getNewReservation() {
		return newReservation;
	}
	public void setNewReservation(Reservation newReservation) {
		this.newReservation = newReservation;
	}
	public ArrayList<String> getShipIdArrayList() {
		return ShipIdArrayList;
	}
	public void setShipIdArrayList(ArrayList<String> shipIdArrayList) {
		ShipIdArrayList = shipIdArrayList;
	}
	public Reservation getOldReservation() {
		return oldReservation;
	}
	public void setOldReservation(Reservation oldReservation) {
		this.oldReservation = oldReservation;
	}
	public ArrayList<String> getReservationIdArrayList() {
		return ReservationIdArrayList;
	}
	public void setReservationIdArrayList(ArrayList<String> reservationIdArrayList) {
		ReservationIdArrayList = reservationIdArrayList;
	}
	public String getReservationId() {
		return ReservationId;
	}
	public void setReservationId(String reservationId) {
		ReservationId = reservationId;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	
}
