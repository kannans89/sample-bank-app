<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="angular/js/jQuery.js"></script>
<constant name="struts.ui.theme" value="simple" />
<title>Login</title>



    <sb:head/>
<body>
<!-- 	<center> -->
	
		<div  style="margin: 70px" class="col-sm-6">
			<div Class="panel panel-primary">
				<div Class="panel-heading"><h1>login page</h1></div>
			<div Class="panel-body">

			<s:form action="login" method="post" theme="bootstrap" cssClass="form-vertical">
				<s:textfield name="userId" label="UserId"  effect="highlight" cssClass="" placeholder="user Id"/>
				<s:password name="password" label="Password"   placeholder="password"/>
				<s:submit cssClass="btn btn-primary"/>
				<s:hidden name="loginPostBack" value="true" />
			</s:form>
			<br> <font color="red"><s:property value="loginErrorMsg" /></font>
			<br> <a href="forgetPassword" style="font-weight: 700;">forget password</a>
		</div></div></div>
<!-- 		</center> -->
	
	
</body>
</html>