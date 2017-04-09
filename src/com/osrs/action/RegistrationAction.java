package com.osrs.action;


import javax.servlet.http.HttpServletRequest;

	import org.apache.struts2.interceptor.ServletRequestAware;
	import org.apache.struts2.interceptor.validation.SkipValidation;

	import com.opensymphony.xwork2.ActionSupport;
	import com.opensymphony.xwork2.Preparable;
	import com.osrs.bean.Traveler;
	import com.osrs.domain.SiteUser;

public class RegistrationAction extends ActionSupport implements ServletRequestAware, Preparable{

		Traveler NewUser;
		HttpServletRequest request ;
		@Override
		public void setServletRequest(HttpServletRequest request) {
			// TODO Auto-generated method stub
			this.request=request;
		}
		@Override
		public void prepare() throws Exception {
			// TODO Auto-generated method stub
			NewUser = new Traveler();
		}
		@SkipValidation
		public String getInputForm(){
			return SUCCESS;
		}
		public String doRegister(){
			String Response = null;
			SiteUser AnyBody = new SiteUser();
			String DomainResponse = AnyBody.registerTraveler(NewUser);
			this.addActionMessage(DomainResponse);
			Response = SUCCESS;
			return Response;
		}
		
		/////////////////////////////////////////////
		
		public Traveler getNewUser() {
			return NewUser;
		}
		public void setNewUser(Traveler newUser) {
			NewUser = newUser;
		}
		

	}


