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
	//alert(1);
	//document.frm_modi.disabled="false";
	document.getship.submit();
	//alert(2);
}
</script>
</head>
<body >
<s:include value="Header.jsp" />
	<s:form action="get_ship_modi" method="post" name="getship">
		<s:select name="ShipId" label="SELECT SHIPID" list="shipIdArrayList" onchange="fun();">  </s:select>
 	</s:form>
	<s:form action="modify_ship" method="post" name="frm_modi" >
	<s:hidden name="ShipId" value="%{oldShip.ShipId}"></s:hidden>
	<s:textfield label ="SHIPNAME" name ="newShip.shipName" value="%{oldShip.shipName}"/>
	<s:textfield label ="SOURCE" name ="newShip.source" value="%{oldShip.source}"/>
	<s:textfield label ="DESTINATION" name ="newShip.destination" value="%{oldShip.destination}"/>
	<s:textfield label ="TRAVEL DURATION" name ="newShip.travelDuration" value="%{oldShip.travelDuration}"/>
	<s:textfield label ="SEATING CAPACITY" name ="newShip.seatingCapacity" required="int" value="%{oldShip.seatingCapacity}"/>
	<s:select label ="SHIPTYPE" name ="newShip.shipType" list="{'International', 'Domestic'}" value="%{oldShip.shipType}"/>
	<s:textfield label ="ECONOMY CAPACITY" name ="newShip.economyCapacity" required="int" value="%{oldShip.economyCapacity}"/>
	<s:textfield label ="BUSINESS CAPACITY" name ="newShip.businessCapacity" required="int" value="%{oldShip.businessCapacity}"/>
	<s:textfield label ="FIRST CLASS CAPACITY" name ="newShip.firstClassCapacity" required="int" value="%{oldShip.firstClassCapacity}"/>
	<s:textfield label ="ECONOMY FARE" name ="newShip.fareEconomy" required="int" value="%{oldShip.fareEconomy}"/>
	<s:textfield label ="BUSINESS FARE" name ="newShip.fareBusiness" required="int" value="%{oldShip.fareBusiness}"/>
	<s:textfield label ="FIRST CLASS FARE" name ="newShip.fareFirstClass" required="int" value="%{oldShip.fareFirstClass}"/>
	
	<s:submit name="submit" value="Modify"/>
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