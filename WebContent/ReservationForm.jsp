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
	<s:form action="reservation" method="post">
	<s:textfield label ="USER ID" name="newReservation.UserId" value="%{#session.USER.UserCredential.userId}" readonly="true"/>
	<s:select label ="SHIP ID" name ="newReservation.ShipId" list="ShipIdArrayList" />
	<sx:datetimepicker label="DATE OF JOURNEY" name ="newReservation.DateOfJourney"  adjustWeeks="true" displayFormat="dd-MM-yyyy" required="true"/>
	<s:textfield  label ="NO. OF SEATS" name ="newReservation.NoOfSheats" required="true" />
	<s:select list="{'Economy','Business','First Class'}" name="newReservation.ReservationType" label="RESERVATION CLASS"></s:select>
	<s:submit name="submit" value="SUBMIT"/>
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