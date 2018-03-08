<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %> 
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home page</title>
<sj:head/>
<sb:head/>
</head>
<body>
	<s:form action="homeAction"  theme="bootstrap" cssClass="form-horizontal">
	<div class="container">
        <div class="panel panel-primary">
            <div class="panel-heading">
            	<h4 align="center">Welcome to Santy's Bank</h4>
            </div>
            <div class="panel-body">
            	<h4>
            		<a href="profileAction" Class="btn btn-info">Profile</a>
            		<a href="passbookAction" Class="btn btn-info">PassBook</a>
            		<a href="transactionAction" Class="btn btn-info">Transaction</a>
            		<a href="logoutAction" Class="btn btn-info" style="float: right">Logout</a><br><br><br>
            	</h4>
            	
            	<table align="center">
            		<tr><td><img alt="Profile Picture" src="<s:url action='getImageAction'/>" border="2px" style="height: 200px;width: 200px"/></td></tr>
					<tr><td><h4 align="center">Mr/Miss.<s:property value="userName"/></h4></td></tr>
					<tr><td><h4 align="center">Balance:<s:property value="balance"/></h4></td></tr>
            	</table>
			</div>
		</div>
	</div>
	</s:form>
</body>
</html>