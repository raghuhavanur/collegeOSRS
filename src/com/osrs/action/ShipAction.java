package com.osrs.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.osrs.bean.Ship;
import com.osrs.domain.Admin;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class ShipAction extends ActionSupport implements ServletRequestAware,Preparable {
	
	Ship newShip;
	Ship oldShip;
	ArrayList<String>  ShipIdArrayList;
	String ShipId=null;
	HttpServletRequest request;
	
	
	@Override
	public void prepare() throws Exception {
		newShip =new Ship();
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}

	@SkipValidation
	public String getInputForm(){		
		return SUCCESS;
	}
	
	@SkipValidation
	public String addShip()
	{
		String response = null;
		Admin admin=new Admin();
		String domainResponse = admin.addShip(newShip);
		this.addActionMessage(domainResponse);
		response = SUCCESS;
		return response;	 
   }
	@SkipValidation
	public String getShipIdList(){
		Admin admin=new Admin();
		ShipIdArrayList = admin.getShipId();
		System.out.println(ShipIdArrayList.toString());

		return SUCCESS;
	}
	
	public String getShip(){
		Admin admin=new Admin();
		oldShip = admin.getShip(ShipId);
		return SUCCESS;
	}
	
	public String modifyShip()
	{
		String response = null;
		newShip.setShipId(ShipId);
		Admin admin=new Admin();
		String domainResponse = admin.modifyShip(newShip);
		this.addActionMessage(domainResponse);
		response = SUCCESS;
		return response;
	}
	
	public String deleteShip()
	{
		String response = null;
		Admin admin=new Admin();
		String domainResponse = admin.removeShip(ShipId);
		this.addActionMessage(domainResponse);
		response = SUCCESS;
		return response;
	}
	
	
	public Ship getNewShip() {
		return newShip;
	}
	public void setNewShip(Ship newShip) {
		this.newShip = newShip;
	}
	
	public ArrayList<String> getShipIdArrayList() {
		return ShipIdArrayList;
	}
	public void setShipIdArrayList(ArrayList<String> ShipIdArrayList) {
		this.ShipIdArrayList = ShipIdArrayList;
	}
	
	public String getShipId() {
		return ShipId;
	}
	public void setShipId(String ShipId) {
		this.ShipId = ShipId;
	}
	public Ship getOldShip() {
		return oldShip;
	}
	public void setOldShip(Ship oldShip) {
		this.oldShip = oldShip;
	}
}
