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

<i>ADMIN HOME PAGE</i>
<br><br>
<a href="addShip.action">ADD SHIP</a><br> 
<pre>
		<a href="admin_modify_ship.action">MODIFY SHIP</a> <br>	
		<a href="admin_delete_ship.action">DELETE SHIP</a><br>
</pre>
<br><br>
<a href="addRoute.action">ADD ROUTE</a><br> 
<pre>
		<a href="admin_modify_route.action">MODIFY ROUTE</a> <br>	
		<a href="admin_delete_route.action">DELETE ROUTE</a><br>
</pre>
<br><br>
<a href="admin_add_schedule.action">ADD SCHEDULE</a><br>
<pre>
		<a href="admin_modify_schedule.action">MODIFY SCHEDULE</a> <br>	
		<a href="admin_delete_schedule.action">DELETE SCHEDULE</a><br>
</pre>
<br><br>

<s:include value="Footer.jsp" />
</body>
</html>