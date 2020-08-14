<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error page</title>
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
					<li class="current_page_item"><a href="index.jsp">Homepage</a></li>
					
					<li><a href="LoginController?action=loginuser" id="myBtn">Login</a></li>
					<li><a href="LoginController?action=contactus">Contact Us</a></li>
					<li><a href="LoginController?action=aboutus">About Us</a></li>
					<li><a href = "AdminController?action=AdminBack">Back</a></li>
					
				</ul>
			</div>
			
		</div>
		
	</div>
</div>
<h1>${error}</h1>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<div id="footer">
		<p>Disclaimer |Sitemap | Contact Us |© CAPGEMINI corporation. All
			rights reserved. Best viewed in 1366x768 resolution and IE 9 and
			above browserCopyright All rights reserved.</p>
	</div>
	<script src="js/script.js" type="text/javascript"></script>
</body>
</html>