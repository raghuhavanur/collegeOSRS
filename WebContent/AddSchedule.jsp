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
	<s:form action="add_schedule" method="post">
	<s:select  label ="SHIP ID" name="newSchedule.ShipId" list="shipIdArrayList" >  </s:select>
	<s:textfield label ="SHIP NAME" name ="newSchedule.ShipName" />
	<s:select  label ="ROUTE ID" name="newSchedule.RouteId" list="routeIdArrayList" >  </s:select>
	<s:checkbox label ="SUNDAY" name ="newSchedule.Sunday" checked="true"/>
	<s:checkbox label ="MONDAY" name ="newSchedule.Monday" />
	<s:checkbox label ="TUESDAY" name ="newSchedule.Tuesday" />
	<s:checkbox label ="WEDNESDAY" name ="newSchedule.Wednesday" />
	<s:checkbox label ="THURSDAY" name ="newSchedule.Thrusday" />
	<s:checkbox label ="FRIDAY" name ="newSchedule.Friday" />
	<s:checkbox label ="SATURDAY" name ="newSchedule.Saturday" />
		
	<s:submit name="submit" value="Add Schedule"/>
</s:form>
<br><br>
<s:if test="hasActionErrors()">
	<div class="errors">
    		<s:actionerror/>
  	</div>
</s:if>
<s:if test="hasActionMessages()"> 
	<div class="displayMessage">
   		<s:actionmessage/>
	</div>
</s:if>
<s:include value="Footer.jsp" />

</body>
</html>
