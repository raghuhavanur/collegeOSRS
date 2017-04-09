 package com.osrs.dao;

import java.sql.Date;
import java.sql.Time;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.osrs.bean.Reservation;
import com.osrs.bean.Ship;
import com.osrs.bean.Traveler;

public class ReservationDao {
	private Connection con;
	private ResultSet rs;
	private PreparedStatement ps;
	
	public ReservationDao() {
		this.con=con;
		this.rs=null;
		this.ps=null;
	}
	
	public String create(Reservation newReservation){
		String ack = null;
		
		final String insert_Query ="INSERT INTO reserve VALUES(?, ?, ?, ?, ?, ?, ?,?)";
		try {
			ps = con.prepareStatement(insert_Query);
			ps.setString(1,newReservation.getReserveId() );
			ps.setString(2,newReservation.getUserId() );
			ps.setString(3,newReservation.getShipId());
			ps.setDate(4, new java.sql.Date(newReservation.getDateOfJourney().getTime()));
			ps.setInt(5, newReservation.getNoOfSheats());
			ps.setString(6, newReservation.getReservationType());
			ps.setInt(7, newReservation.getSeatFare());
			ps.setInt(8,  newReservation.getTicketFare());

			int rowAffected = ps.executeUpdate();
			
			if(rowAffected != 0){
				ack="Saved";
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ack;
	}	
	
	public ArrayList<String> getReservationId(String UserId)
	{
		ArrayList<String> ReservationIdArrayList=null;
		final String select_Query ="SELECT reservationid FROM reservation WHERE userid=?";
		try {
			ps=con.prepareStatement(select_Query);
			ps.setString(1,UserId);
			rs = ps.executeQuery();
			ReservationIdArrayList = new ArrayList<String>();
			
			while(rs.next()) {				
				ReservationIdArrayList.add(rs.getString(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return ReservationIdArrayList;
	}
	
	public Reservation findById(String ReservationId){
		Reservation newReservation = null;
		final String select_Query ="SELECT * FROM reservation WHERE reservationid=?";
		try {
			ps=con.prepareStatement(select_Query);
			ps.setString(1, ReservationId);
			rs = ps.executeQuery();
			
			while(rs.next()){
				newReservation = new Reservation();
				newReservation.setReserveId(rs.getString(1));
				newReservation.setUserId(rs.getString(2));
				newReservation.setShipId(rs.getString(3));
				newReservation.setDateOfJourney(new java.sql.Date(rs.getDate(4).getTime()));
				newReservation.setNoOfSheats(rs.getInt(5));
				newReservation.setReservationType(rs.getString(6));
				newReservation.setSeatFare(rs.getInt(7));
				newReservation.setTicketFare(rs.getInt(8));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return newReservation;
	}

	public String removeReservation(String reserveId){
		String ack = null;
		
		final String delete_Query ="DELETE FROM reservation WHERE reserveId=? and userid=?";
		try {
			ps = con.prepareStatement(delete_Query);
			ps.setString(1,reserveId);
			
			int rowAffected = ps.executeUpdate();
			
			if(rowAffected != 0){
				ack="Removed";
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ack;
	}	
	
	public String viewTicket(String reserveId){
		String ack = null;
		
		final String insert_Query ="INSERT INTO reserve VALUES(?, ?, ?, ?, ?, ?, ?)";
		try {
			

			int rowAffected = ps.executeUpdate();
			
			if(rowAffected != 0){
				ack="saved";
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ack;
	}		

	

}
