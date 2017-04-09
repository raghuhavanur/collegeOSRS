package com.osrs.bean;

import java.util.Date;

public class Transaction {
	private long CreditcardNo;
	private Date CreditcardValFrom;
	private Date CreditcardValTo;
	private int Balance;
	private String ReservationId;

	public String getReservationId() {
		return ReservationId;
	}
	public void setReservationId(String reservationId) {
		ReservationId = reservationId;
	}
	public long getCreditcardNo() {
		return CreditcardNo;
	}
	public void setCreditcardNo(long creditcardNo) {
		CreditcardNo = creditcardNo;
	}
	public Date getCreditcardValFrom() {
		return CreditcardValFrom;
	}
	public void setCreditcardValFrom(Date creditcardValFrom) {
		CreditcardValFrom = creditcardValFrom;
	}
	public Date getCreditcardValTo() {
		return CreditcardValTo;
	}
	public void setCreditcardValTo(Date creditcardValTo) {
		CreditcardValTo = creditcardValTo;
	}
	public int getBalance() {
		return Balance;
	}
	public void setBalance(int balance) {
		Balance = balance;
	}

}