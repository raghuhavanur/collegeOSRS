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

	<s:form action="add_shipdetails" method="post">
	<s:textfield label ="SHIP NAME" name ="newShip.ShipName" />
	<s:textfield label ="SOURCE" name ="newShip.source" />
	<s:textfield label ="DESTINATION" name ="newShip.destination" />
	<s:textfield label ="TRAVEL DURATION" name ="newShip.travelDuration" />
	<s:textfield label ="SEATING CAPACITY" name ="newShip.seatingCapacity" required="int"/>
	<s:select label ="SHIP TYPE" name ="newShip.ShipType" list="{'International', 'Domestic'}"/>
	<s:textfield label ="ECONOMY CAPACITY" name ="newShip.economyCapacity" required="int"/>
	<s:textfield label ="BUSINESS CAPACITY" name ="newShip.businessCapacity" required="int"/>
	<s:textfield label ="FIRST CLASS CAPACITY" name ="newShip.firstClassCapacity" required="int"/>
	<s:textfield label ="ECONOMY FARE" name ="newShip.fareEconomy" required="int"/>
	<s:textfield label ="BUSINESS FARE" name ="newShip.fareBusiness" required="int"/>
	<s:textfield label ="FIRST CLASS FARE" name ="newShip.fareFirstClass" required="int" />
	
	<s:submit name="submit" value="Add Ship"/>
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