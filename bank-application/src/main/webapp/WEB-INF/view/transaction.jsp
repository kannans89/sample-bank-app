<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.errorMessage {
	color: red;
}
</style>
</head>
<body>
<s:include value="header.jsp"></s:include>
	<center>
	<div class="col-sm-5"></div>
		<div class="col-sm-2">
			<h1>Transaction</h1>
			<!-- 		<a href="home">back</a> <br> -->
			<s:form action="transaction" theme="bootstrap"
				cssClass="form-horizontal">
				<s:actionerror />
				<s:textfield name="amount" label="Amount" placeHolder="amount" />
				<s:select name="type" list="{'DEPOSITE','WITHDRAW'}"></s:select>
				<%-- 			<s:radio name="type" list="#{'1':'DEPOSITE','2':'WITHDRAW'}" value="1" ></s:radio> --%>
				<s:submit value="COMMITE" cssClass="btn btn-success" />
				<s:hidden name="postBack" value="true" />
			</s:form>
		</div>
	</center>
</body>
</html>