package com.osrs.domain;

import java.util.ArrayList;

import com.osrs.bean.Ship;
import com.osrs.bean.Route;
import com.osrs.bean.Schedule;
import com.osrs.dao.ShipDao;
import com.osrs.dao.RouteDao;
import com.osrs.dao.ScheduleDao;
import com.osrs.util.DataSource;
import com.osrs.util.Generator;


public class Admin extends User {
	
	////////-----------SHIP MANAGER--------------//////////
	
	public String addShip(Ship newShip)
	{
		String ack = null;
		if(newShip!=null)
		{
			ShipDao fDao = new ShipDao(DataSource.getNewConnection());
			newShip.setShipId(Generator.genShipid("Ship"));
			Sting Daoack = fDao.addShip(newShip);
			if(Daoack!=null){
				if(Daoack.equalsIgnoreCase("saved")){
					ack = "SHIP ADD SUCCESSFULL, YOUR SHIPID :"+newShip.getShipId();
				}
			}
			else{
				ack="THERE IS AN ERROR";
			}
			    
		}
		else
		{
			ack ="INSERTION ERROR";
		}
			
		return ack;
	}
	
	
	
	public ArrayList<String> getShipId()
	{
		ArrayList<String> shipIdArrayList = null;
		ShipDao fDao = new ShipDao(DataSource.getNewConnection());
		shipIdArrayList = fDao.getShipId();
				
		return shipIdArrayList;
	}
	
	public Ship getShip(String shipId)
	{
		System.out.println(shipId +" is");
		Ship oldShip=new Ship();
		ShipDao fDao = new ShipDao(DataSource.getNewConnection());
		oldShip = fDao.findById(shipId);		
		return oldShip;
	}

	public String modifyShip(Ship newShip)
	{
		String ack = null;
		if(newShip!=null)
		{
			ShipDao fDao = new ShipDao(DataSource.getNewConnection());
			String Daoack = fDao.modifyShip(newShip);
			if(Daoack!=null){
				if(Daoack.equalsIgnoreCase("Updated")){
					ack = "SHIP MODIFIED SUCCESSFULLY!!!";
				}
			}
			else{
				ack="THERE IS AN ERROR";
			}
			    
		}
		else
		{
			ack ="MODIFICATION ERROR";
		}
			
		return ack;
	}
		
	public String removeShip(String shipId)
	{
		String ack = null;
		if(shipId!=null)
		{
			ShipDao fDao = new ShipDao(DataSource.getNewConnection());
			String Daoack = fDao.removeShip(shipId);
			if(Daoack!=null){
				if(Daoack.equalsIgnoreCase("Removed")){
					ack = "SHIP REMOVED SUCCESSFULLY!!!";
				}
			}
			else{
				ack="THERE IS AN ERROR";
			}
			    
		}
		else
		{
			ack ="DELETION ERROR";
		}
		return ack;
	}

	
	/////////////---------ROUTE MANAGER---------/////////////////
	
	public String addRoute(Route newRoute)
	{
		String ack = null;
		if(newRoute!=null)
		{
			RouteDao rDao = new RouteDao(DataSource.getNewConnection());
			newRoute.setRouteId(Generator.genRouteid("Route"));
			String Daoack = rDao.addRoute(newRoute);
			if(Daoack!=null){
				if(Daoack.equalsIgnoreCase("saved")){
					ack = "ROUTE ADDED SUCCESSFULL, YOUR ROUTEID :"+newRoute.getRouteId();
				}
			}
			else{
				ack="THERE IS AN ERROR";
			}
			    
		}
		else
		{
			ack ="INSERTION ERROR";
		}
			
		return ack;
	}
	
	public ArrayList<String> getRouteId()
	{
		ArrayList<String> routeIdArrayList = null;
		RouteDao rDao = new RouteDao(DataSource.getNewConnection());
		routeIdArrayList = rDao.getRouteId();
				
		return routeIdArrayList;
	}
	
