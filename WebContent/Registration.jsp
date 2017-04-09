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
	<s:form action="register_user" method="post">
	<s:textfield label ="FIRST NAME" name ="NewUser.FirstName" />
	<s:textfield label ="LAST NAME" name ="NewUser.LastName" />
	<sx:datetimepicker label="DATE OF BIRTH" name ="NewUser.DOB"  adjustWeeks="true" displayFormat="dd-MM-yyyy" required="true"/>
	<s:textfield  label ="AGE" name ="NewUser.Age" />
	<s:radio list="{'Male','Female'}" label="GENDER" name="NewUser.Gender" ></s:radio><br>
	<s:textarea  label ="ADDRESS" name ="NewUser.Address" />
	<s:textfield label ="PHONE NUMBER" name ="NewUser.PhoneNo" />
	<s:password label ="PASSWORD" name ="NewUser.Password" />
	<s:password label ="CONFIRM PASSWORD" name ="NewUser.RTP" />
	<%-- <s:textfield label ="" name ="NewUser.LoginStatus" /> --%>
	<s:submit name="submit" value="REGISTER"/>
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