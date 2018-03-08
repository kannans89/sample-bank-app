<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %> 
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
  <sj:head/>
  <sb:head/>
  <style type="text/css">
  	.x{
   		position: absolute;
   		top: 30%;
   		left: 30%;
   		right:30%;
	}
  	</style>
</head>
<body style="background-image:url(welcome.jpg);background-repeat: no-repeat;background-size: cover;">
<br><br><br><br><br><br><h1 align="center">Login Here...!!!</h1>
<s:form action="loginAction" name="form" theme="bootstrap" cssClass="form-horizontal">
	<div class="container col-lg-5 x">
        <div class="panel panel-primary">
            <div class="panel-heading">Login</div>
            <div class="panel-body">
			<table align="center">
				<s:hidden name="postBack" value="true"></s:hidden>
	 			<tr><td><s:textfield name="userId" label="User Id"  ></s:textfield></td></tr>
	 			<tr><td><s:password name="password" label="Password"  ></s:password></td></tr> 
				<tr><td><h4 align="center"><s:submit value="Login" Class="btn btn-primary"></s:submit></h4></td></tr>
				<tr>
					<td><h4 align="left"><a href="forgotPasswordAction">Forgot Password?</a></h4></td>
					<td><h4 align="right"><a href="registerAction">Register</a></h4></td>
				</tr>
				<s:actionmessage  theme="bootstrap"/> 
				<s:actionerror  theme="bootstrap"/>
			</table>
			</div>
		</div>
	</div>
</s:form>
</body>
</html>