	public Route getRoute(String routeId)
	{
		Route oldRoute=new Route();;
		RouteDao fDao = new RouteDao(DataSource.getNewConnection());
		oldRoute = fDao.findById(routeId);		
		return oldRoute;
	}
	
	public String modifyRoute(Route newRoute)
	{
		String ack = null;
		if(newRoute!=null)
		{
			RouteDao fDao = new RouteDao(DataSource.getNewConnection());
			String Daoack = fDao.modifyRoute(newRoute);
			if(Daoack!=null){
				if(Daoack.equalsIgnoreCase("Updated")){
					ack = "ROUTE MODIFIED SUCCESSFULLY!!!";
				}
			}
			else{
				ack="THERE IS AN ERROR";
			}
			    
		}
		else
		{
			ack ="MODIFICATION ERROR";
		}
			
			
		return ack;
	}
	
	public String removeRoute(String routeId)
	{
		String ack = null;
		if(routeId!=null)
		{
			RouteDao fDao = new RouteDao(DataSource.getNewConnection());
			String Daoack = fDao.removeRoute(routeId);
			if(Daoack!=null){
				if(Daoack.equalsIgnoreCase("Removed")){
					ack = "ROUTE REMOVED SUCCESSFULLY!!!";
				}
			}
			else{
				ack="THERE IS AN ERROR";
			}
			    
		}
		else
		{
			ack ="DELETION ERROR";
		}
			
		return ack;
	}
	
	
	////////////---------SCHEDULE MANAGE----------//////////////
	
	public String addSchedule(Schedule newSchedule)
	{
		String ack = null;
		if(newSchedule!=null)
		{
			ScheduleDao sDao = new ScheduleDao(DataSource.getNewConnection());
			newSchedule.setScheduleId(Generator.genScheduleid("Schedule"));
			String Daoack = sDao.addSchedule(newSchedule);
			if(Daoack!=null){
				if(Daoack.equalsIgnoreCase("saved")){
					ack = "SCHEDULE ADDED SUCCESSFULL, YOUR SCHEDULEID :"+newSchedule.getScheduleId();
				}
			}
			else{
				ack="THERE IS AN ERROR";
			}
			    
		}
		else
		{
			ack ="INSERTION ERROR";
		}
			
		return ack;
	}
	
	public ArrayList<String> getScheduleId()
	{
		ArrayList<String> scheduleIdArrayList = null;
		ScheduleDao rDao = new ScheduleDao(DataSource.getNewConnection());
		scheduleIdArrayList = rDao.getScheduleId();
				
		return scheduleIdArrayList;
	}
	
	public Schedule getSchedule(String ScheduleId)
	{
		Schedule oldSchedule=new Schedule();;
		ScheduleDao fDao = new ScheduleDao(DataSource.getNewConnection());
		oldSchedule = fDao.findById(ScheduleId);		
		return oldSchedule;
	}
	
	public String modifySchedule(Schedule newSchedule)
	{
		String ack = null;
		if(newSchedule !=null)
		{
			ScheduleDao fDao = new ScheduleDao(DataSource.getNewConnection());
			String Daoack = fDao.modifySchedule(newSchedule);
			if(Daoack!=null){
				if(Daoack.equalsIgnoreCase("Updated")){
					ack = "SCHEDULE MODIFIED SUCCESSFULLY!!!";
				}
			}
			else{
				ack="THERE IS AN ERROR";
			}
			    
		}
		else
		{
			ack ="MODIFICATION ERROR";
		}
			
			
		return ack;
	}
	
	public String removeSchedule(Schedule newSchedule)
	{
		String ack = null;
		if(newSchedule !=null)
		{
			ScheduleDao fDao = new ScheduleDao(DataSource.getNewConnection());
			String Daoack = fDao.removeSchedule(newSchedule);
			if(Daoack!=null){
				if(Daoack.equalsIgnoreCase("Deleted")){
					ack = "SCHEDULE DELETED SUCCESSFULLY!!!";
				}
			}
			else{
				ack="THERE IS AN ERROR";
			}
			    
		}
		else
		{
			ack ="DELETION ERROR";
		}
			
			
		return ack;
	}
	
}
