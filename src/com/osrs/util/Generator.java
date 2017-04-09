package com.osrs.util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Generator {
	
	public static String genUserid(String Type){
		String NewUserid = null;
		long Numeric = genNumber();
		if(Type.equals("Traveler")){
			NewUserid = "t"+Numeric;
		}else{
			NewUserid = "a"+Numeric;
		}
		System.out.println(Numeric);
		return NewUserid;
	}
	
	private static long genNumber(){
		long Number = 0;
		final String Select_Query= "SELECT osrs_seq.NEXTVAL FROM DUAL"; 
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		Connection con = DataSource.getNewConnection();
		try {
			pstmt = con.prepareStatement(Select_Query);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Number = rs.getLong(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return Number;
		
	}
	
	public static String genShipid(String Type){
		String NewShipid = null;
		long Numeric = genNumber();
		if(Type.equals("Ship")){
			NewShipid = "s"+Numeric;
		}
		System.out.println(Numeric);
		return NewShipid;
	}
	
	public static String genRouteid(String Type){
		String NewRouteid = null;
		long Numeric = genNumber();
		if(Type.equals("Route")){
			NewRouteid= "r"+Numeric;
		}
		System.out.println(Numeric);
		return NewRouteid;
	}
	
	public static String genScheduleid(String Type){
		String NewScheduleid = null;
		long Numeric = genNumber();
		if(Type.equals("Schedule")){
			NewScheduleid= "sh"+Numeric;
		}
		System.out.println(Numeric);
		return NewScheduleid;
	}
	
	public static String genReservationid(String Type){
		String NewReservationid = null;
		long Numeric = genNumber();
		if(Type.equals("Reservation")){
			NewReservationid= "rs"+Numeric;
		}
		System.out.println(Numeric);
		return NewReservationid;
	}
	
}



