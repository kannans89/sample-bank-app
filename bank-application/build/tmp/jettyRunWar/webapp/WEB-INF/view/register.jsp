<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %> 
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration page</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		//for email
		$('#email').blur(function(event){
			var userEmail=$('#email').val();
			console.log(userEmail);
			$.get('emailAvailabilityAction',{email:userEmail},function(responseText){
				if(responseText=="Available") {
					$("#failImage").css("display", "none");
					$("#successImage").css("display", "block");
					$('#btn').attr("disabled",false);
				}
				else {
					$("#successImage").css("display", "none");
					$("#failImage").css("display", "block");
					$('#btn').attr("disabled",true);
				}
				console.log($('#div1').text());
			});
			//for spinner
			 $(document).ajaxStart(function(){
			        $("#wait").css("display", "block");
			 });
			 $(document).ajaxComplete(function(){
			        $("#wait").css("display", "none");
			 });
		});
		//for mobile number
		$('#mobile').blur(function(event){
			var userMobile=$('#mobile').val();
			console.log(userMobile);
			$.get('mobileAvailabilityAction',{mobile:userMobile},function(responseText){
				if(responseText=="Available") {
					$("#failImageMobile").css("display", "none");
					$("#successImageMobile").css("display", "block");
					$('#btn').attr("disabled",false);
				}
				else {
					$("#successImageMobile").css("display", "none");
					$("#failImageMobile").css("display", "block");
					$('#btn').attr("disabled",true);
				}
				console.log($('#div1').text());
			});
			//for spinner
			 $(document).ajaxStart(function(){
			        $("#waitMobile").css("display", "block");
			 });
			 $(document).ajaxComplete(function(){
			        $("#waitMobile").css("display", "none");
			 });
		});
		//for Aadhar number
		$('#aadharNo').blur(function(event){
			var userAadharNo=$('#aadharNo').val();
			console.log(userAadharNo);
			$.get('aadharNoAvailabilityAction',{aadharNo:userAadharNo},function(responseText){
				if(responseText=="Available") {
					$("#failImageAadharNo").css("display", "none");
					$("#successImageAadharNo").css("display", "block");
					$('#btn').attr("disabled",false);
				}
				else {
					$("#successImageAadharNo").css("display", "none");
					$("#failImageAadharNo").css("display", "block");
					$('#btn').attr("disabled",true);
				}
				console.log($('#div1').text());
			});
			//for spinner
			 $(document).ajaxStart(function(){
			        $("#waitAadharNo").css("display", "block");
			 });
			 $(document).ajaxComplete(function(){
			        $("#waitAadharNo").css("display", "none");
			 });
		});
		//for PAN number
		$('#panNo').blur(function(event){
			var userPanNo=$('#panNo').val();
			console.log(userPanNo);
			$.get('panNoAvailabilityAction',{panNo:userPanNo},function(responseText){
				if(responseText=="Available") {
					$("#failImagePanNo").css("display", "none");
					$("#successImagePanNo").css("display", "block");
					$('#btn').attr("disabled",false);
				}
				else {
					$("#successImagePanNo").css("display", "none");
					$("#failImagePanNo").css("display", "block");
					$('#btn').attr("disabled",true);
				}
			});
			//for spinner
			 $(document).ajaxStart(function(){
			        $("#waitPanNo").css("display", "block");
			 });
			 $(document).ajaxComplete(function(){
			        $("#waitPanNo").css("display", "none");
			 });
		});
		
	});
</script>
<sj:head/>
<sb:head/>
</head>
<body>
	<s:form name="form" action="registerAction"  method="post" enctype="multipart/form-data" theme="bootstrap" cssClass="form-horizontal">
		<div class="container">
        <div class="panel panel-primary">
        <div class="panel-heading">Registration</div>
        <div class="panel-body">
		<h4 align="right"><a href="loginAction" Class="btn btn-info">Back</a></h4>
				
		<table align="center">
		<tr><td><s:textfield name="firstName" id="firstName"  label="First Name"></s:textfield></td></tr>
		<tr><td><s:textfield name="middleName" id="middleName"  label="Middle Name"></s:textfield></td></tr>
		<tr><td><s:textfield name="lastName" id="lastName"  label="Last Name"></s:textfield></td></tr>
		
		<tr><td><s:textfield name="email" id="email" label="Email"></s:textfield></td>
			<td>
				<div id="failImage" style="display:none">
					<img src="showFail.jpg" width="30" height="30" />
				</div>
				<div id="successImage" style="display:none">
					<img src="showSuccess.jpg" width="30" height="30" />
				</div>
				<div id="wait" style="display:none">
					<img src="spinner1.gif" width="30" height="30" />
				</div>
			</td>
		</tr>
		
		<tr><td><s:textfield name="mobile" id="mobile" type="number" label="Mobile"></s:textfield></td>
			<td>
				<div id="failImageMobile" style="display:none">
					<img src="showFail.jpg" width="30" height="30" />
				</div>
				<div id="successImageMobile" style="display:none">
					<img src="showSuccess.jpg" width="30" height="30" />
				</div>
				<div id="waitMobile" style="display:none">
					<img src="spinner1.gif" width="30" height="30" />
				</div>
			</td>
		</tr>
		<tr><td><s:textarea name="address" id="address" label="Address"></s:textarea></td></tr>
		<tr><td><s:textfield name="aadharNo" id="aadharNo" type="number" label="Aadhar No"></s:textfield></td>
			<td>
				<div id="failImageAadharNo" style="display:none">
					<img src="showFail.jpg" width="30" height="30" />
				</div>
				<div id="successImageAadharNo" style="display:none">
					<img src="showSuccess.jpg" width="30" height="30" />
				</div>
				<div id="waitAadharNo" style="display:none">
					<img src="spinner1.gif" width="30" height="30" />
				</div>
			</td>
		</tr>
		<tr><td><s:textfield name="panNo" id="panNo" label="PAN No"></s:textfield></td>
			<td>
				<div id="failImagePanNo" style="display:none">
					<img src="showFail.jpg" width="30" height="30" />
				</div>
				<div id="successImagePanNo" style="display:none">
					<img src="showSuccess.jpg" width="30" height="30" />
				</div>
				<div id="waitPanNo" style="display:none">
					<img src="spinner1.gif" width="30" height="30" />
				</div>
			</td>
		</tr>
		<tr><td><s:file name="userImage" id="userImage" label="Profile Photo" ></s:file> </td></tr>
		<tr><td align="center"><img src="simple-captcha.png"/></td></tr>
		<tr><td align="center">Cannot Read? Please refresh the page..!!!</td></tr>
		<tr><td><s:textfield label="Enter Captcha" key="captchaAnswer"></s:textfield></td></tr>
		<tr><td><h4 align="center"><s:submit id="btn" value="Register" Class="btn btn-primary"></s:submit></h4></td></tr>
		<s:actionerror theme="bootstrap"/>
		<s:hidden name="postBack" value="true"></s:hidden>
		</table>
		</div>
		</div>
		</div>
	</s:form>
</body>
</html>