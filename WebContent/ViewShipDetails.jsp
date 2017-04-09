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
	<s:form action="get_ship" method="post" name="getship">
		<s:select name="ShipId" label="SELECT SHIPID" list="shipIdArrayList" onchange="fun();">  </s:select>
 	</s:form>
	<s:form method="post" name="frm_modi" >
	<s:hidden name="ShipId" value="%{oldShip.ShipId}"></s:hidden>
	<s:textfield label ="SHIPNAME" value="%{oldShip.shipName}" required="true"/>
	<s:textfield label ="SOURCE" value="%{oldShip.source}" required="true"/>
	<s:textfield label ="DESTINATION" value="%{oldShip.destination}" required="true"/>
	<s:textfield label ="TRAVEL DURATION" value="%{oldShip.travelDuration}" required="true"/>
	<s:textfield label ="SEATING CAPACITY" value="%{oldShip.seatingCapacity}" required="true"/>
	<s:textfield label ="SHIPTYPE" value="%{oldShip.shipType}" required="true"/>
	<s:textfield label ="ECONOMY CAPACITY" required="true" value="%{oldShip.economyCapacity}"/>
	<s:textfield label ="BUSINESS CAPACITY" required="true"  value="%{oldShip.businessCapacity}"/>
	<s:textfield label ="FIRST CLASS CAPACITY" required="true" value="%{oldShip.firstClassCapacity}"/>
	<s:textfield label ="ECONOMY FARE" required="true" value="%{oldShip.fareEconomy}"/>
	<s:textfield label ="BUSINESS FARE" required="true" value="%{oldShip.fareBusiness}"/>
	<s:textfield label ="FIRST CLASS FARE" required="true" value="%{oldShip.fareFirstClass}"/>

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