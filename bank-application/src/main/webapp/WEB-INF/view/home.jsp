<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:include value="header.jsp"></s:include>
<center><h1>home</h1>
<!-- <a href="profile">profile</a>| -->
<!-- <a href="passbook">passbook</a>| -->
<!-- <a href="transaction">Transaction</a>| -->
<!-- <a href="logout">Logout</a> -->
<br>
<h2>first name:<s:property value="account.firstName"/></h2>
 <h1>account no.- <s:property value="account.accNo"/><br></h1>       
          <h1> balance-      <s:property value="account.balance"/></h1><br>
<%-- <img alt="profile" width="150px"  src="external/<s:property value="account.imageName"/>"><br> --%>

<img width="120" height="150" src="<s:property value="image" />">
</center>

</body>
</html>