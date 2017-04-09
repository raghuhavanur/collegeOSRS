<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import ="com.osrs.bean.*, com.osrs.domain.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<p align="center" style="background-color: silver;">
	ONLINE SHIP RESERVATION SYSTEM
</p>
<p align="right">
<%
	osrsTraveler user = (osrsTraveler)(request.getSession(false)).getAttribute("User");
	if(user != null){
		if(user instanceof Admin){
%>
		<a href="Admin_home.jsp">Home</a> |
		<%=user.getUserCredential().getType() %> |
		<%=user.getUserCredential().getName() %> |
		<a href="Signout.action">SIGN OUT</a>
<%
		}else{
%>
		<a href="Traveler_home.jsp">Home</a> |
		<%=user.getUserCredential().getType() %> |
		<%=user.getUserCredential().getName() %> |
		<a href="Signout.action">SIGN OUT</a>
<%			
		}
	}else{
%>
	<a href="default.jsp">Home</a> |
	<a href="getInputForm.action">REGISTER NEW USER</a> | 
	<a href="getSigninForm.action">SIGN UP</a>
<%
	}
%>
</p>