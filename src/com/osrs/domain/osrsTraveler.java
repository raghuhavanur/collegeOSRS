package com.osrs.domain;
import com.osrs.action.TransactionAction;
import com.osrs.bean.Credential;
import com.osrs.bean.Reservation;
import com.osrs.bean.Ship;
import com.osrs.bean.Traveler;
import com.osrs.dao.ShipDao;
import com.osrs.dao.TravelerDao;
import com.osrs.util.DataSource;
import com.osrs.util.Generator;
public class osrsTraveler {
	
	String ReservationId=Generator.genReservationid("Reservation");


		Credential UserCredential;

		public Credential getUserCredential() {
			return UserCredential;
		}

		public void setUserCredential(Credential userCredential) {
			UserCredential = userCredential;
		}
		
		/////////////--------Traveler Registration------/////////////
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
		
		///////////////-----------RESERVE TICKET--------///////////////
		public String reserveTicket(Reservation newReservation){
			String Ack =null;
			if(newReservation != null){
				ReservationDao udao = new ReservationDao(DataSource.getNewConnection());
				newReservation.setReserveId(ReservationId);
				String DaoAck = udao.create(newReservation);
				if(DaoAck != null){
					if(DaoAck.equalsIgnoreCase("Saved")){
						Ack = "RESERVED SUCCESSFULL, YOUR RESERVATION ID:" +newReservation.getReserveId() ;
					}
				}else{
					Ack ="THERE IS AN ERROR !";
				}
				
			}else {
				Ack="INSERTION ERROR";
			}
			
			return Ack;
		}
		
		//////////////-----------MAKE PAYMENT------------/////////////
		public String doPayment(Transaction newTransaction){
			String Ack =null;
			if(newTransaction != null){
				TransactionDao udao = new TransactionDao(DataSource.getNewConnection());
				newTransaction.setReservationId(ReservationId);
				String DaoAck = udao.create(newTransaction);
				if(DaoAck != null){
					if(DaoAck.equalsIgnoreCase("Saved")){
						Ack = " PAYMENT DONE SUCCESSFULL";
					}
				}else{
					Ack ="THERE IS AN ERROR !";
				}
				
			}else {
				Ack="INSERTION ERROR";
			}
			
			return Ack;
		}
		
		
		//////////////----------CANCEL RESERVATION---------/////////////
		public ArrayList<String> getReservationId(String UserId)
		{
			ArrayList<String> ReservationIdArrayList = null;
			ReservationDao fDao = new ReservationDao(DataSource.getNewConnection());
			ReservationIdArrayList = fDao.getReservationId(UserId);
					
			return ReservationIdArrayList;
		}
		
		public Reservation getReservation(String ReservationId)
		{
			Reservation oldReservation=new Reservation();
			ReservationDao fDao = new ReservationDao(DataSource.getNewConnection());
			oldReservation = fDao.findById(ReservationId);		
			return oldReservation;
		}
		
		public String removeReservation(String ReservationId)
		{
			String ack = null;
			if(ReservationId!=null)
			{
				ReservationDao fDao = new ReservationDao(DataSource.getNewConnection());
				String Daoack = fDao.removeReservation(ReservationId);
				if(Daoack!=null){
					if(Daoack.equalsIgnoreCase("Removed")){
						ack = "TICKET CANCELLED SUCCESSFULLY!!!";
					}
				}
				else{
					ack="THERE IS AN ERROR";
				}
				    
			}
			else
			{
				ack ="CANCELLATION ERROR";
			}
			return ack;
		}
		
		
	}


