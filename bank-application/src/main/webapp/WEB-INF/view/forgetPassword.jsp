<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>forget password</title>
</head>
<body>

	<center>
		<h4>please, enter your email id</h4>
		<s:form action="forgetPassword" theme="bootstrap" cssClass="form-vertical">
			<s:textfield name="email" label="Email Id"/>
			<s:textfield name="userId" label="User Id"/>
			<s:hidden name="postBack" value="true"/>
			<s:submit cssClass="btn btn-success"/>
		</s:form>

	</center>

</body>
</html>