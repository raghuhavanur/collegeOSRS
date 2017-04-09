package com.osrs.action;


import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpSession;

	import org.apache.struts2.interceptor.ServletRequestAware;

	import com.opensymphony.xwork2.ActionSupport;
	import com.opensymphony.xwork2.Preparable;
	import com.osrs.bean.Credential;
	import com.osrs.domain.Admin;
	import com.osrs.domain.User;
	import com.osrs.domain.SiteUser;

	public class LoginAction extends ActionSupport implements ServletRequestAware, Preparable{

		HttpServletRequest request;
		private Credential TravelerCredential;
		private String UrlToRedirect;
		
		///////////////////////////////////////
		
		@Override
		public void setServletRequest(HttpServletRequest request) {
			// TODO Auto-generated method stub
			this.request=request;
		}
		@Override
		public void prepare() throws Exception {
			// TODO Auto-generated method stub
			TravelerCredential = new Credential();
		}
		
		////////////////////////////////////////
		
		public String getInputForm(){
			return SUCCESS;
		}
		
		public String doSignin(){
			String Response = null;
			HttpSession UserSession = null;
			UserSession = request.getSession();
			SiteUser AnyBody = new SiteUser();
			String DomainResponse = AnyBody.checkCredential(TravelerCredential);
			if(DomainResponse.equals("valid")){
				UrlToRedirect =AnyBody.createNewUserSession(UserSession, TravelerCredential);
				Response = SUCCESS;
			}else{
				this.addActionMessage(DomainResponse);
				Response = ERROR;
			}
			return Response;
		}
		
		
		////////////////////////////////////////////////
		
		public Credential getTravelerCredential() {
			return TravelerCredential;
		}
		public void setUserCredential(Credential userCredential) {
			TravelerCredential = userCredential;
		}
		public String getUrlToRedirect() {
			return UrlToRedirect;
		}
		public void setUrlToRedirect(String urlToRedirect) {
			UrlToRedirect = urlToRedirect;
		}
		

	}


