package com.osrs.action;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import oracle.sql.DATE;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.osrs.bean.Schedule;
import com.osrs.bean.Ship;
import com.osrs.domain.Admin;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class ScheduleAction extends ActionSupport implements ServletRequestAware,Preparable {
	
	Schedule newSchedule;
	Schedule oldSchedule;
	ArrayList<String> shipIdArrayList;
	ArrayList<String> routeIdArrayList;
	ArrayList<String> scheduleIdArrayList;
	
	String ScheduleId=null;
	HttpServletRequest request;
	
 //////////////////////////////////////////////	
	@Override
	public void prepare() throws Exception {
		newSchedule =new Schedule();
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
 //////////////////////////////////////////////
	@SkipValidation
	public String getInputForm(){
		return SUCCESS;
	}
	
	public String addSchedule()
	{
		String response = null;
		Admin admin=new Admin();
		String domainResponse = admin.addSchedule(newSchedule);
		this.addActionMessage(domainResponse);
		response = SUCCESS;
		return response;
	 
	}
	
	public String getList(){
		Admin admin=new Admin();
		shipIdArrayList = admin.getShipId();
		routeIdArrayList = admin.getRouteId();
		System.out.println(shipIdArrayList.toString());
		System.out.println(routeIdArrayList.toString());
		return SUCCESS;
		}
	
	@SkipValidation
	public String getScheduleIdList(){
			Admin admin=new Admin();
			scheduleIdArrayList = admin.getScheduleId();
			return SUCCESS;
		}
	
		public String getSchedule(){
			Admin admin=new Admin();
			oldSchedule = admin.getSchedule(ScheduleId);
			return SUCCESS;
		}
		
	
	
	public String modifySchedule()
	{
		String response = null;
		Admin admin=new Admin();
		String domainResponse = admin.modifySchedule(newSchedule);
		this.addActionMessage(domainResponse);
		response = SUCCESS;
		return response;
	}
	
	public String deleteSchedule()
	{
		String response = null;
		Admin admin=new Admin();
		String domainResponse = admin.removeSchedule(ScheduleId);
		this.addActionMessage(domainResponse);
		response = SUCCESS;
		return response;
	}
	
	
	
 /////////////////////////////////////////////
	
	public Schedule getNewSchedule() {
		return newSchedule;
	}
	public void setNewSchedule(Schedule newSchedule) {
		this.newSchedule = newSchedule;
	}
	public ArrayList<String> getShipIdArrayList() {
		return shipIdArrayList;
	}
	public void setShipIdArrayList(ArrayList<String> shipIdArrayList) {
		this.shipIdArrayList = shipIdArrayList;
	}
	public ArrayList<String> getRouteIdArrayList() {
		return routeIdArrayList;
	}
	public void setRouteIdArrayList(ArrayList<String> routeIdArrayList) {
		this.routeIdArrayList = routeIdArrayList;
	}
	public Schedule getOldSchedule() {
		return oldSchedule;
	}
	public void setOldSchedule(Schedule oldSchedule) {
		this.oldSchedule = oldSchedule;
	}
	public ArrayList<String> getScheduleIdArrayList() {
		return scheduleIdArrayList;
	}
	public void setScheduleIdArrayList(ArrayList<String> scheduleIdArrayList) {
		this.scheduleIdArrayList = scheduleIdArrayList;
	}
	public String getScheduleId() {
		return ScheduleId;
	}
	public void setScheduleId(String scheduleId) {
		ScheduleId = scheduleId;
	}
	
}
