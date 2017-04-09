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
	document.getroute.submit();
	//alert(2);
}
</script>
</head>
<body >
<s:include value="Header.jsp" />
	<s:form action="get_route_del" method="post" name="getroute">
		<s:select name="routeId" label="SELECT route ID" list="routeIdArrayList" onchange="fun();">  </s:select>
 	</s:form>
	<s:form action="delete_route" method="post" name="form_rou" >
	<s:textfield label ="ROUTE ID" name ="newRoute.RouteId" value="%{oldRoute.RouteId}" readonly="true"/>
	<s:textfield label ="Route NAME" name ="newRoute.routeName" value="%{oldRoute.routeName}" readonly="true"/>
	
	<s:submit name="submit" value="Delete Route"/>
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