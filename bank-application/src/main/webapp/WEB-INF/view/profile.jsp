<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>profile</title>
</head>
<body>
<s:include value="header.jsp"></s:include>
<div class="container">
	<h1>profile</h1>

<!-- 	<a href="home">back</a> -->
	
	<s:form action="profile">
	  <s:hidden name="editFlag" value="true"/>
	  <s:submit value="edit" cssClass="btn btn-success"/>
	</s:form>
	
	
	<div class="col-sm-6">
	<s:form action="profile" method="post" enctype="multipart/form-data"  theme="bootstrap" cssClass="form-horizontal">
	<s:set var="readOnlyFlag">${readOnly}</s:set>

<%-- 		<s:property value='%{readOnly}'/> --%>
		<s:textfield label="first name" name="account.firstName"
			disabled='#readOnlyFlag'/>
		<s:textfield label="middle name" name="account.middleName" disabled='#readOnlyFlag'/>
		<s:textfield label="last name" name="account.lastName" disabled='#readOnlyFlag' />

		<s:textfield label="mobile no" name="account.mobileNo" disabled='#readOnlyFlag' />
		<s:textfield label="emailId" name="account.emailId" disabled='#readOnlyFlag'/>
     
		<s:textfield label="pan no" name="account.panNo" disabled='#readOnlyFlag'/>
		<s:textfield label="aadhar no" name="account.aadharNo" disabled='#readOnlyFlag'/>

		<s:textfield label="street name" name="account.address.street" disabled='#readOnlyFlag'/>
		<s:textfield label="city name" name="account.address.city" disabled='#readOnlyFlag'/>
		<s:textfield label="district name" name="account.address.district" disabled='#readOnlyFlag'/>
		<s:textfield label="state name" name="account.address.state" disabled='#readOnlyFlag' />
		<s:textfield label="zipcode" name="account.address.zipcode" disabled='#readOnlyFlag' />

		<%-- 			<s:file name="userImage" label="upload photo" value="<s:property value='account.firstName'/>"></s:file> --%>
		<s:hidden name="profilePostBack" value="true"></s:hidden>
		<s:submit disabled='#readOnlyFlag' cssClass="btn btn-success"/>

	</s:form>
	</div>
</div>


</body>
</html>