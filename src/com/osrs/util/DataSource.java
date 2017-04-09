package com.osrs.util;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class DataSource {
		
		private static String DriverName = "oracle.jdbc.driver.OracleDriver";
		private static String DriverType = "jdbc:oracle:thin:";
		private static String Host       = "192.168.250.128";
		private static String Port       = "1521";
		private static String Sid        = "orcl";
		private static String UserName   = "scott";
		private static String Password   = "tiger";
		
				
		public static String getUserName() {
			return UserName;
		}

		public static void setUserName(String userName) {
			UserName = userName;
		}

		public static String getPassword() {
			return Password;
		}

		public static void setPassword(String password) {
			Password = password;
		}

		private static String getUrl() {
			return (DriverType+"@"+Host+":"+Port+":"+Sid);
		}
		
		public static Connection getNewConnection(){
			Connection con= null;
			try {
				//Class.forName(DriverName).newInstance();
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.250.128:1521:orcl","scott","tiger");
				
				//con = DriverManager.getConnection(getUrl(), getUserName(), getPassword());
				//System.out.println(":OPEN CONNECTION =>>"+con);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e){
				e.printStackTrace();
			}
			
		return con;	
		}

	}

