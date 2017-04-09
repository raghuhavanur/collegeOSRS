package com.osrs.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.osrs.bean.Schedule;


public class ScheduleDao 
{

	private Connection con;
	private ResultSet rs;
	private PreparedStatement ps;
	
	public ScheduleDao(Connection con){
		this.con=con;
		this.rs=null;
		this.ps=null;
	}
	
	public String addSchedule(Schedule newSchedule){
		String ack = null;
		final String insert_Query ="INSERT INTO schedule VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			ps = con.prepareStatement(insert_Query);
			ps.setString(1, newSchedule.getScheduleId());
			ps.setString(2, newSchedule.getShipId());
			ps.setString(3, newSchedule.getShipName());
			ps.setString(4, newSchedule.getRouteId());
			ps.setString(5, newSchedule.getMonday());
			ps.setString(6, newSchedule.getTuesday());
			ps.setString(7, newSchedule.getWednesday());
			ps.setString(8, newSchedule.getThursday());
			ps.setString(9, newSchedule.getFriday());
			ps.setString(10, newSchedule.getSaturday());
			ps.setString(11, newSchedule.getSunday());

			
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
	
	public ArrayList<String> getScheduleId()
	{
		ArrayList<String> scheduleIdArrayList=null;
		final String select_Query ="SELECT scheduleid FROM schedule";
		try {
			ps=con.prepareStatement(select_Query);
			rs = ps.executeQuery();
			scheduleIdArrayList = new ArrayList<String>();
			
			while(rs.next()) {				
				scheduleIdArrayList.add(rs.getString(1));
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
		return scheduleIdArrayList;
	}
	
	public Schedule findById(String scheduleId){
		Schedule newSchedule = null;
		final String select_Query ="SELECT * FROM schedule WHERE scheduleId=?";
		try {
			ps=con.prepareStatement(select_Query);
			ps.setString(1, scheduleId);
			rs = ps.executeQuery();
			
			while(rs.next()){
				newSchedule = new Schedule();
				newSchedule.setScheduleId(rs.getString(1));			
				newSchedule.setShipId(rs.getString(2));
				newSchedule.setShipName(rs.getString(3));
				newSchedule.setRouteId(rs.getString(4));
				newSchedule.setMonday(rs.getString(5));
				newSchedule.setTuesday(rs.getString(6));
				newSchedule.setWednesday(rs.getString(7));
				newSchedule.setThursday(rs.getString(8));
				newSchedule.setFriday(rs.getString(9));
				newSchedule.setSaturday(rs.getString(10));
				newSchedule.setSunday(rs.getString(11));

				
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
		return newSchedule;
	}
	
	public String modifySchedule(Schedule newSchedule){
		String ack = null;
		final String update_Query ="UPDATE schedule SET monday=?,tuesday=?, wednesday=?, thursday=?, friday=?, saturday=? , sunaday=? WHERE scheduleid=?";
		
		try {
			ps = con.prepareStatement(update_Query);
			ps.setString(1, newSchedule.getMonday());
			ps.setString(2, newSchedule.getTuesday());
			ps.setString(3, newSchedule.getWednesday());
			ps.setString(4, newSchedule.getThursday());
			ps.setString(5, newSchedule.getFriday());
			ps.setString(6, newSchedule.getSaturday());
			ps.setString(7, newSchedule.getSunday());
			ps.setString(8, newSchedule.getScheduleId());

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
	
	
	public String removeSchedule(String scheduleId){
		String ack = null;
		
		final String insert_Query ="DELETE FROM schedule WHERE scheduleId=?";
		try {
			ps = con.prepareStatement(insert_Query);
			ps.setString(1,scheduleId);
			
			int rowAffected = ps.executeUpdate();
			
			if(rowAffected != 0){
				ack="Deleted";
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
