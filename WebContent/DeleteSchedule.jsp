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
function fun() {
	document.getschedule.submit();
}
</script>
</head>
<body onload="fun();">
<s:include value="Header.jsp" />
	<s:form action="get_schedule" method="post" name="getschedule" >
		<s:select list="scheduleIdArrayList" name="ScheduleId" onchange="fun();"></s:select>
 	</s:form>
 	
	<s:form action="delete_schedule" method="post" name="form_modi" >
	<s:textfield label ="SCHEDULE ID" value="%{oldSchedule.ScheduleId}" readonly="true"/>
	<s:textfield label ="SHIP ID" value="%{oldSchedule.ShipId}" readonly="true"/>
	<s:textfield label ="SHIP NAME" value="%{oldSchedule.ShipName}" readonly="true" />
	<s:textfield label ="ROUTE ID" value="%{oldSchedule.RouteId}" readonly="true" />
	<s:textfield label ="SUNDAY" value="%{oldSchedule.Sunday}" readonly="true" />
	<s:textfield label ="MONDAY" value="%{oldSchedule.Monday}" readonly="true" />
	<s:textfield label ="TUESDAY" value="%{oldSchedule.Tuseday}" readonly="true" />
	<s:textfield label ="WEDNESDAY" value="%{oldSchedule.Wednesday}" readonly="true" />
	<s:textfield label ="THURSDAY" value="%{oldSchedule.Thursday}" readonly="true" />
	<s:textfield label ="FRIDAY" value="%{oldSchedule.Friday}" readonly="true" />
	<s:textfield label ="SATURDAY" value="%{oldSchedule.Saturday}" readonly="true" />
	<s:submit name="submit" value="DELETE SCHEDULE"/>
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