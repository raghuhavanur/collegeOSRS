package com.osrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.osrs.bean.Route;

public class RouteDao {

	private Connection con;
	private ResultSet rs;
	private PreparedStatement ps;
	
	public RouteDao(Connection con){
		this.con=con;
		this.rs=null;
		this.ps=null;
	}
	
	public String addRoute(Route newRoute){
		String ack = null;
		final String insert_Query ="INSERT INTO route VALUES(?, ?)";
		
		try {
			ps = con.prepareStatement(insert_Query);
			ps.setString(1, newRoute.getRouteId());
			ps.setString(2, newRoute.getRouteName());		
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
	
	public ArrayList<String> getRouteId()
	{
		ArrayList<String> routeIdArrayList=null;
		final String select_Query ="SELECT routeId FROM route";
		try {
			ps=con.prepareStatement(select_Query);
			rs = ps.executeQuery();
			routeIdArrayList = new ArrayList<String>();
			
			while(rs.next()) {				
				routeIdArrayList.add(rs.getString(1));
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
		return routeIdArrayList;
	}
	
	public Route findById(String routeId){
		Route newRoute = null;
		final String select_Query ="SELECT * FROM route WHERE routeId=?";
		try {
			ps=con.prepareStatement(select_Query);
			ps.setString(1, routeId);
			rs = ps.executeQuery();
			
			while(rs.next()){
				newRoute = new Route();
								
				newRoute.setRouteId(rs.getString(1));
				newRoute.setRouteName(rs.getString(2));
				
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
		return newRoute;
	}
	
	public String modifyRoute(Route newRoute){
		String ack = null;
		final String update_Query ="UPDATE route SET routename=? where routeid=?";
		
		try {
			ps = con.prepareStatement(update_Query);
			
			ps.setString(1, newRoute.getRouteName());
			ps.setString(2, newRoute.getRouteId());

			
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
	
	public String removeRoute(String routeId){
		String ack = null;
		
		final String delete_Query ="DELETE FROM route WHERE routeId=?)";
		try {
			ps = con.prepareStatement(delete_Query);
			ps.setString(1,routeId);
			
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
