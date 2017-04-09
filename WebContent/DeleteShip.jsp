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
	<s:form action="get_ship_del" method="post" name="getship">
		<s:select name="ShipId" label="SELECT SHIPID" list="shipIdArrayList" onchange="fun();">  </s:select>
 	</s:form>
	<s:form action="delete_ship" method="post" name="frm_del" >
	<s:hidden name="shipId" value="%{oldShip.shipId}"></s:hidden>
	<s:textfield label ="SHIP NAME" value="%{oldShip.shipName}" readonly="true"/>
	<s:textfield label ="SOURCE" value="%{oldShip.source}" readonly="true"/>
	<s:textfield label ="DESTINATION" value="%{oldShip.destination}" readonly="true"/>
	<s:textfield label ="TRAVEL DURATION" value="%{oldShip.travelDuration}" readonly="true"/>
	<s:textfield label ="SEATING CAPACITY" required="int" value="%{oldShip.seatingCapacity}" readonly="true"/>
	<s:select label ="SHIP TYPE" list="{'International', 'Domestic'}" value="%{oldShip.shipType}" readonly="true"/>
	<s:textfield label ="ECONOMY CAPACITY" required="int" value="%{oldShip.economyCapacity}" readonly="true"/>
	<s:textfield label ="BUSINESS CAPACITY" required="int" value="%{oldShip.businessCapacity}" readonly="true"/>
	<s:textfield label ="FIRST CLASS CAPACITY" required="int" value="%{oldShip.firstClassCapacity}" readonly="true"/>
	<s:textfield label ="ECONOMY FARE" required="int" value="%{oldShip.fareEconomy}" readonly="true"/>
	<s:textfield label ="BUSINESS FARE" required="int" value="%{oldShip.fareBusiness}" readonly="true"/>
	<s:textfield label ="FIRST CLASS FARE"  required="int" value="%{oldShip.fareFirstClass}" readonly="true"/>
	
	<s:submit name="submit" value="Delete"/>
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