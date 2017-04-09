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
		<s:select label="SELECT SCHEDULE ID" list="scheduleIdArrayList" name="ScheduleId" onchange="fun();"></s:select>
 	</s:form>
 	
	<s:form action="modify_schedule" method="post" name="form_modi" >
	<s:textfield label ="SCHEDULE ID" name ="newSchedule.ScheduleId" value="%{oldSchedule.ScheduleId}" readonly="true"/>
	<s:textfield label ="SHIP ID" name ="newSchedule.ShipId" value="%{oldSchedule.ShipId}" readonly="true"/>
	<s:textfield label ="SHIP NAME" name ="newSchedule.ShipName" value="%{oldSchedule.ShipName}" readonly="true" />
	<s:textfield label ="ROUTE ID" name ="newSchedule.RouteId" value="%{oldSchedule.RouteId}" readonly="true" />
	<s:checkbox label ="SUNDAY" name ="newSchedule.Sunday" value="%{oldSchedule.Sunday}" />
	<s:checkbox label ="MONDAY" name ="newSchedule.Monday"  value="%{oldSchedule.Monday}"/>
	<s:checkbox label ="TUESDAY" name ="newSchedule.Tuesday" value="%{oldSchedule.Tuseday}" />
	<s:checkbox label ="WEDNESDAY" name ="newSchedule.Wednesday" value="%{oldSchedule.Wednesday}"  />
	<s:checkbox label ="THURSDAY" name ="newSchedule.Thrusday"  value="%{oldSchedule.Thursday}"/>
	<s:checkbox label ="FRIDAY" name ="newSchedule.Friday" value="%{oldSchedule.Friday}"/>
	<s:checkbox label ="SATURDAY" name ="newSchedule.Saturday" value="%{oldSchedule.Saturday}"/>
	<s:submit name="submit" value="MODIFY SCHEDULE"/>
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