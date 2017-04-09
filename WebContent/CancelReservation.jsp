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
<script type="text/javascript">
function onload() {
	alert(l1);
	//document.frm_modi.disabled="true";
	alert(l2);
}
function fun() {
	document.getreservationid.submit();
}
</script>
</head>
<body >
<s:include value="Header.jsp" />
	<s:form action="cancelReserve" method="post" name="getreservationid">
		<s:select name="ReservationId" label="SELECT RESERVATION ID" list="ReservationIdArrayList" onchange="fun();"></s:select>
 		<s:hidden name="UserId" value="%{#session.USER.UserCredential.userId}"></s:hidden>	
 	</s:form>
	<s:form action="delete_ticket" method="post" name="frm_modi" >
	<s:textfield label ="RESERVATION ID" name ="ReservationId" value="ReservationId" readonly="true"/>
	<s:textfield label ="USER ID" name="newReservation.UserId" value="%{#session.USER.UserCredential.userId}" readonly="true"/>
	<s:textfield label ="SHIP ID" name ="newReservation.ShipId" value="%{oldReservation.ShipId}" readonly="true"/>
	<sx:textfield label="DATE OF JOURNEY" name ="newReservation.DateOfJourney" value="%{oldReservation.DateOfJourney}" readonly="true"/>
	<s:textfield  label ="NO. OF SEATS" name ="newReservation.NoOfSheats"  value="%{oldReservation.NoOfSheats}" readonly="true" />
	<s:textfield name="newReservation.ReservationType" label="RESERVATION CLASS" value="%{oldReservation.ReservationType}" readonly="true" />
	<s:textfield name="newReservation.TicketFare" label="TICKET FARE" value="%{oldReservation.TicketFare}" readonly="true" />
	
	<s:submit name="submit" value="CANCEL"/>
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