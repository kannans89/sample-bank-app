<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %> 
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Print PassBook</title>
		<sj:head/>
		<sb:head/>
		<style>
        .navbar {
            margin-bottom: 0;
            border-radius: 0;
        }
        
        .row.content {
            height: 550px
        }
        
         .sidenav {
            padding-top: 20px;
            background-color: #f1f1f1;
            height:100%;
        }
        
        .panel{height:100% auto}
        
        .footer {
            background-color: #555;
            color: white;
            padding: 10px;
        }
        
        @media screen and (max-width: 767px) {
            .sidenav {
                height: auto;
                padding: 15px;
            }
            .row.content {
                height: auto;
            }
        }
        
        /* Dropdown Content (Hidden by Default) */
		.dropdown-content {
    		display: none;
    		position: absolute;
    		background-color: #f9f9f9;
    		min-width: 160px;
    		box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    		z-index: 1;
		}

		.dropdown-content a {
    		color: black;
    		padding: 12px 16px;
    		text-decoration: none;
    		display: block;
		}

		.dropdown-content a:hover {background-color: #f1f1f1}
		
		.userName a:{background-color: white;}

		.dropdown:hover .dropdown-content {
    		display: block;
		}
		
		.dropdown {
    		position: relative;
    		display: inline-block;
		}
    </style>
    <script type="text/javascript">
		var myVar=setInterval(function () {myTimer()}, 1000);
		function myTimer() {
    		var date = new Date();
    		document.getElementById("date").innerHTML = date.toLocaleString();
		}
	</script>
	</head>
	<body>
		<s:form action="passbookAction">
			<s:hidden name="postBack" value="true"></s:hidden>
	 		<div class="navbar navbar-inverse">
        		<div class="container-fluid">
            		<div class="navbar-header">
                		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
            		</div>
            		<div class="collapse navbar-collapse" id="myNavbar">
                		<ul class="nav navbar-nav">
                			<li><a href="homeAction">Home</a></li>
            				<li><a href="passbookAction">PassBook</a></li>
            				<li><a href="transactionAction">Transaction</a></li>
                		</ul>
                		<ul class="nav navbar-nav navbar-right">
                    		<li class="dropdown">
                    			<a href="profileAction"><span class="glyphicon glyphicon-user"></span> Profile</a>
                    			<div class="dropdown-content">
                    				<a href="profileAction"><span class="glyphicon glyphicon-user"></span> View Profile</a>
                    				<a href="editProfileAction"><span class="glyphicon glyphicon-user"></span> Edit Profile</a>
                    				<a href="changePasswordAction">Change Password</a>
                    			</div>
                    		</li>
                    		<li><a href="logoutAction"><span class="glyphicon glyphicon-log-in"></span> Logout </a></li>
                    		<li>
                    			<div class="userName">
                    				<a href="">Welcome  <span class="glyphicon glyphicon-user"> <s:property value="#session.userName"/></span></a>
                    				<br>
                    				<a href=""><span id="date"></span></a>
                    			</div>
                    		</li>
                		</ul>      
            		</div>
        		</div>
    		</div>
    		
    		<div class="container-fluid text-center">
        		<div class="row content">
            		<div class="col-sm-2 sidenav panel panel-primary">
                		<div class="well">
                    		<p>Links </p>
                		</div>
            		</div>
            		<div class="panel col-sm-10 text-left">
        				<div class="panel panel-primary">
        					<div class="panel-heading">PassBook Printing</div>
            				<div class="panel-body">
								<h4><s:submit value="Download" Class="btn btn-info"></s:submit></h4>
								<table class="table">
									<tr class="success">
										<th>Trans_Id</th>
										<th>Amount</th>
										<th>Trans_type</th>
										<th>Date</th>
										<th>Time</th>
									</tr>
									<s:iterator value="bankTransactions">
  									<tr class="info">
        								<td><s:property value="transactionId"></s:property></td>
        								<td><s:property value="amount"></s:property></td>
        								<td><s:property value="transactionType"></s:property></td>
        								<td><s:property value="date"></s:property></td>
        								<td><s:property value="time"></s:property></td>
    								</tr>
    								</s:iterator>
								</table>
							</div>
						</div>
                	</div>
            	</div>
        	</div>
        	
    		<div class="footer navbar-fixed-bottom">
        		<div class="container-fluid text-center">
            		<p>Copyright Santy's Bank Ltd. <a href="">Terms and Conditions</a> l <a href="">Privacy Policy</a></p>
        		</div>
    		</div>
    		
		</s:form>
	</body>
</html>