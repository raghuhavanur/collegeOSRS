package com.osrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.osrs.bean.Transaction;

	public class TransactionDao {

		private Connection con;
		private ResultSet rs;
		private PreparedStatement ps;
		
		public TransactionDao(Connection con){
			this.con=con;
			this.rs=null;
			this.ps=null;
		}
		
		public String create(Transaction newTransaction){
			String ack = null;
			final String insert_Query ="INSERT INTO transaction values(?,?,?,?,?)";
			
			try {
				ps = con.prepareStatement(insert_Query);
				ps.setLong(1,newTransaction.getCreditcardNo());
				ps.setDate(2, new java.sql.Date(newTransaction.getCreditcardValFrom().getTime()));
				ps.setDate(3, new java.sql.Date(newTransaction.getCreditcardValTo().getTime()));
				ps.setInt(4,newTransaction.getBalance());
				ps.setString(5,newTransaction.getReservationId());
				
				
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
