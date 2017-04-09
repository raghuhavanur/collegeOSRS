package com.osrs.bean;
import java.util.Date;
import java.util.Date;
public class Traveler {
	

		
		private String Userid;
		private String Password;
		private String RTP;
		private String Type;
		private String FirstName;
		private String LastName;
		private Date DOB;
		private int Age;
		
		private String Gender;
		private String Address;
	    private long PhoneNo;
		
		private int LoginStatus;
		
		
		public String getUserid() {
			return Userid;
		}
		public void setUserid(String userid) {
			Userid = userid;
		}
		public String getPassword() {
			return Password;
		}
		public int getLoginStatus() {
			return LoginStatus;
		}
		public void setLoginStatus(int loginStatus) {
			LoginStatus = loginStatus;
		}
		public void setPassword(String password) {
			Password = password;
		}
		public String getType() {
			return Type;
		}
		public int getAge() {
			return Age;
		}
		public void setAge(int age) {
			Age = age;
		}
		public String getGender() {
			return Gender;
		}
		public void setGender(String gender) {
			Gender = gender;
		}
		public void setType(String type) {
			Type = type;
		}
		public String getFirstName() {
			return FirstName;
		}
		public void setFirstName(String firstName) {
			FirstName = firstName;
		}
		public String getLastName() {
			return LastName;
		}
		public void setLastName(String lastName) {
			LastName = lastName;
		}
		
		public Date getDOB() {
			return DOB;
		}
		public void setDOB(Date dOB) {
			DOB = dOB;
		}
		public String getAddress() {
			return Address;
		}
		public void setAddress(String address) {
			Address = address;
		}
		public long getPhoneNo() {
			return PhoneNo;
		}
		public void setPhoneNo(long phoneNo) {
			PhoneNo = phoneNo;
		}

		
		public String getRTP() {
			return RTP;
		}
		public void setRTP(String rTP) {
			RTP = rTP;
		}
		
		
	}


