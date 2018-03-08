<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %> 
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password</title>
<sj:head/>
<sb:head/>
</head>
<body>
	<s:form name="form" action="forgotPasswordAction" theme="bootstrap" cssClass="form-vertical">
	<s:hidden name="postBack" value="true"></s:hidden>
	<div class="container">
        <div class="panel panel-primary">
            <div class="panel-heading">Forgot Password</div>
            <div class="panel-body">
            <h4 align="right"><a href="loginAction" class="btn btn-info">Back</a></h4>
				<table align="center">
					<tr><td><s:textfield name="accountNo" label="Enter Your Account number"></s:textfield></td></tr>
					<tr><td><s:textfield name="email" label="Enter Your Email"></s:textfield></td></tr>
					<tr><td><h4 align="center"><s:submit value="Next" Class="btn btn-primary"></s:submit></h4></td></tr>
					<s:actionerror theme="bootstrap"/>
				</table>
			</div>
			</div>
		</div>
	</s:form>
</body>
</html>