package com.osrs.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.osrs.bean.Route;
import com.osrs.bean.Ship;
import com.osrs.domain.Admin;
import com.osrs.domain.SiteUser;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
	
public class RouteAction extends ActionSupport implements ServletRequestAware,Preparable {
		
		Route newRoute;
		Route oldRoute;
		ArrayList<String> RouteIdArrayList;
		String RouteId=null;
		HttpServletRequest request;
	 //////////////////////////////////////////////	
		@Override
		public void prepare() throws Exception {
			newRoute =new Route();
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
		
		public String addRoute()
		{
			String response = null;
			Admin admin=new Admin();
			String domainResponse = admin.addRoute(newRoute);
			this.addActionMessage(domainResponse);
			response = SUCCESS;
			return response;
		}
			
		@SkipValidation
		public String getRouteIdList(){
			Admin admin=new Admin();
			RouteIdArrayList = admin.getRouteId();
			return SUCCESS;
		}
		
		public String getRoute(){
			Admin admin=new Admin();
			oldRoute = admin.getRoute(RouteId);
			return SUCCESS;
		}
		
		public String deleteRoute()
		{
			String response = null;
			Admin admin=new Admin();
			String domainResponse = admin.removeRoute(RouteId);
			this.addActionMessage(domainResponse);
			response = SUCCESS;
			return response;
		}
		
		public String modifyRoute()
		{
			String response = null;
			Admin admin=new Admin();
			String domainResponse = admin.modifyRoute(newRoute);
			this.addActionMessage(domainResponse);
			response = SUCCESS;
			return response;
		}
		
	 /////////////////////////////////////////////
		
		public Route getNewRoute() {
			return newRoute;
		}
		public void setNewRoute(Route newRoute) {
			this.newRoute = newRoute;
		}
		
		public ArrayList<String> getShipIdArrayList() {
			return RouteIdArrayList;
		}
		public void setShipIdArrayList(ArrayList<String> ShipIdArrayList) {
			this.RouteIdArrayList = ShipIdArrayList;
		}
		
		public String getShipId() {
			return RouteId;
		}
		public void setRouteId(String RouteId) {
			this.RouteId = RouteId;
		}
		public Route getOldRoute() {
			return oldRoute;
		}
		public void setOldRoute(Route oldRoute) {
			this.oldRoute = oldRoute;
		}
	}
