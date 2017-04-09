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
	<s:form action="dopayment" method="post">
	<s:textfield label ="CREDIT CARD NO." name="newTransaction.CreditcardNo" required="true"/>
	<sx:datetimepicker label="VALID FROM" name ="newTransaction.CreditcardValFrom"  adjustWeeks="true" displayFormat="dd-MM-yyyy" required="true"/>
	<sx:datetimepicker label="VALID TO" name ="newTransaction.CreditcardValTo"  adjustWeeks="true" displayFormat="dd-MM-yyyy" required="true"/>
	<s:textfield  label ="BALANCE" name ="newTransaction.Balance" readonly="true" />
	<s:submit name="submit" value="PAY"/>	
</s:form><br><br>
<a href="ReservationForm.jsp">GO BACK</a>
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