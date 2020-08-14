<!--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
    <%@page import="com.cg.dsdemoapp.bean.*" %>           //change
    <%@page import="com.cg.dsdemoapp.dao.AdminDAO" %>  //change
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/stylesheet.css">
</head>

<body>
<div id="wrapper">
	<div id="header-wrapper">
		<div id="header" class="container">
	        
			<div id="logo">
			    
				<h1><a href="#">TECHNOSOFT</a></h1>
				
			</div>
			<div id="menu">
				<ul>
					<li class="current_page_item"><a href="AdminController?action=logout">Logout</a></li>
			    </ul>
			</div>
	</div>
</div>
</div>

<div id="content-holder">
		<marquee><h4>Welcome to TECHNOSOFT</h4></marquee>
		
</div>
<div>
</div>
<br>
<br>
<br>
<center><h3>${msg}</h3></center>

<br>
<br>
<br>
<div id="footer">
	<p>Disclaimer |Sitemap |
Contact Us |© TECHNOSOFT corporation. All rights reserved.
Best viewed in 1366x768 resolution and IE 9 and above browserCopyright All rights reserved.  </p>
</div>
<script src="js/script.js" type="text/javascript"></script>
</body>
</html>