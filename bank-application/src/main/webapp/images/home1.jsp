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
            height: 100%;
        }
        
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

/* Links inside the dropdown */
.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {background-color: #f1f1f1}

/* Show the dropdown menu on hover */
.dropdown:hover .dropdown-content {
    display: block;
}
.dropdown {
    position: relative;
    display: inline-block;
}
    </style>
</head>
<body>
	<s:form action="homeAction">
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
                    		<a href="editProfileAction">Edit Profile</a>
                    		<a href="changePasswordAction">Change Password</a>
                    	</div>
                    </li>
                    <li><a href="logoutAction"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="container-fluid text-center">
        <div class="row content">
            <div class="col-sm-2 sidenav">
                <div class="well">
                    <p>Links </p>
                </div>
            </div>
            <div class="col-sm-10 text-left">
                <div>
                    <h1>Welcome to Santy's bank</h1>
                   	<table align="center">
            		<tr><td><img alt="Profile Picture" src="<s:url action='getImageAction'/>" border="2px" style="height: 200px;width: 200px"/></td></tr>
					<tr><td><h4 align="center">Mr/Miss.<s:property value="userName"/></h4></td></tr>
					<tr><td><h4 align="center">Balance:<s:property value="balance"/></h4></td></tr>
            	</table>
                </div>
            </div>
             <!--<div class="col-sm-2 sidenav">
                <div class="well">
                    <p>ADS</p>
                </div>
                <div class="well">
                    <p>ADS</p>
                </div>
                <div class="well">
                    <p>ADS</p>
                </div>
            </div> -->
        </div>
    </div>
    <div class="footer navbar-fixed-bottom">
        <div class="container-fluid text-center">
            <p>Footer Text</p>
        </div>
    </div>
	</s:form>
</body>
</html>