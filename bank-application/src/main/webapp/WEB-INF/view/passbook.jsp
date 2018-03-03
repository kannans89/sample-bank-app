<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Passbook</title>
<style type="text/css">
tr,td{

padding: 10px;

}


</style>

</head>
<body>
<s:include value="header.jsp"></s:include>
<center class="container">
	<h1>passbook</h1>
<!--      <a href="home">back</a> -->
	<table class="table table-hover">
		<tr>
			<th>amount</th>
			<th>type</th>
			<th>date</th>
			<th>time</th>
		</tr>
		
		<s:property value="transactions.amount"/>
		<s:iterator value="transactions">
			<tr>
				<td><s:property value="amount"/> </td>
				<td><s:property value="type"/> </td>
				<td><s:property value="date"/> </td>
				<td><s:property value="time"/> </td>
			</tr>

		</s:iterator>
	</table>
	
	<br>
<%-- 	<a href="external/<s:property value='fileName'/>" download>download</a> --%>

<s:form action="passbook">
<s:hidden name="postBack" value="true"/>
<s:submit value="download" cssClass="btn btn-success"/>
</s:form>

</center>

</body>
</html>