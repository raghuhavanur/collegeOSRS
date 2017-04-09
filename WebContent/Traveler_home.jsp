<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<sx:head/>
</head>
<body>
<s:include value="Header.jsp" />
<i>TRAVELER HOME PAGE</i>
<br><br>
<a href="view_ship.action">VIEW SHIP DETAILS</a><br> 
<a href="reserve_ticket.action">RESERVE SHIP TICKET</a><br> 
<a href="cancel_ticket.action">CANCEL SHIP TICKET</a><br>
<a href="view_ticket.action">VIEW MY TICKET</a><br> 
<s:include value="Footer.jsp" />
</body>
</html>