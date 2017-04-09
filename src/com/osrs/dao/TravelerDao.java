package com.osrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.osrs.bean.Traveler;

public class TravelerDao {
	
	private Connection con;
	private ResultSet rs;
	private PreparedStatement ps;
	
	public TravelerDao(Connection con){
		this.con=con;
		this.rs=null;
		this.ps=null;
	}
	
	public String create(Traveler newTraveler){
		String ack = null;
		final String insert_Query ="INSERT INTO traveler VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			ps = con.prepareStatement(insert_Query);
			ps.setString(1, newTraveler.getUserid());
			ps.setString(2, newTraveler.getPassword());
			ps.setString(3, newTraveler.getType());
			ps.setString(4, newTraveler.getFirstName());
			ps.setString(5, newTraveler.getLastName());
			System.out.println("before dob" + newTraveler.getDOB().getTime());
			ps.setDate(6, new java.sql.Date(newTraveler.getDOB().getTime()));
			System.out.println("after dob");
			ps.setInt(7, newTraveler.getAge());
			System.out.println("after age");
			ps.setString(8, newTraveler.getGender());
			System.out.println("after gender");
			ps.setString(9, newTraveler.getAddress());
			System.out.println("after add");
			ps.setLong(10, newTraveler.getPhoneNo());
			ps.setInt(11, newTraveler.getLoginStatus());
			System.out.println("after log");

			int rowAffected = ps.executeUpdate();
			System.out.println("after executed");
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
	public String edit(Traveler user){
		String Ack = null;
		return Ack;
	}
	
	public String remove(String Userid){
		String Ack = null;
		return Ack;
	}
	public Traveler findByid(String userId){
		Traveler newTraveler = null;
		final String Select_Query ="SELECT * FROM traveler WHERE userId=?";
		try {
			ps=con.prepareStatement(Select_Query);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			
			while(rs.next()){
				newTraveler = new Traveler();
				newTraveler.setUserid(rs.getString(1));
				newTraveler.setPassword(rs.getString(2));
				newTraveler.setType(rs.getString(3));
				newTraveler.setFirstName(rs.getString(4));
				newTraveler.setLastName(rs.getString(5));
				newTraveler.setDOB(new java.sql.Date(rs.getDate(6).getTime()));
				newTraveler.setAge(rs.getInt(7));
				newTraveler.setGender(rs.getString(8));
				newTraveler.setAddress(rs.getString(9));
				newTraveler.setPhoneNo(rs.getLong(10));
				
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
		return newTraveler;
	}
	
	public  ArrayList<Traveler> findAll(){
		ArrayList<Traveler> allTravelers = null;
		Traveler newTraveler = null;
		final String Select_Query ="SELECT * FROM traveler ";
		try {
			con.prepareStatement(Select_Query);
			rs = ps.executeQuery();
			allTravelers = new ArrayList<Traveler>();
			while(rs.next()){
				while(rs.next()){
					newTraveler = new Traveler();
					newTraveler.setUserid(rs.getString(1));
					newTraveler.setPassword(rs.getString(2));
					newTraveler.setType(rs.getString(3));
					newTraveler.setFirstName(rs.getString(4));
					newTraveler.setLastName(rs.getString(5));
					newTraveler.setDOB(new java.util.Date(rs.getDate(6).getTime()));
					newTraveler.setAge(rs.getInt(7));
					newTraveler.setGender(rs.getString(8));
					newTraveler.setAddress(rs.getString(9));
					newTraveler.setPhoneNo(rs.getLong(10));
					
				}
				
				allTravelers.add(newTraveler);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return allTravelers;
	}

}
