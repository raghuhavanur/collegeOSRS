package com.osrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.osrs.bean.Ship;

public class ShipDao {

	private Connection con;
	private ResultSet rs;
	private PreparedStatement ps;
	
	public ShipDao(Connection con){
		this.con=con;
		this.rs=null;
		this.ps=null;
	}
	
	public String addShip(Ship newShip){
		String ack = null;
		final String insert_Query ="INSERT INTO ship VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			ps = con.prepareStatement(insert_Query);
			ps.setString(1, newShip.getShipId());
			ps.setString(2, newShip.getShipName());
			ps.setString(3, newShip.getSource());
			ps.setString(4, newShip.getDestination());
			ps.setString(5, newShip.getTravelDuration());
			ps.setInt(6, newShip.getSeatingCapacity());
			ps.setString(7, newShip.getShipType());
			ps.setInt(8, newShip.getEconomyCapacity());
			ps.setInt(9, newShip.getBusinessCapacity());
			ps.setInt(10, newShip.getFirstclassCapacity());
			ps.setInt(11, newShip.getFareEconomy());
			ps.setInt(12, newShip.getFareBusiness());
			ps.setInt(13, newShip.getFareFirstclass());


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
	
	public ArrayList<String> getShipId()
	{
		ArrayList<String> shipIdArrayList=null;
		final String select_Query ="SELECT shipId FROM ship";
		try {
			ps=con.prepareStatement(select_Query);
			rs = ps.executeQuery();
			shipIdArrayList = new ArrayList<String>();
			
			while(rs.next()) {				
				shipIdArrayList.add(rs.getString(1));
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
		return shipIdArrayList;
	}
	
	public Ship findById(String shipId){
		Ship newShip = null;
		final String select_Query ="SELECT * FROM ship WHERE shipId=?";
		try {
			ps=con.prepareStatement(select_Query);
			ps.setString(1, shipId);
			rs = ps.executeQuery();
			
			while(rs.next()){
				newShip = new Ship();
								
				newShip.setShipId(rs.getString(1));
				newShip.setShipName(rs.getString(2));
				newShip.setSource(rs.getString(3));
				newShip.setDestination(rs.getString(4));
				newShip.setTravelDuration(rs.getString(5));
				newShip.setSeatingCapacity(rs.getInt(6));
				newShip.setShipType(rs.getString(7));
				newShip.setEconomyCapacity(rs.getInt(8));
				newShip.setBusinessCapacity(rs.getInt(9));
				newShip.setFirstclassCapacity(rs.getInt(10));
				newShip.setFareEconomy(rs.getInt(11));
				newShip.setFareBusiness(rs.getInt(12));
				newShip.setFareFirstclass(rs.getInt(13));
				
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
		return newShip;
	}
	
	
	public String modifyShip(Ship newShip){
		String ack = null;
        System.out.println("modi");
       
		final String update_Query ="update ship set shipName=?," +
				"source=?,destination=?,travelDuration=?,seatingCapacity=?," +
				"shipType=?,economyCapacity=?,businessCapacity=?," +
				"firstClassCapacity=?,fareEconomy=?,fareBusiness=?,fareFirstClass=? where shipId=?";
		
		try {
			ps = con.prepareStatement(update_Query);
	        System.out.println("modi1");
			ps.setString(1, newShip.getShipName());
			ps.setString(2, newShip.getSource());
			ps.setString(3, newShip.getDestination());
			ps.setString(4, newShip.getTravelDuration());
			ps.setInt(5, newShip.getSeatingCapacity());
			ps.setString(6, newShip.getShipType());
			ps.setInt(7, newShip.getEconomyCapacity());
			ps.setInt(8, newShip.getBusinessCapacity());
			ps.setInt(9, newShip.getFirstclassCapacity());
			ps.setInt(10, newShip.getFareEconomy());
			ps.setInt(11, newShip.getFareBusiness());
			ps.setInt(12, newShip.getFareFirstclass());
			ps.setString(13, newShip.getShipId());
	        System.out.println("modi end");


			int rowAffected = ps.executeUpdate();
			
			if(rowAffected != 0){
				ack="Updated";
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
	public String removeShip(String shipId){
		String ack = null;
		
		final String insert_Query ="DELETE FROM ship WHERE shipid=?";
		try {
			ps = con.prepareStatement(insert_Query);
			ps.setString(1,shipId);
			
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
	
}
