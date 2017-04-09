package com.osrs.action;


	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpSession;

	import org.apache.struts2.interceptor.ServletRequestAware;

	import com.opensymphony.xwork2.ActionSupport;
	import com.osrs.domain.osrsTraveler;

	public class LogoutAction extends ActionSupport implements ServletRequestAware{

		HttpServletRequest request;
		@Override
		public void setServletRequest(HttpServletRequest request) {
			// TODO Auto-generated method stub
			this.request=request;
		}
		
		public String doSignOut(){
			String Response = ERROR;
			HttpSession UserSession = request.getSession(false);
			osrsTraveler User = (osrsTraveler)UserSession.getAttribute("USER");
			if(User != null){
				UserSession.removeAttribute("USER");
				UserSession.invalidate();
				Response =SUCCESS;
			}
			return Response;
		}

	}


