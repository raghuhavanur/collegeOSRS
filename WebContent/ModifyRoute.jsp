<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<s:head/>
<script type="text/javascript">
function fun() {
	documenet.getroute.submit();
}
</script>
</head>
<body onload="fun();">
<s:include value="Header.jsp" />
	<s:form action="get_route" method="post" name="getroute">
		<s:select list="RouteIdArrayList" name="RouteId" label="Select Route ID" onchange="fun();"></s:select>
 	</s:form>
 		
	<s:form action="modify_route" method="post" name="form_modi" >
	<s:textfield label ="ROUTE ID" name ="newRoute.RouteId" value="%{oldRoute.RouteId}" readonly="true"/>
	<s:textfield label ="ROUTE NAME" name ="newRoute.RouteName" value="%(oldRoute.RouteName)" />
	<s:submit name="submit" value="Modify Route"/>
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
