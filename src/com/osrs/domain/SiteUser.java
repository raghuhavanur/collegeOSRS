package com.osrs.domain;
import javax.servlet.http.HttpSession;

import com.osrs.bean.Credential;
import com.osrs.bean.Traveler;
import com.osrs.dao.TravelerDao;
import com.osrs.util.DataSource;
import com.osrs.util.Generator;


public class SiteUser {


		public static String UserId;
		public String checkCredential(Credential credential){
			String Ack =null;
			if(credential != null){
				TravelerDao udao = new TravelerDao(DataSource.getNewConnection());
				Traveler TheUser = udao.findByid(credential.getUserid());
				if(TheUser != null){
					if(TheUser.getPassword().equals(credential.getPassword())){
						System.out.println(TheUser.getType()+"db -- jsp" + credential.getType());
						if(TheUser.getType().equals(credential.getType()) ){
							credential.setName(TheUser.getFirstName()+" "+TheUser.getLastName());
							UserId= credential.getUserid();
							Ack ="valid";
						}else{
							Ack="SELECT CORRECT TYPE";
						}
					}else{
						Ack="ENTER CORRECT PASSWOPRD";
					}
				}else{
					Ack = "ENTER VALID USERID";
				}
			}
			
			return Ack;
		}
		
		public String createNewUserSession( HttpSession UserSession, Credential UserCredential){
			
			final String CustomerHomeUrl ="Traveler_home.jsp"; 
			final String AdminHomeUrl ="Admin_home.jsp";
			String AckUrl = null;
			if(UserCredential != null){
				
				if(UserCredential.getType().equals("Traveler")){
					User customer = new User();
					customer.setUserCredential(UserCredential);
					UserSession.setAttribute("USER", customer);
					AckUrl=CustomerHomeUrl;
				}else{
					Admin admin = new Admin();
					admin.setUserCredential(UserCredential);
					UserSession.setAttribute("USER", admin);
					AckUrl=AdminHomeUrl;
				}
				
			}
			return AckUrl;
			
		}
		
		public String registerTraveler(Traveler user){
			String Ack =null;
			if(user != null){
				TravelerDao udao = new TravelerDao(DataSource.getNewConnection());
				user.setType("Traveler");
				user.setUserid(Generator.genUserid(user.getType()));
				String DaoAck = udao.create(user);
				if(DaoAck != null){
					if(DaoAck.equalsIgnoreCase("saved")){
						Ack = "REGISTRATION SUCCESSFULL, YOUR USERID :"+user.getUserid();
					}
				}else{
					Ack ="THERE IS AN ERROR !";
				}
				
			}
			
			return Ack;
		}

	}


