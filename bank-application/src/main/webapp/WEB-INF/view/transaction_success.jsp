<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:include value="header.jsp"></s:include>

<h1>your transaction</h1>
<h3>
<font color="red"><s:property value="errorMsg" /></font>
<font color="green"><s:property value="msg"/><br></font>

<a href="home">back</a>
</h3>
</body>
</html>