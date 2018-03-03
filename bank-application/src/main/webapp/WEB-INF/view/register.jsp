<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%-- <%@ taglib uri="/struts-dojo-tags" prefix="d"%> --%>

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

<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<script>
	      $(document).ready(function() {
		$('#email').change(function(event) {
			var emailValue = $('#email').val();
			console.log(emailValue);
			$.get("CheckEmailAvailability", {
				emailId : emailValue
			}, function(responseText) {
				if (responseText == "available") {
					$('#emailCheck').html(responseText).css("color", "green");
				} else {
					$('#emailCheck').html(responseText).css("color", "red");
				}
				console.log($("#emailCheck").text());
			});
		});
	});
</script>

<script>
	      $(document).ready(function() {
		$('#panNo').change(function(event) {
			var panNoValue = $('#panNo').val();
			$.get("CheckPanNoAvailability", {
				panNo : panNoValue
			}, function(responseText) {
				if (responseText == "available") {
					$('#panNoCheck').html(responseText).css("color", "green");
				} else {
					$('#panNoCheck').html(responseText).css("color", "red");
				}
			});
		});
	});
</script>

<script>
	      $(document).ready(
			function() {
				$('#aadharNo').change(
						function(event) {
							var aadharNoValue = $('#aadharNo').val();
							$.get("CheckPanNoAvailability", {
								aadharNo : aadharNoValue
							}, function(responseText) {
								if (responseText == "available") {
									$('#aadharNoCheck').html(responseText).css(
											"color", "green");
								} else {
									$('#aadharNoCheck').html(responseText).css(
											"color", "red");
								}
							});
						});
			});
</script>




</head>
<body>
	<center>

		<h1>welcome</h1>
		<s:form action="register" method="post" enctype="multipart/form-data" >

			<s:textfield name="firstName" label="First Name"></s:textfield>
			<s:textfield name="middleName" label="Middle Name"></s:textfield>
			<s:textfield name="lastName" label="Last Name"></s:textfield>

			<s:textfield name="mobileNo" label="Mobile No." id="mobileNo"></s:textfield>
			<span id="mobileNoCheck"></span>
			<br>

			<s:textfield name="emailId" label="Email Id" id="email"></s:textfield>
			<span id="emailCheck" style="color: red"></span>
			<br>


			<s:textfield name="panNo" label="Pan No." id="panNo"></s:textfield>
			<span id="panNoCheck"></span>
			<br>

			<s:textfield name="aadharNo" label="Aadhar No." id="aadharNo"></s:textfield>
			<span id="aadharNoCheck"></span>
			<br>

			<s:textfield name="street" label="Street"></s:textfield>
			<s:textfield name="city" label="City"></s:textfield>
			<s:textfield name="district" label="District"></s:textfield>
			<s:textfield name="state" label="State"></s:textfield>
			<s:textfield name="zipcode" label="Zipcode"></s:textfield>

			<s:file name="userImage" label="upload photo"></s:file>
			<s:hidden name="postBack" value="true"></s:hidden>
			<tr>
				<td></td>
				<td><img src="simple-captcha.png" /> <br /> Cannot read?
					Press F5 to refresh.</td>

			</tr>
			<s:actionerror />
			<s:textfield label="Enter code" key="captchaAnswer" size="30" />
			<s:submit></s:submit>
		</s:form>



	</center>



</body>
</html>