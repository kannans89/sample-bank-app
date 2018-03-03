<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="angular/js/jQuery.js"></script>
<constant name="struts.ui.theme" value="simple" />
<sb:head />
<body>
	<nav class="navbar navbar-inverse"
		style="background-color: green; color: white; border: none">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="home">BankOfIndia</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href="home">Home</a></li>
				<li><a href="profile">profile</a></li>
				<li><a href="passbook">passbook</a></li>
				<li><a href="transaction">Transaction</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-user"></span>
						<s:property value="account.firstName"/></a></li>
				<li><a href="logout"><span
						class="glyphicon glyphicon-log-out"></span> Logout</a></li>

			</ul>
		</div>
	</div>
	</nav>
</body>
</html>